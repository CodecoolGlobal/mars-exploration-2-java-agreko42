package com.codecool.marsexploration.data;

import java.util.Optional;

public class RoverTask {

    private Coordinate target;
    private String action;
    private Optional<Integer> duration;

    public RoverTask(Coordinate target, String action, Optional<Integer> duration) {
        this.target = target;
        this.action = action;
        this.duration = duration;
    }

    public Coordinate getTarget() {
        return target;
    }
    public void setTarget(Coordinate target) {
        this.target = target;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public Optional<Integer> getDuration() {
        return duration;
    }
    public void setDuration(Optional<Integer> duration) {
        this.duration = duration;
    }
}
