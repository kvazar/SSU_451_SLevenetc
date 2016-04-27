package Commands;


import PlannerTasks.Console;
import PlannerTasks.plannerTask;
import Controller.Controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Creat extends Command{

    public Creat(Console console) {
        super(console);
    }

    @Override
   public void execute(ArrayList<String>request) {
        int size = request.size();
        String name = request.get(1);
        String description = new String();
        for(int i = 2; i < request.size() - 2; i++){
            description += request.get(i);
        }
       
        Date time = new Date();
        List<Integer> date = new ArrayList();
        date = Controller.parserDate(request.get(size - 2));
        String contact = new String();
        try{
            time.setDate((int) date.get(0));
            time.setMonth((int) date.get(1) - 1);
            time.setHours((int) date.get(2));
            time.setMinutes((int) date.get(3));
            contact = request.get(size - 1);
        
            consl.creat(name, description, time, contact);
        }
        catch(NullPointerException e){
            plannerTask.status = "Task is not created";
        }
    }
    
}
