package com.codecool.marsexploration.data;

public enum Action {
    EXPLORE(0),
    GO_TO_TARGET(0),
    MINE(5),
    GET_WATER(5),
    BUILD_DEPOT(3),
    FILL_DEPOT(2),
    BUILD_HABITAT(4);


    private final int duration;

    Action(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}
