package com.codecool.marsexploration;

import com.codecool.marsexploration.logic.analyzer.Analyzer;
import com.codecool.marsexploration.logic.analyzer.ColonizabilityAnalyzer;
import com.codecool.marsexploration.logic.phase.*;

import java.util.ArrayList;
import java.util.List;

public class PhaseLoader {

    public List<Phase> loadPhases () {
        List<Phase> phaseList = new ArrayList<>();

        phaseList.add(new RoutineEvaluation());
        phaseList.add(new Movement());
        phaseList.add(new Scan());
        phaseList.add(loadAnalyzers());
        phaseList.add(new Log());

        phaseList.add(new StepIncrement()); //must be LAST
        return phaseList;
    }

    private Analysis loadAnalyzers() {
        List<Analyzer> analyzers = new ArrayList<>();
        analyzers.add(new ColonizabilityAnalyzer());

        Analysis analysis = new Analysis();
        analysis.setAllAnalyzer(analyzers);
        return analysis;
    }
}
