package Commands;


import PlannerTasks.Console;
import java.util.ArrayList;


public class PrintTask extends Command{

    public PrintTask(Console console) {
        super(console);
    }

    @Override
    public void execute(ArrayList<String> request) {
        String param = request.get(1);
         consl.PrintTask(param);
    }
    
}
