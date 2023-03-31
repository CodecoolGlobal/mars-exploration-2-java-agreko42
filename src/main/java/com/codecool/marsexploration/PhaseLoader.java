package com.codecool.marsexploration;

import com.codecool.marsexploration.logic.analyzer.Analyzer;
import com.codecool.marsexploration.logic.analyzer.ColonizabilityAnalyzer;
import com.codecool.marsexploration.logic.analyzer.ReadyForColonistsAnalyzer;
import com.codecool.marsexploration.logic.analyzer.StructuralAnalyzer;
import com.codecool.marsexploration.logic.phase.*;
import com.codecool.marsexploration.logic.routine.RoutineFactory;
import com.codecool.marsexploration.logic.routine.TaskFactory;

import java.util.ArrayList;
import java.util.List;

public class PhaseLoader {

    public List<Phase> loadPhases () {
        List<Phase> phaseList = new ArrayList<>();

        phaseList.add(loadRoutineEvaluation());
        phaseList.add(new Movement());
        phaseList.add(new Scan());
        phaseList.add(loadAnalyzers());
        phaseList.add(new Log());
        phaseList.add(loadTaskManager());

        phaseList.add(new StepIncrement()); //must be LAST
        return phaseList;
    }

    private Analysis loadAnalyzers() {
        List<Analyzer> analyzers = new ArrayList<>();
        analyzers.add(new ColonizabilityAnalyzer());
        analyzers.add(new StructuralAnalyzer());
        analyzers.add(new ReadyForColonistsAnalyzer());

        Analysis analysis = new Analysis();
        analysis.setAllAnalyzer(analyzers);
        return analysis;
    }
    private RoutineEvaluation loadRoutineEvaluation(){
        RoutineFactory actions = new RoutineFactory();
        return new RoutineEvaluation(actions);
    }
    private TaskManager loadTaskManager(){
        TaskFactory tasks = new TaskFactory();
        return new TaskManager(tasks);
    }
}
