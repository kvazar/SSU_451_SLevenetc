package Commands;


import PlannerTasks.Console;
import java.util.ArrayList;


public class Exit extends Command{

    public Exit(Console console) {
        super(console);
    }

    @Override
    public void execute(ArrayList<String>request) {
       consl.exit();
    }
    
}
