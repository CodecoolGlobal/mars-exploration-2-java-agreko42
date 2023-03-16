package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;

import java.util.Optional;

public class ColonizabilityAnalyzer implements Analyzer{
    @Override
    public Optional<Outcome> analyze(Context context) {
        if(isColonizable){
            return Optional.of(Outcome.COLONIZABLE);
        }

    }
}
