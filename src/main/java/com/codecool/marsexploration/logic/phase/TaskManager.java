package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.*;
import com.codecool.marsexploration.logic.routine.TaskFactory;


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
