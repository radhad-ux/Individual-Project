package todoipsda;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This is a model class, it represents a Task object
 * and it contains necessary fields and methods to operate on task object
 *
 * @author Radha
 * @since 2020-03-02
 */

public class Task implements Serializable {
    private String title;
    private String projectName;
    private boolean complete;
    private LocalDate dueDate;

    /**
     * Creating an object of Task class to store details of a task
     * such as title, due date and project name
     */

    public Task(String title, LocalDate dueDate, String projectName) {
        this.title = title;
        this.projectName = projectName;
        this.complete = false;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.equals(""))
            throw new NullPointerException("Required: Title cannot be empty");
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

    public void setIsTaskDone(boolean complete) {
        this.complete = complete;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * A method to set the due date of a task
     *
     * @param dueDate ,the due date of the task in the format yyy-MM-dd
     * @throws DateTimeException if given date is a past date
     */

    public void setDueDate(LocalDate dueDate) throws DateTimeException {
        if (dueDate.compareTo(LocalDate.now( )) < 0) {
            throw new DateTimeException("Past date is not allowed");
        }
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dueDate = LocalDate.parse(dueDate.format(formattedDate));
    }

    /**
     * A method to get the task data as a formatted String to display
     *
     * @return formatted string of all fields of a task
     */

    @Override
    public String toString() {
        if (isTaskDone( ) == true)
            return title + "\t\t" + dueDate + "\t\t" + projectName + "\t\t\t" + "Completed";
        else return title + "\t\t" + dueDate + "\t\t" + projectName + "\t\t" + "Not Completed";
    }
}

