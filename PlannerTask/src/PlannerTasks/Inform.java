
package PlannerTasks;

public class Inform {
   static public final String WELKOM = "           Welkom! \n";
   static public final String CREAT = "Creat : For example - Creat TaskName Description1 Description2 25.4.15.20 Contacts \n";
   static public final String DEFER = "Command: For example - Defer TaskName 26.4.18.30 \n";
   static public final String DELETE = "Delete: For example - Delete TaskName \n";
   static public final String EXIT = "Exit: For example - Exit \n";
   static public final String PRINT_TASK = "PrintTask: for example - PrintTask All (or) PrintTask TaskName \n";
   static public final String PRINT_TASK_H = "PrintTaskH (for arhive): for example - PrintTask All (or) PrintTask TaskName \n";
   static public final String DATE_FORMAT = "Date format: Day.Month.Hours.Minutes \n";
   
   public static void printInform(){
       System.out.println(WELKOM + CREAT + DEFER + DELETE + EXIT + PRINT_TASK + 
               PRINT_TASK_H + DATE_FORMAT);
   }
}
