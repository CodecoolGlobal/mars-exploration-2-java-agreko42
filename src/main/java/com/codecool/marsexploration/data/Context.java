package com.codecool.marsexploration.data;

public class Context {


    public int stepNumber;
    public long timeout;
    public String [][] map;
    public Coordinate landingCoordinate;
    public Rover rover;
public Outcome simulationOutcome;

    public Context(long timeout, String[][] map, Coordinate landingCoordinate, Rover rover) {
        this.stepNumber = 0;
        this.timeout = timeout;
        this.map = map;
        this.landingCoordinate = landingCoordinate;
        this.rover = rover;
    }


}
