package Commands;


import PlannerTasks.Console;
import PlannerTasks.plannerTask;
import java.util.ArrayList;


public class Delete extends Command{

    public Delete(Console console) {
        super(console);
    }

    @Override
    public void execute(ArrayList<String>request) {
        consl.delete(plannerTask.tasks, request.get(1));
    }
    
}
