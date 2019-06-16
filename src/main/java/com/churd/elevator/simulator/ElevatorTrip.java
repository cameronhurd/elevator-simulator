package com.churd.elevator.simulator;

import com.churd.elevator.simulator.model.CallSwitch;
import com.churd.elevator.simulator.model.Elevator;
import com.churd.elevator.simulator.model.ElevatorDirection;

import java.util.Map;
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
        Map<Integer, CallSwitch> callSwitchesByFloor = CallSwitchLocator.getInstance().getCallSwitchesByFloor();

        do {
            if (_requestedFloor != _elevator.getCurrentFloor()) {
                _elevator.setCurrentFloor(_elevator.getCurrentFloor() + (direction == ElevatorDirection.UP ? 1 : -1));
                _elevator.addFloorPassed();
            }

            CallSwitch currentFloorCallSwitch = callSwitchesByFloor.get(_elevator.getCurrentFloor());
            if (null == currentFloorCallSwitch) {
                throw new UnsupportedOperationException("Invalid floor: " + _elevator.getCurrentFloor());
            }
            else if (currentFloorCallSwitch.isDirectionPressed(direction)) {
                _letPassengersIn();
                currentFloorCallSwitch.turnOffForDirection(direction);
            }

            // TODO: allow for additional stops for requested floors (floor buttons inside elevator)
        }
        while (_requestedFloor != _elevator.getCurrentFloor());

        // TODO: after let in the passenger at the requested floor - go to their requested floor (button will be pressed on elevator)
        //       this trip should also check call switches as the elevator passes each floor

        _elevator.addTrip();
        _elevator.setOccupied(false);

        // TODO: if elevator.tripsMade % ElevatorConstants.MAINTENANCE_REQUIRED_AFTER_TRIPS == 0 then put elevator out of service for maintenance

        // TODO: when an elevator becomes idle (end of trip) check for any active call switches that need to be served
        //       if any found - start a new trip to serve the request
        //       refactor by creating CallSwitchRequestHandler (Callable) which can span multiple ElevatorTrips to handle above

        // TODO: exception handling - what happens if something goes wrong - at least add logging for elevator failures with elevator details

        throw new UnsupportedOperationException();
    }

    private void _letPassengersIn() {
        _elevator.setDoorOpen(true);
        try {
            Thread.sleep(ElevatorConstants.DOORS_OPEN_FOR_MS);
        }
        catch (InterruptedException ie) {
            System.out.println("Problem occurred waiting for doors to open: " + ie.getMessage());
        }
        _elevator.setDoorOpen(false);
    }
}
