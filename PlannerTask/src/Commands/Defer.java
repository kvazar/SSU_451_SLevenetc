package Commands;


import PlannerTasks.Console;
import PlannerTasks.plannerTask;
import Controller.Controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Defer extends Command{

    public Defer(Console console) {
        super(console);
    }

    @Override
    public void execute(ArrayList<String>request) {
        int size = request.size();
        String name = request.get(1);
        List<Integer> date = new ArrayList();
        try{
             Date data = new Date();
            date = Controller.parserDate(request.get(2));
            data.setDate((int) date.get(0));
            data.setMonth((int) date.get(1) - 1);
            data.setHours((int) date.get(2));
            data.setMinutes((int) date.get(3));
            plannerTask.status = "";
            consl.defer(plannerTask.tasks, name, data);
        }
        catch(IndexOutOfBoundsException | NullPointerException e){
            plannerTask.status = "Date incorrect";
            System.out.println(e.getMessage());
        }   
       // consl.defer(plannerTask.tasks, name, data);
    }
    
}
