package com.churd.elevator.simulator;

import com.churd.elevator.simulator.model.CallSwitch;
import com.churd.elevator.simulator.model.Elevator;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSimulator {

    List<Elevator> _elevators;
    List<CallSwitch> _callSwitches;

    public static void main(String[] args) {
        ElevatorSimulator simulator = new ElevatorSimulator();
    }

    public ElevatorSimulator() {
        System.out.println("Initializing elevator simulation");

        _elevators = new ArrayList<>(ElevatorConstants.NUMBER_OF_ELEVATORS);
        for (int i=0; i < ElevatorConstants.NUMBER_OF_ELEVATORS; i++) {
            _elevators.add(new Elevator());
        }
        System.out.println(_elevators.size() + " elevators created");

        _callSwitches = new ArrayList<>(ElevatorConstants.NUMBER_OF_FLOORS);
        for (int floor=ElevatorConstants.GROUND_FLOOR; floor <= ElevatorConstants.NUMBER_OF_FLOORS; floor++) {
            _callSwitches.add(new CallSwitch(floor));
        }
        System.out.println(_callSwitches.size() + " call switches created");
    }
}
