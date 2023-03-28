package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.logic.routine.Routine;

import java.util.List;
import java.util.Random;

public class Movement implements Phase{

    @Override
    public void perform(Context context, Rover rover) {
     rover.getCurrentRoutine().move(context, rover);
    }
}
