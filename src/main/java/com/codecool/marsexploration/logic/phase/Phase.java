package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Rover;

public interface Phase {
    void perform(Context context, Rover rover);
}
