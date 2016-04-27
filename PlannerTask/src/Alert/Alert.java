package Alert;


import Controller.TaskCompare;
import Alert.WindowAlert;
import PlannerTasks.plannerTask;
import java.util.Date;


public class Alert implements Runnable {

    @Override
    public void run() {
        try {
         while (true) {
            Date d = new Date();
            if(!(plannerTask.tasks.isEmpty())){
                d = plannerTask.tasks.get(0).getData();
                Date date = new Date();
                //Проверка условия
               // try
                if ((d.getDay() == date.getDay())&&(d.getMonth() == date.getMonth())
                        &&(d.getHours()==date.getHours())&&(d.getMinutes()==date.getMinutes())) {
                     WindowAlert alerts = new WindowAlert(plannerTask.tasks.get(0).getName(), 
                             plannerTask.tasks.get(0).getDescription(),plannerTask.tasks.get(0).getContact());
                     TaskCompare.sortForAlert();
                     Thread.sleep(59000);
                    // Thread.
                } else {
                     Thread.sleep(900);
                }
            }
         }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
