package com.churd.elevator.simulator;

import com.churd.elevator.simulator.model.Elevator;

import java.util.concurrent.Callable;

public class ElevatorTrip implements Callable {

    private final Elevator _elevator;

    public ElevatorTrip(Elevator elevator) {
        _elevator = elevator;
    }

    @Override
    public Object call() throws Exception {
        // TODO: move the elevator from the current floor to the requested floor
        // TODO: check at each floor to see if a call switch is active - if so stop and open doors
        // TODO: allow for additional stops for requested floors (floor buttons inside elevator)

        // TODO: when an elevator becomes idle (end of trip) notify the controller with an event so that any active call switches can be served

        // TODO: track floorsServed and tripsMade on elevator

        // TODO: if elevator.tripsMade % ElevatorConstants.MAINTENANCE_REQUIRED_AFTER_TRIPS == 0 then put elevator out of service for maintenance
        throw new UnsupportedOperationException();
    }
}
