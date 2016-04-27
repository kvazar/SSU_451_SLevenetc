
package Controller;

import static Controller.Controller.dateToString;
import static Controller.Controller.parserDate;
import PlannerTasks.Task;
import PlannerTasks.plannerTask;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class ParserXML {
    
       public void addTaskFromXML(Node node) {  
        Date time = new Date(); 
        NodeList children = node.getChildNodes();
        Task newTask = new Task();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
           
            if("name".equals(child.getNodeName()))
                newTask.setName(child.getTextContent());
                    
            if("Description".equals(child.getNodeName()))
                newTask.setDescription(child.getTextContent());           
            if("Date".equals(child.getNodeName())){
                List<Integer>intDate = new ArrayList<>();
                intDate = parserDate(child.getTextContent());
                time.setDate((int) intDate.get(0));
                time.setMonth((int) intDate.get(1) - 1);
                time.setHours((int) intDate.get(2));
                time.setMinutes((int) intDate.get(3));
                newTask.setData(time);
            }
                   
            if("Contact".equals(child.getNodeName())){
                newTask.setContact(child.getTextContent());
                Date dataTime = new Date();
                 if(dataTime.getMonth() <= time.getMonth())
                    if ((dataTime.getDay() <= time.getDay()))
                        if (dataTime.getHours() <= time.getHours()) 
                            if(dataTime.getMinutes() <= time.getMinutes())
                                plannerTask.tasks.add(newTask);
                  plannerTask.historyTasks.add(newTask);
            }

            addTaskFromXML(child);
        }
    }    
    
    public Document saveDataToXML() throws ParserConfigurationException,
            TransformerConfigurationException, TransformerException{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document document = builder.newDocument();
        Element rootElement = document.createElement("PlannerTasks");
        document.appendChild(rootElement);
        
        makeXMLData(plannerTask.tasks, document, rootElement);
        makeXMLData(plannerTask.historyTasks, document, rootElement);
        return document;
    
    }
    
    public void addElementXML(Element task,Document document, String nobeName, String vaue){
        Element name = document.createElement(nobeName);
             name.appendChild(document.createTextNode(vaue));
             task.appendChild(name);
    }
    
    private void makeXMLData(List<Task> tasks, Document document, Element rootElement){
          for(int i = 0; i < tasks.size(); i++){
            Integer id = i + 1;
            Element task = document.createElement("Task");
            rootElement.appendChild(task);
            task.setAttribute("id", id.toString());
            
            addElementXML(task, document, "name", tasks.get(i).getName());
            addElementXML(task, document, "Description", tasks.get(i).getDescription());
            addElementXML(task, document, "Date", dateToString(tasks.get(i).getData()));             
            addElementXML(task, document, "Contact", tasks.get(i).getContact());
        }
    }
    
    public void clearFile(String path){
        try {
        FileWriter fstream = new FileWriter(path);
        BufferedWriter out = new BufferedWriter(fstream); 
        out.write(""); 
         out.close();
         } catch (Exception e) 
            {System.err.println("Error in file cleaning: " + e.getMessage());}
    }
}
