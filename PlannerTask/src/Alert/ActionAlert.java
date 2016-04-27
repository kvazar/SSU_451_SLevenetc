package Alert;


import PlannerTasks.plannerTask;
import Controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class ActionAlert implements ActionListener{
    WindowAlert viewAlert;
    ActionAlert(WindowAlert aThis) {
        this.viewAlert = aThis; 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton)e.getSource();
        String clikedButtonLabel = clickedButton.getText();
        switch (clikedButtonLabel) {
            case "Defer":
                String text = viewAlert.getStr();
                Controller controller = new Controller();
        {
            try {
                controller.action("Defer " + plannerTask.tasks.get(0).getName() + " " + text);
                if(!(plannerTask.status.equals("Date incorrect")) && !(plannerTask.status.equals("Elapsed time"))){
                    viewAlert.closeWindow();
                    System.out.println("successfully");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Что - то пошло не так!!1" + ex.getMessage());
            }
        }
                break;
            case "Readily":
                plannerTask.tasks.get(0).setStatus(false);
                plannerTask.historyTasks.add(plannerTask.tasks.get(0));
                plannerTask.tasks.remove(0);
                viewAlert.closeWindow();
                System.out.println("The task is moved to the archive");
                break;
        }
    }
    
}
