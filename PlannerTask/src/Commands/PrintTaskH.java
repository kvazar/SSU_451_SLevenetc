
package Commands;

import PlannerTasks.Console;
import java.util.ArrayList;


public class PrintTaskH extends Command{

    public PrintTaskH(Console console) {
        super(console);
    }

    @Override
    public void execute(ArrayList<String> request) {
        try{
        String param = request.get(1);
        consl.PrintTaskH(param);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
