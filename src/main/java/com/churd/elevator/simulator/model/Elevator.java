package com.churd.elevator.simulator.model;

import com.churd.elevator.simulator.ElevatorConstants;

public class Elevator {
    private final int _id;
    private int _currentFloor = ElevatorConstants.GROUND_FLOOR;
    private boolean _occupied;
    private boolean _doorOpen = false;
    private int _tripsMade = 0;
    private int _floorsPassed = 0;
    private boolean _inService = true;

    public Elevator (int id) {
        _id = id;
    }

    public int getId() {
        return _id;
    }

    public boolean isOccupied() {
        return _occupied;
    }

    public void setOccupied(boolean occupied) {
        _occupied = occupied;
    }

    public boolean isInService() {
        return _inService;
    }

    public void setInService(boolean inService) {
        _inService = inService;
    }

    public int getTripsMade() {
        return _tripsMade;
    }

    public void setTripsMade(int tripsMade) {
        _tripsMade = tripsMade;
    }

    public void addTrip() {
        _tripsMade++;
    }

    public int getFloorsPassed() {
        return _floorsPassed;
    }

    public void setFloorsPassed(int floorsPassed) {
        _floorsPassed = floorsPassed;
    }

    public void addFloorPassed() {
        _floorsPassed++;
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
