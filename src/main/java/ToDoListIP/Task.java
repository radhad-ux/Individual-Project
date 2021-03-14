package ToDoListIP;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Task implements Serializable
{
    private String title;
    private String projectName;
    private boolean complete;
    private LocalDate dueDate;


    public Task(String title, LocalDate dueDate, String projectName) {
        this.title = title;
        this.projectName = projectName;
        this.complete = false;
        this.dueDate = dueDate;
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

    public void setDueDate(LocalDate dueDate) throws DateTimeException {
        if(dueDate.compareTo(LocalDate.now())<0){
            throw new DateTimeException("Past date is not allowed");
        }
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dueDate = LocalDate.parse(dueDate.format(formattedDate));
    }

    @Override
    public String toString() {
        if(isTaskDone() == true)
            return  title + "\t\t" + dueDate + "\t\t" + projectName + "\t\t\t" + "Completed";
        else return title + "\t\t" + dueDate + "\t\t" + projectName + "\t\t" + "Not Completed";
    }

}

