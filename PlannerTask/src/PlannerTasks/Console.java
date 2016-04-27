package PlannerTasks;


import Controller.TaskCompare;
import Controller.Controller;
import java.util.Date;
import java.util.List;


public class Console{

   public void creat(String name, String description, Date time, String contact ){
       synchronized(plannerTask.tasks){
            Task newTask =  new Task(name, description, time, contact);
            if(newTask.getStatus()){
                plannerTask.tasks.add(newTask);
                plannerTask.status = "Task: " + name + " is Creat";
                plannerTask.tasks.sort(new TaskCompare());
            }
            else{
                plannerTask.historyTasks.add(newTask);
                plannerTask.status = "Task: " + name + " is Creat  \n "
                        + "The task is moved to the archive";
            }
       }
   } 
   
   public void defer(List<Task> task, String name, Date time){
       synchronized(plannerTask.tasks){
           Date dataTime = new Date();
           boolean flag = true;
           if(dataTime.getMonth() <= time.getMonth())
                if ((dataTime.getDay() <= time.getDay()))
                    if (dataTime.getHours() <= time.getHours()) 
                        if(dataTime.getMinutes() <= time.getMinutes()){
                            flag = false;
                            for(Task i: task){
                                if(i.getName().equals(name)){
                                    i.setData(time);
                                    plannerTask.tasks.sort(new TaskCompare());
                                    plannerTask.status = "The task has been successfully transferred";
                                }
                            }
                        }
           if(flag){
               plannerTask.status = "Elapsed time";
           }
       }       
   }
  
   public void delete(List<Task> task, String name){
       synchronized(plannerTask.tasks){
            boolean flag = false;
            for(Task i: task){
               if(i.getName().equals(name)){
                   plannerTask.tasks.remove(i);
                   if(!plannerTask.tasks.isEmpty()){
                        plannerTask.tasks.sort(new TaskCompare());
                   }
                   plannerTask.status = name + ": is Deleted";
                   flag = true;
                   break;
                }
               
            }
           if(!flag){
               plannerTask.status = name + ": is not found"; 
           }
       }      
   }
   
   public void clear(List<Task> task){
       synchronized(plannerTask.historyTasks){
           for(int i = 0; i < plannerTask.historyTasks.size(); i++){
               plannerTask.historyTasks.remove(i);
           }             
       }
    }
   
   public void exit(){
       Controller controller = new Controller();
       controller.close();
       System.exit(0);
   }
   
   public void PrintTask(String parameters){
       if(plannerTask.tasks.size() > 0){
       if("All".equals(parameters)){
           plannerTask.tasks.stream().forEach((task) -> {
               System.out.println("Name: " + task.getName() + '\n' + "Description: " +
                       task.getDescription() + '\n' + "Date: " + task.getData() + '\n' +
                       "Contact: " + task.getContact() + '\n');
           });          
       }
       else{
           boolean flag = true;
          for (Task task : plannerTask.tasks) {
              if(task.getName() == null ? parameters == null : task.getName().equals(parameters)){
                  System.out.println("Name: " + task.getName() + '\n' + "Description: " +
                       task.getDescription() + '\n' + "Date: " + task.getData() + '\n' +
                       "Contact: " + task.getContact() + "Status: " + task.getStatus());
                  flag = false;
                }  
            }
          if(flag){
              System.out.println("Task in not found");
          }
        }
       }
       else
           System.out.println("PlannerTasks is empty");
    }
   
   public void PrintTaskH(String parameters){
       if(plannerTask.historyTasks.size() > 0){
       if("All".equals(parameters)){
           plannerTask.historyTasks.stream().forEach((task) -> {
               System.out.println("Name: " + task.getName() + '\n' + "Description: " +
                       task.getDescription() + '\n' + "Date: " + task.getData() + '\n' +
                       "Contact: " + task.getContact() + '\n');
           });          
       }
       else{
           boolean flag = true;
          for (Task task : plannerTask.historyTasks) {
              if(task.getName() == null ? parameters == null : task.getName().equals(parameters)){
                  System.out.println("Name: " + task.getName() + '\n' + "Description: " +
                       task.getDescription() + '\n' + "Date: " + task.getData() + '\n' +
                       "Contact: " + task.getContact()+ "Status: " + task.getStatus());
                  flag = false;
                }  
            }
          if(flag){
              System.out.println("Task in not found");
          }
        }
       }
       else
           System.out.println("TaskHistory is empty");
    }
}
