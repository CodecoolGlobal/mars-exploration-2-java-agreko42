package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Rover;

public class StepIncrement implements Phase{
    @Override
    public void perform(Context context, Rover rover) {
        context.setStepNumber(context.getStepNumber()+1);
    }
}
