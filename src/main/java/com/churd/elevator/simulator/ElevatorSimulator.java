package com.churd.elevator.simulator;

import com.churd.elevator.simulator.model.CallSwitch;
import com.churd.elevator.simulator.model.Elevator;
import com.churd.elevator.simulator.model.ElevatorDirection;

import java.util.HashMap;
import java.util.Map;

public class ElevatorSimulator {

    private final ElevatorController _elevatorController;
    private final Map<Integer, CallSwitch> _callSwitchesByFloor;

    public static void main(String[] args) {

        //
        // TODO: unit tests for each class - skipped tests since primarily design exercise
        //

        ElevatorSimulator simulator =  new ElevatorSimulator();
        try {
            simulator.pressCallSwitch(7, ElevatorDirection.DOWN);
        }
        finally {
            simulator.destroy();
        }
    }

    public ElevatorSimulator() {
        System.out.println("Initializing elevator simulation");

        _callSwitchesByFloor = new HashMap<>(ElevatorConstants.NUMBER_OF_FLOORS);
        for (int floor=ElevatorConstants.GROUND_FLOOR; floor <= ElevatorConstants.NUMBER_OF_FLOORS; floor++) {
            _callSwitchesByFloor.put(floor, new CallSwitch(floor));
        }
        CallSwitchLocator.getInstance().setCallSwitchesByFloor(_callSwitchesByFloor);
        System.out.println(_callSwitchesByFloor.size() + " call switches created");

        _elevatorController = new ElevatorController();
    }

    /**
     * Press the call switch for the provided floor and elevator direction (UP or DOWN).
     *
     * Note - assumes synchronized call (wait for method to complete before handling next call switch event)
     *
     * @param floor
     * @param direction
     */
    public void pressCallSwitch(int floor, ElevatorDirection direction) {
        System.out.println("Call switch pressed for floor: " + floor + ", direction: " + direction);
        CallSwitch callSwitchForFloor = _callSwitchesByFloor.get(floor);
        if (null == callSwitchForFloor) {
            throw new UnsupportedOperationException("Invalid floor: " + floor);
        }

        if (ElevatorDirection.UP == direction) {
            callSwitchForFloor.setUpPressed(true);
        }
        else {
            callSwitchForFloor.setDownPressed(true);
        }

        Elevator unoccupiedElevator = _elevatorController.requestUnoccupiedElevator(floor);
        if (null != unoccupiedElevator) {
            System.out.println("Elevator ID: " + unoccupiedElevator.getId() + " on the way");
        }
        else {
            System.out.println("No unoccupied elevators were found");
        }
    }

    public void destroy() {
        if (null != _elevatorController) {
            _elevatorController.destroy();
        }
    }
}
