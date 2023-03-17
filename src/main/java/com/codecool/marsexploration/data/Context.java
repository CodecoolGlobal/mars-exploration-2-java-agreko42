package com.codecool.marsexploration.data;

public class Context {


    public int stepNumber;
    public long timeout;
    public String [][] map;
    public Coordinate landingCoordinate;
    public Rover rover;
    public Outcome simulationOutcome;
    public final int MINERALS_NEEDED_FOR_COLONIZATION;
    public final int WATER_NEEDED_FOR_COLONIZATION;


    public Context(long timeout, String[][] map, Coordinate landingCoordinate, Rover rover, int mineralsNeededForColonization, int waterNeededForColonization) {
        MINERALS_NEEDED_FOR_COLONIZATION = mineralsNeededForColonization;
        WATER_NEEDED_FOR_COLONIZATION = waterNeededForColonization;
        this.stepNumber = 0;
        this.timeout = timeout;
        this.map = map;
        this.landingCoordinate = landingCoordinate;
        this.rover = rover;
    }


}
