package Commands;


import PlannerTasks.Console;
import java.util.ArrayList;


abstract public class Command {
  
    abstract public void execute(ArrayList<String>request);
    protected Console consl;
    protected Command(Console console){
        consl = console;
    }
}
