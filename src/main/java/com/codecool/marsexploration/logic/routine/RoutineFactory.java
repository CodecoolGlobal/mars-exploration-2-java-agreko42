package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.Action;
import com.codecool.marsexploration.data.Rover;

public class RoutineFactory {
    public void setAction(Rover rover, Action action) {

        switch (action) {
            case EXPLORE:
                System.out.println("Exploring");
                rover.setCurrentRoutine(new RandomExplorationRoutine());
                break;
            case GO_TO_TARGET:
                System.out.println("Going to target");
                rover.setCurrentRoutine(new TargetedMovementRoutine());
                break;
            case MINE:
                System.out.println("mining minerals");
                rover.setCurrentRoutine(new MiningRoutine());
                break;
            case GET_WATER:
                rover.setCurrentRoutine(new WaterFetchingRoutine());
                break;
            case BUILD_DEPOT:
                System.out.println("building Depot");
                rover.setCurrentRoutine(new BuildDepotRoutine());
                break;
            case BUILD_HABITAT:
                System.out.println("building habitat");
                rover.setCurrentRoutine(new BuildHousingRoutine());
                break;
            case FILL_DEPOT:
                System.out.println("filling depot");
                rover.setCurrentRoutine(new DepotFillingRoutine());
                break;

        }
    }
}
