package com.codecool.marsexploration;

import com.codecool.marsexploration.logic.phase.*;

import java.util.ArrayList;
import java.util.List;

public class PhaseLoader {

    public List<Phase> loadPhases () {
        List<Phase> phaseList = new ArrayList<>();

        phaseList.add(new Movement());
        phaseList.add(new Scan());
        phaseList.add(new Analysis());
        phaseList.add(new Log());
        phaseList.add(new StepIncrement());

        return phaseList;
    }

}
