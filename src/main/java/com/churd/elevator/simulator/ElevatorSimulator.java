package com.churd.elevator.simulator;

import com.churd.elevator.simulator.model.CallSwitch;
import com.churd.elevator.simulator.model.Elevator;
import com.churd.elevator.simulator.model.ElevatorDirection;

import java.util.HashMap;
import java.util.Map;

public class ElevatorSimulator {

    Map<Integer, Elevator> _elevatorsById;
    Map<Integer, CallSwitch> _callSwitchesByFloor;

    public static void main(String[] args) {
        ElevatorSimulator simulator = new ElevatorSimulator();

        simulator.pressCallSwitch(7, ElevatorDirection.DOWN);
    }

    public ElevatorSimulator() {
        System.out.println("Initializing elevator simulation");

        _elevatorsById = new HashMap<>(ElevatorConstants.NUMBER_OF_ELEVATORS);
        for (int elevatorId=0; elevatorId < ElevatorConstants.NUMBER_OF_ELEVATORS; elevatorId++) {
            _elevatorsById.put(elevatorId, new Elevator(elevatorId));
        }
        System.out.println(_elevatorsById.size() + " elevators created");

        _callSwitchesByFloor = new HashMap<>(ElevatorConstants.NUMBER_OF_FLOORS);
        for (int floor=ElevatorConstants.GROUND_FLOOR; floor <= ElevatorConstants.NUMBER_OF_FLOORS; floor++) {
            _callSwitchesByFloor.put(floor, new CallSwitch(floor));
        }
        System.out.println(_callSwitchesByFloor.size() + " call switches created");
    }

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
        // TODO: find elevator
    }

    public Elevator findUnoccupiedElevator(int floor, ElevatorDirection direction) {
        throw new UnsupportedOperationException();
        // TODO: implement
    }
}
