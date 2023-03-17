package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.logic.analyzer.Analyzer;

import java.util.List;

public class Analysis implements Phase{

    public List<Analyzer> allAnalyzer;
    @Override
    public void perform(Context context) {
/*
        while(context.simulationOutcome == null){
            for(Analyzer analyzer : allAnalyzer){
                analyzer.analyze(context);
            }

        }*/


    }


}
