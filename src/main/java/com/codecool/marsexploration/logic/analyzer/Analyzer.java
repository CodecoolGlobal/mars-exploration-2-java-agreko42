package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Outcome;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface Analyzer {
    void analyze(Context context, Map<String, Set<Coordinate>> stuffFound);
}
