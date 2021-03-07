import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Task implements Serializable
{
    private String title;
    private String projectName;
    private boolean complete;
    private LocalDate dueDate;

    public Task(){

    }


    public Task(String title, String projectName, LocalDate dueDate) {
        this.title = title;
        this.projectName = projectName;
        this.complete = false;
        this.dueDate = dueDate;
    }


    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getProjectName() {

        return projectName;
    }

    public void setProjectName(String projectName) {

        this.projectName = projectName;
    }

    public boolean isTaskDone() {

        return complete;
    }

    public void setIsTaskDone(boolean complete){
        this.complete = complete;

    }

    public LocalDate getDueDate() {

        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {

        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        if(isTaskDone() == true)
            return ("\nTitle :" + title + "\nProjectName :" + projectName + "\nStatus :" + (complete ? "Completed" : "Not Completed") +
                    "\nDue Date : " + dueDate + "\n");
        else
            return null;
    }

}

