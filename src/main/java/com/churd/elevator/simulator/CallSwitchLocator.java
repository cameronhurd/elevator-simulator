package com.churd.elevator.simulator;

import com.churd.elevator.simulator.model.CallSwitch;

import java.util.Map;

public class CallSwitchLocator {

    private static CallSwitchLocator _instance = null;

    private Map<Integer, CallSwitch> _callSwitchesByFloor;

    private CallSwitchLocator() {
    }

    public static CallSwitchLocator getInstance() {
        if (null == _instance) {
            _instance = new CallSwitchLocator();
        }
        return _instance;
    }

    public Map<Integer, CallSwitch> getCallSwitchesByFloor() {
        return _callSwitchesByFloor;
    }

    public void setCallSwitchesByFloor(Map<Integer, CallSwitch> callSwitchesByFloor) {
        _callSwitchesByFloor = callSwitchesByFloor;
    }
}
