package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Rover;

public interface Routine {
    void move(Context context, Rover rover);
}
