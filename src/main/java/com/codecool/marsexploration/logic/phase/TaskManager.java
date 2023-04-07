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

        //TODO: eMu - hiermusst du wieder auf null überprüfen, weil du im Moment null tasks zulässt
        //TODO Die Gefahr dabei ist immer, dass du nicht unterscheiden könntest, ob das ein "korrekter
        //TODO null task" wäre oder irgendwo in deinem Program etwas nicht richtig initialisiert wurde
        if(rover.getCurrentTask() != null && rover.getCurrentTask().getDuration() == 0){
            rover.setCurrentTask(null);
            tasks.setCorrectTaskByOutcome(context, rover);
        }
    }




}
