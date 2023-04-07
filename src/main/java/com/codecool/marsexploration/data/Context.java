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
    private final ColonializationRequirments colonializationRequirments;

    private Outcome simulationOutcome;
    public Context(long timeout, String[][] map, Coordinate landingCoordinate, List<Rover> rovers, ColonializationRequirments colonializationRequirments)  {
        this.colonializationRequirments = colonializationRequirments;
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
    public String[][] getMap() {
        return map;
    }
    public void setMap(String[][] map) {
        this.map = map;
    }
    public List<Depot> getDepots() {
        return depots;
    }

    public List<Rover> getRovers() {
        return rovers;
    }

    public List<Housing> getHousings() {
        return housings;
    }
    public int getMineralsNeeded() {
        return colonializationRequirments.mineralsNeeded();
    }
    public int getWaterNeeded() {
        return colonializationRequirments.waterNeeded();
    }
    public int getDepotsNeeded() {
        return colonializationRequirments.numberDepots();
    }
    public int getHousingNeeded() {
        return colonializationRequirments.numberHousing();
    }
    public Outcome getWantedOutcome() {
        return colonializationRequirments.outcome();
    }
    public Outcome getSimulationOutcome() {
        return simulationOutcome;
    }
    public void setSimulationOutcome(Outcome simulationOutcome) {
        this.simulationOutcome = simulationOutcome;
    }
}
