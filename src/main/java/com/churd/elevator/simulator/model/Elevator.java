package com.churd.elevator.simulator.model;

import com.churd.elevator.simulator.ElevatorConstants;

public class Elevator {
    private final int _id;
    private int _currentFloor = ElevatorConstants.GROUND_FLOOR;
    private boolean _doorOpen = false;

    public Elevator (int id) {
        _id = id;
    }

    public int getId() {
        return _id;
    }

    public int getCurrentFloor() {
        return _currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        _currentFloor = currentFloor;
    }

    public boolean isDoorOpen() {
        return _doorOpen;
    }

    public void setDoorOpen(boolean doorOpen) {
        _doorOpen = doorOpen;
    }
}
