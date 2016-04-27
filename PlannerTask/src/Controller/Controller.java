package Controller;

import PlannerTasks.Console;
import Commands.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class Controller {
    private ParserXML parserXML = new ParserXML();
    
    public static List<Integer> parserDate(String str){
        try{
         ArrayList date = new ArrayList();
         int param = 0;
         String[] intRawArr = str.trim().split("\\.");
       List<Integer> intList = new ArrayList<>();
        
        for (String intRaw : intRawArr) {
            intList.add(Integer.parseInt(intRaw));
        }
        return intList;
    }
        catch(NumberFormatException e){
            System.out.println("Data is entered incorrectly");
        }
        return null;
    }
    
    public ArrayList<String> parserString(String str){
          ArrayList date = new ArrayList();
         int param = 0;
         String[] requestArr = str.split(" ");
       ArrayList<String> request = new ArrayList<>();
        
       request.addAll(Arrays.asList(requestArr));

       return  request;
    }
    
    public void action(String command) {
        ArrayList<String>request = new ArrayList<>();
        request = parserString(command);
     String dir = System.getProperty("user.dir") + "/src/Commands/" + request.get(0) + ".java";
         File file = new File(dir);
         Console console = new Console();
        if (file.exists()){
            try {
                Command operation = (Command)Class.forName("Commands." + request.get(0)).
                        getConstructor(Console.class).newInstance(console);
                operation.execute(request);
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException 
                    | InvocationTargetException | ClassNotFoundException 
                    | NoSuchMethodException | SecurityException ex) {
                        System.out.println("Error: " + ex.getMessage());
                }
        }
        else{
            System.out.println("Command is not found");
        }
    }
    
    public void open() throws ParserConfigurationException, SAXException, IOException{
        File xmlFileName = new File(System.getProperty("user.dir") + "/src/PlannerTasks/" + "tasks.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        FileInputStream fin = new FileInputStream(xmlFileName);
        org.w3c.dom.Document doc = dBuilder.parse(fin, "UTF-8");
        parserXML.addTaskFromXML((Node) doc);
    }
         
    public void close() {
        String path = System.getProperty("user.dir") + "/src/PlannerTasks/" + "tasks.xml";
        parserXML.clearFile(path);
        try {
            TransformerFactory transformerFactory = TransformerFactory
                    .newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(parserXML.saveDataToXML());
            StreamResult result = new StreamResult(new File(path));   
            transformer.transform(source, result);
        } catch (TransformerConfigurationException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (TransformerException | ParserConfigurationException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
   
    public static String dateToString(Date date){
        Integer monht = date.getMonth();
        Integer day = date.getDay();
        Integer hours = date.getHours();
        Integer minutes = date.getMinutes();
        return day.toString() + "." + monht.toString() + "." + hours.toString() + 
            "." + minutes.toString();
    }
}
