package com.churd.elevator.simulator;

import com.churd.elevator.simulator.model.Elevator;
import com.churd.elevator.simulator.model.ElevatorDirection;

import java.util.HashMap;
import java.util.Map;

public class ElevatorController {

    Map<Integer, Elevator> _elevatorsById;

    public ElevatorController() {
        System.out.println("Initializing elevator simulation");

        _elevatorsById = new HashMap<>(ElevatorConstants.NUMBER_OF_ELEVATORS);
        for (int elevatorId=0; elevatorId < ElevatorConstants.NUMBER_OF_ELEVATORS; elevatorId++) {
            _elevatorsById.put(elevatorId, new Elevator(elevatorId));
        }
        System.out.println(_elevatorsById.size() + " elevators created");
    }

    /**
     * Request an unoccupied elevator closest to the requested floor.  If no elevators are unoccupied returns null.
     *
     * If an elevator is found, starts elevator movement to handle the request in a new thread.
     *
     * @param requestedFloor
     * @param direction
     * @return Elevator object - null if none found
     */
    public Elevator requestUnoccupiedElevator(int requestedFloor, ElevatorDirection direction) {

        throw new UnsupportedOperationException();
        // TODO: Find the unoccupied elevator closest to the requestedFloor
        // TODO: invoke _startElevatorMovement for that elevator (if any)
    }

    /**
     * Start an elevators movement in a new thread.
     *
     * @param requestedFloor
     * @param direction
     */
    private void _startElevatorMovement(int requestedFloor, ElevatorDirection direction, Elevator elevator) {
        throw new UnsupportedOperationException();
        // TODO: start an elevator in a new thread
        // TODO: when an elevator becomes idle notify the controller with an event so that any active call switches can be served
    }
}