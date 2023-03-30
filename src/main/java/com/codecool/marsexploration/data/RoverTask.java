package com.codecool.marsexploration.data;

import java.util.Optional;
import java.util.OptionalInt;

public class RoverTask {

    private Coordinate target;
    private String action;
    private int duration;

    public RoverTask(Coordinate target, String action, int duration) {
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
    public int getDuration() {
        return duration;
    }
    public void decreaseDuration(){
        if(this.duration > 0){
            this.duration -= 1;
        }
    }
}
