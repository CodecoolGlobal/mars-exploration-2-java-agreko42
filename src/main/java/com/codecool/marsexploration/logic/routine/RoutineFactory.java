package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.Action;
import com.codecool.marsexploration.data.Rover;

public class RoutineFactory {
    public void setAction(Rover rover, Action action) {

        switch (action) {
            case EXPLORE:
                rover.setCurrentRoutine(new RandomExplorationRoutine());
                break;
            case GO_TO_TARGET:
                rover.setCurrentRoutine(new TargetedMovementRoutine());
                break;
            case MINE:
                rover.setCurrentRoutine(new MiningRoutine());
                break;
            case GET_WATER:
                rover.setCurrentRoutine(new WaterFetchingRoutine());
                break;
            case BUILD_DEPOT:
                rover.setCurrentRoutine(new BuildDepotRoutine());
                break;
            case BUILD_HABITAT:
                rover.setCurrentRoutine(new BuildHousingRoutine());
                break;
            case FILL_DEPOT:
                rover.setCurrentRoutine(new DepotFillingRoutine());
                break;

        }
    }
}
