package Controller;


import PlannerTasks.Task;
import PlannerTasks.plannerTask;
import java.util.Comparator;

public class TaskCompare implements Comparator<Task> {
    
     @Override
    public int compare(Task t, Task t1) {
        int f = t.getName().compareTo(t1.getName());
         return (f != 0) ? f : t.getData().compareTo(t1.getData());
    }
    
    public static void sortForAlert(){
         Task firstElement = (Task) plannerTask.tasks.get(0);
         int size = plannerTask.tasks.size();
         if(firstElement.getStatus()){
            for(int i = 0; i < size - 2; i++){
                plannerTask.tasks.set(i, plannerTask.tasks.get(i + 1));
            }
            plannerTask.tasks.set(size - 1, firstElement);
         }
         else{
             for(int i = 0; i < size - 2; i++){
                plannerTask.tasks.set(i, plannerTask.tasks.get(i + 1));
            }
             plannerTask.tasks.remove(size - 1);
         }
    }
}
