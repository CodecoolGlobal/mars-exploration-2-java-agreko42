package com.codecool.marsexploration.data;

import java.util.ArrayList;
import java.util.List;

public class Context {
    private int stepNumber;
    private long timeout;
    private String [][] map;
    private Coordinate landingCoordinate;
    private List<Rover> rovers;
    private List<Depot> depots;
    private final int MINERALS_NEEDED_FOR_COLONIZATION;
    private final int WATER_NEEDED_FOR_COLONIZATION;
    private final int WANTED_NUMBER_OF_DEPOTS;
    private Outcome simulationOutcome;
    public Context(long timeout, String[][] map, Coordinate landingCoordinate, List<Rover> rovers, int mineralsNeededForColonization, int waterNeededForColonization, int wantedNumberOfDepots) {
        MINERALS_NEEDED_FOR_COLONIZATION = mineralsNeededForColonization;
        WATER_NEEDED_FOR_COLONIZATION = waterNeededForColonization;
        WANTED_NUMBER_OF_DEPOTS = wantedNumberOfDepots;
        this.stepNumber = 0;
        this.timeout = timeout;
        this.map = map;
        this.landingCoordinate = landingCoordinate;
        this.rovers = rovers;
        this.depots = new ArrayList<>();
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
    public List<Depot> getDepots() {
        return depots;
    }
    public void addToDepots(Depot depot) {
        this.depots.add(depot);
    }
    public int getMINERALS_NEEDED_FOR_COLONIZATION() {
        return MINERALS_NEEDED_FOR_COLONIZATION;
    }
    public int getWATER_NEEDED_FOR_COLONIZATION() {
        return WATER_NEEDED_FOR_COLONIZATION;
    }
    public int getWANTED_NUMBER_OF_DEPOTS() {
        return WANTED_NUMBER_OF_DEPOTS;
    }

    public Outcome getSimulationOutcome() {
        return simulationOutcome;
    }
    public void setSimulationOutcome(Outcome simulationOutcome) {
        this.simulationOutcome = simulationOutcome;
    }
}
