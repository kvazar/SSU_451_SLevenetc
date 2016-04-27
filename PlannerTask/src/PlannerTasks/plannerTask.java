package PlannerTasks;


import Alert.Alert;
import Controller.Controller;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;


public class plannerTask {

    public static  List<Task> historyTasks =  Collections.synchronizedList(new ArrayList<>()); 
    public static  List<Task> tasks = Collections.synchronizedList(new ArrayList<>());       
    public static String status = " ";
 
    public static void main(String[] args) throws InterruptedException, 
            ClassNotFoundException, InstantiationException, IllegalAccessException, 
            NoSuchMethodException, IllegalArgumentException, InvocationTargetException, TransformerException{
    
      try {
          Controller controller = new Controller();
          
          controller.open();
         Thread alarmThread = new Thread(new Alert());
          alarmThread.join();
          alarmThread.start();
          Inform.printInform();
         while(true){
          Scanner scan = new Scanner(System.in);
          String s = scan.nextLine();
          controller.action(s);
          System.out.println(status);
          status = " ";
         
         }
      } catch (ParserConfigurationException | SAXException | IOException ex) {
          System.out.println(ex.getMessage());
      }
      
    }
}
    
