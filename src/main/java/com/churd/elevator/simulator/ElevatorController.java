package com.churd.elevator.simulator;

import com.churd.elevator.simulator.model.Elevator;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ElevatorController {

    private final Map<Integer, Elevator> _elevatorsById;
    private final ExecutorService _executorService;

    public ElevatorController() {

        _elevatorsById = new HashMap<>(ElevatorConstants.NUMBER_OF_ELEVATORS);
        for (int elevatorId=0; elevatorId < ElevatorConstants.NUMBER_OF_ELEVATORS; elevatorId++) {
            _elevatorsById.put(elevatorId, new Elevator(elevatorId));
        }
        System.out.println(_elevatorsById.size() + " elevators created");

        _executorService = Executors.newFixedThreadPool(ElevatorConstants.NUMBER_OF_ELEVATORS);
    }

    public void destroy() {
        if (null != _executorService) {
            _executorService.shutdown();
        }
    }

    /**
     * Request an unoccupied elevator closest to the requested floor.  If no elevators are unoccupied returns null.
     *
     * If an elevator is found, starts an elevator trip to handle the request in a new thread.
     *
     * @param requestedFloor
     * @return Elevator object - null if none found
     */
    public Elevator requestUnoccupiedElevator(int requestedFloor) {

        throw new UnsupportedOperationException();
        // TODO: Find the unoccupied (and in service) elevator closest to the requestedFloor
        // TODO: invoke _startElevatorTrip for that elevator (if any)
    }

    /**
     * Service was completed on an elevator, so mark the elevator as in service.
     *
     * @param elevatorId
     */
    public void serviceElevator(int elevatorId) {
        Elevator elevator = _elevatorsById.get(elevatorId);
        if (null == elevator) {
            throw new UnsupportedOperationException("Invalid elevator ID: " + elevatorId);
        }
        elevator.setInService(false);
    }

    /**
     * Start an elevator trip in a new thread.
     *
     * @param requestedFloor
     */
    private void _startElevatorTrip(int requestedFloor, Elevator elevator) {

        elevator.setOccupied(true);
        ElevatorTrip elevatorMovement = new ElevatorTrip(elevator, requestedFloor);
        _executorService.submit(elevatorMovement);
    }
}
