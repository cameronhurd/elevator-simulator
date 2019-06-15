package com.churd.elevator.simulator;

import com.churd.elevator.simulator.model.Elevator;
import com.churd.elevator.simulator.model.ElevatorDirection;

import java.util.concurrent.Callable;

public class ElevatorTrip implements Callable {

    private final Elevator _elevator;
    private final int _requestedFloor;

    public ElevatorTrip(Elevator elevator, int requestedFloor) {
        _elevator = elevator;
        _requestedFloor = requestedFloor;
    }

    @Override
    public Object call() throws Exception {
        ElevatorDirection direction = _requestedFloor > _elevator.getCurrentFloor() ? ElevatorDirection.UP : ElevatorDirection.DOWN;
        while (_requestedFloor != _elevator.getCurrentFloor()) {

            _elevator.setCurrentFloor(_elevator.getCurrentFloor() + (direction == ElevatorDirection.UP ? 1 : -1));

            // TODO: check at each floor to see if a call switch is active - if so stop and open doors

            // TODO: allow for additional stops for requested floors (floor buttons inside elevator)

            _elevator.addFloorPassed();
        }

        _elevator.setDoorOpen(true);
        // TODO: wait with the doors open for some amout of time for occupants to leave
        _elevator.addTrip();
        _elevator.setOccupied(false);

        // TODO: if elevator.tripsMade % ElevatorConstants.MAINTENANCE_REQUIRED_AFTER_TRIPS == 0 then put elevator out of service for maintenance

        // TODO: when an elevator becomes idle (end of trip) notify the controller with an event so that any active call switches can be served

        throw new UnsupportedOperationException();
    }
}
