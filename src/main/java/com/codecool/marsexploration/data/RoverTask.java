package com.codecool.marsexploration.data;

import java.util.Optional;
import java.util.OptionalInt;

public class RoverTask {

    private Coordinate target;
    private final Action action;
    private int duration;

    public RoverTask(Coordinate target, Action action) {
        this.target = target;
        this.action = action;
        this.duration = action.getDuration();
    }

    public Coordinate getTarget() {
        return target;
    }
    public void setTarget(Coordinate target) {
        this.target = target;
    }
    public Action getAction() {
        return action;
    }
    public int getDuration() {
        return duration;
    }
    public void decreaseDuration(){
        if(this.duration > 0){
            this.duration -= 1;
        }
    }
}
