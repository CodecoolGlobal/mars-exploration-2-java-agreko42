package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.*;
import com.codecool.marsexploration.logic.getEverythingFound;
import com.codecool.marsexploration.logic.routine.TaskFactory;

import java.util.*;
import java.util.stream.Collectors;


public class TaskManager implements Phase{
    private final TaskFactory tasks;

    public TaskManager(TaskFactory tasks) {
        this.tasks = tasks;
    }

    @Override
    public void perform(Context context, Rover rover) {

        if(rover.getCurrentTask() != null && rover.getCurrentTask().getDuration() == 0){
            rover.setCurrentTask(null);
        }
        if(rover.getCurrentTask() == null ){
            tasks.setCorrectTaskByOutcome(context, rover);
        }
    }




}
