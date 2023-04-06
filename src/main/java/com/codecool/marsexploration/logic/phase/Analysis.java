package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.logic.analyzer.Analyzer;
import com.codecool.marsexploration.services.getEverythingFound;

import java.util.*;

public class Analysis implements Phase{

    private List<Analyzer> allAnalyzer;
    public void setAllAnalyzer(List<Analyzer> allAnalyzer) {
        this.allAnalyzer = allAnalyzer;
    }
    @Override
    public void perform(Context context, Rover rover) {

        Map<String, Set<Coordinate>> allStuffFound = new getEverythingFound().get(context);
        for(Analyzer analyzer : allAnalyzer){
            analyzer.analyze(context, allStuffFound);
        }
    }
}
