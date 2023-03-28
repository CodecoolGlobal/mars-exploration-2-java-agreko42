package com.codecool.marsexploration.data;

import java.util.List;

public class Context {
    private int stepNumber;
    private long timeout;
    private String [][] map;
    private Coordinate landingCoordinate;
    private List<Rover> rovers;
    private final int MINERALS_NEEDED_FOR_COLONIZATION;
    private final int WATER_NEEDED_FOR_COLONIZATION;
    private Outcome simulationOutcome;
    public Context(long timeout, String[][] map, Coordinate landingCoordinate, List<Rover> rovers, int mineralsNeededForColonization, int waterNeededForColonization) {
        MINERALS_NEEDED_FOR_COLONIZATION = mineralsNeededForColonization;
        WATER_NEEDED_FOR_COLONIZATION = waterNeededForColonization;
        this.stepNumber = 0;
        this.timeout = timeout;
        this.map = map;
        this.landingCoordinate = landingCoordinate;
        this.rovers = rovers;
    }

    public int getStepNumber() {
        return stepNumber;
    }
    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }
    public long getTimeout() {
        return timeout;
    }
    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }
    public String[][] getMap() {
        return map;
    }
    public void setMap(String[][] map) {
        this.map = map;
    }
    public Coordinate getLandingCoordinate() {
        return landingCoordinate;
    }
    public void setLandingCoordinate(Coordinate landingCoordinate) {
        this.landingCoordinate = landingCoordinate;
    }
    public List<Rover> getRovers() {
        return rovers;
    }
    public void addToRovers(Rover rover) {
        this.rovers.add(rover);
    }
    public int getMINERALS_NEEDED_FOR_COLONIZATION() {
        return MINERALS_NEEDED_FOR_COLONIZATION;
    }
    public int getWATER_NEEDED_FOR_COLONIZATION() {
        return WATER_NEEDED_FOR_COLONIZATION;
    }
    public Outcome getSimulationOutcome() {
        return simulationOutcome;
    }
    public void setSimulationOutcome(Outcome simulationOutcome) {
        this.simulationOutcome = simulationOutcome;
    }
}
