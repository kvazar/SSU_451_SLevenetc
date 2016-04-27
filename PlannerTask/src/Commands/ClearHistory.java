
package Commands;

import PlannerTasks.Console;
import PlannerTasks.plannerTask;
import java.util.ArrayList;

public class ClearHistory extends Command{

    public ClearHistory(Console console) {
        super(console);
    }

    @Override
    public void execute(ArrayList<String> request) {
         consl.clear(plannerTask.historyTasks);
    }
}
