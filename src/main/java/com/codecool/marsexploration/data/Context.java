package com.codecool.marsexploration.data;

import java.util.ArrayList;
import java.util.List;

public class Context {
    private int stepNumber;
    private long timeout;
    private String [][] map;
    private Coordinate landingCoordinate;
    private List<Rover> rovers;
    private List<Housing> housings;
    private List<Depot> depots;
    private final int MINERALS_NEEDED_FOR_COLONIZATION;
    private final int WATER_NEEDED_FOR_COLONIZATION;
    private final int NEEDED_HOUSING;
    private final int WANTED_NUMBER_OF_DEPOTS;
    private final Outcome WANTED_OUTCOME;
    private Outcome simulationOutcome;
    public Context(long timeout, String[][] map, Coordinate landingCoordinate, List<Rover> rovers, int mineralsNeededForColonization, int waterNeededForColonization, int neededHousing, int wantedNumberOfDepots, Outcome wantedOutcome) {
        MINERALS_NEEDED_FOR_COLONIZATION = mineralsNeededForColonization;
        WATER_NEEDED_FOR_COLONIZATION = waterNeededForColonization;
        NEEDED_HOUSING = neededHousing;
        WANTED_NUMBER_OF_DEPOTS = wantedNumberOfDepots;
        WANTED_OUTCOME = wantedOutcome;
        this.stepNumber = 0;
        this.timeout = timeout;
        this.map = map;
        this.landingCoordinate = landingCoordinate;
        this.rovers = rovers;
        this.depots = new ArrayList<>();
        this.housings = new ArrayList<>();
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

    public List<Housing> getHousings() {
        return housings;
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
    public int getNEEDED_HOUSING() {
        return NEEDED_HOUSING;
    }
    public Outcome getWANTED_OUTCOME() {
        return WANTED_OUTCOME;
    }
    public Outcome getSimulationOutcome() {
        return simulationOutcome;
    }
    public void setSimulationOutcome(Outcome simulationOutcome) {
        this.simulationOutcome = simulationOutcome;
    }
}
