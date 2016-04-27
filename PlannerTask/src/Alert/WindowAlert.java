package Alert;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class WindowAlert extends JFrame{
        private String  strText;
        private JTextField  textDeferTime;
    public WindowAlert(String title, String description, String contact){
        setLayout(null);
        setBounds(400, 150, 80, 80);
        JButton buttonDefer = new JButton("Defer");
        JButton buttonOk = new JButton("Readily");
        JLabel labelDescripton = new JLabel("Description: " + description);
        JLabel labelContact = new JLabel("Contact: " + contact);
        JLabel informText = new JLabel(title + ": Task is run");
        textDeferTime = new JTextField ("                    ");
        labelDescripton.setBounds(80, 40, 300, 25);
        labelContact.setBounds(80, 80, 150, 25);
        informText.setBounds(158, 10, 150, 25);
        buttonDefer.setBounds(80, 150, 80, 40);
        buttonOk.setBounds(230, 150, 80, 40);
        textDeferTime.setBounds(80, 122, 90, 16);
        add(buttonDefer);
        add(buttonOk);
        add(informText);
        add(labelContact);
        add(labelDescripton);
        add(textDeferTime);

        setSize(400,250);
        setTitle(title);
        setVisible(true);
        ActionAlert actionAlert = new ActionAlert(this);
        buttonDefer.addActionListener(actionAlert);
        buttonOk.addActionListener(actionAlert);
        setResizable(false);
        
    }
    
    public void closeWindow(){
        setVisible(false);
    }
    
    public String getStr(){
       String text = textDeferTime.getText();
       return text;
    }
    public void exit(){
        System.exit(0);
    }

}
