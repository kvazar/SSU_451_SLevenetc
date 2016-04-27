package PlannerTasks;


import java.util.Date;


public  class Task {
    private String name;
    private String description;
    private Date date;
    private String contact;
    private boolean status;

    public Task(String name, String description, Date dataTime, String contact) {
        Date date = new Date();
        this.name = name;
        this.description = description;
        this.date = dataTime;
        this.contact = contact;
        if(date.getMonth() <= dataTime.getMonth())
            if ((date.getDay() <= dataTime.getDay()))
                if (date.getHours() <= dataTime.getHours()) 
                    if(date.getMinutes() <= dataTime.getMinutes())
                        this.status = true;                
        else
            this.status = false;
    }
    
    public Task(){
        this.status = true;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

     public boolean getStatus() {
        return status;
    }
 
    public String getContact() {
        return contact;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Date getData() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setData(Date dataTime) {
        this.date = dataTime;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    
}
