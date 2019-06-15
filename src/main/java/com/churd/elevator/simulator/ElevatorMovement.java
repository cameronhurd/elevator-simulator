package com.churd.elevator.simulator;

import com.churd.elevator.simulator.model.Elevator;

import java.util.concurrent.Callable;

public class ElevatorMovement implements Callable {

    private final Elevator _elevator;

    public ElevatorMovement(Elevator elevator) {
        _elevator = elevator;
    }

    @Override
    public Object call() throws Exception {
        // TODO: move the elevator from the current floor to the requested floor
        // TODO: check at each floor to see if a call switch is active - if so stop and open doors
        // TODO: allow for additional stops for requested floors (floor buttons inside elevator)
        throw new UnsupportedOperationException();
    }
}
