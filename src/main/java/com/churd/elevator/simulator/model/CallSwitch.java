package com.churd.elevator.simulator.model;

public class CallSwitch {
    private final int _floor;
    private CallSwitchOption _selectedOption;

    public CallSwitch(int floor) {
        _floor = floor;
    }

    public CallSwitchOption getSelectedOption() {
        return _selectedOption;
    }

    public void setSelectedOption(CallSwitchOption selectedOption) {
        _selectedOption = selectedOption;
    }
}
