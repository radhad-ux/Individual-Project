import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


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
    public String getTitle(String title) {

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
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dueDate = LocalDate.parse(dueDate.format(formattedDate));
    }

    @Override
    public String toString() {
        if(isTaskDone())
            return title + "\t" + dueDate + "\t" + projectName + "\t" + "Completed";
        else return title + "\t" + dueDate + "\t" + projectName + "\t" + "Not Completed";
    }


}

