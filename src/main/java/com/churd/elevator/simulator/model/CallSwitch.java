package com.churd.elevator.simulator.model;

public class CallSwitch {
    private final int _floor;
    private boolean _upPressed = false;
    private boolean _downPressed = false;

    public CallSwitch(int floor) {
        _floor = floor;
    }

    public boolean isDownPressed() {
        return _downPressed;
    }

    public void setDownPressed(boolean downPressed) {
        _downPressed = downPressed;
    }

    public boolean isUpPressed() {
        return _upPressed;
    }

    public void setUpPressed(boolean upPressed) {
        _upPressed = upPressed;
    }
}
