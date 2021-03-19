package todoipsda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.out;

/**
 * This class represents ToDoList which contains the Arraylist of task objects
 * It adds new Todo task details to ArrayList
 */

public class ToDoList {
    ArrayList<Task> taskList1; // An array list of Task object
    String title;
    LocalDate dueDate;
    String projectName;

    /**
     * Constructor to create an object of ToDo list
     *
     * @param taskList a list of tasks
     */

    public ToDoList(ArrayList<Task> taskList) {
        this.taskList1 = taskList;
    }

    public void setListItems(ArrayList<Task> taskList) {
        this.taskList1 = taskList;
    }

    /**
     * returns the number of tasks done
     */

    public int getNumberOfTasksDone() {
        int count = 0;
        for (Task task : taskList1) {
            if (task.isTaskDone( ))
                count = count + 1;
        }
        return count;
    }

    /**
     * A method to display the contents of Array list
     * sorted by project name and due date
     */
    public void displayTask() {
        int option = 0;
        while (option != 3) {
            out.println("*********************************************");
            out.println("Please pick your option: ");
            out.println("1)  Show all the tasks by projectName");
            out.println("2)  Show all the tasks by due date");
            out.println("3)  Go back to the main menu");
            out.println("*********************************************");
            Scanner input = new Scanner(System.in);
            option = Integer.parseInt(input.nextLine( ));
            switch (option) {
                case 1:
                    displayTaskByProjectName( );
                    break;
                case 2:
                    displayTaskByDueDate( );
                    break;
                case 3:
                    break;
                default:
                    out.println("Not a valid input!");
                    break;
            }
        }
    }

    public void displayTaskByProjectName() { // todo ask nour about stay here (change it easier to test)
        out.println("Task title\t\tDue date\t\tProject name\t\tTask status");
        taskList1.stream( )
                .sorted((t1, t2) -> t1.getProjectName( ).compareToIgnoreCase(t2.getProjectName( )))
                .forEach(out::println);
    }

    public void displayTaskByDueDate() {
        out.println("Task title\t\tDue date\t\t Project name\t\t Task status");
        taskList1.stream( )
                .sorted((t1, t2) -> t1.getDueDate( ).compareTo(t2.getDueDate( )))
                .forEach(out::println);
    }

    /**
     * This method helps to get the information from the user to add new task
     * user inputs: title, due date, project name
     */
    public void addTask() {
        out.println("Enter the task title to be added");
        Scanner input = new Scanner(System.in);
        out.println("The title of the task:\n ");
        title = input.nextLine( );
        out.println("Due date of the project in the format yyyy-MM-dd:\n ");
        dueDate = LocalDate.parse(input.nextLine( ));
        out.println("The name of the project:\n ");
        projectName = input.nextLine( );
        addNewTask( );
        showExistingTasks( );// Display's the existing task list
    }

    public void addNewTask() {
        Task newTask = new Task(title, dueDate, projectName);
        taskList1.add(newTask);
        out.println("Task has been added Successfully!");
    }

    public int getSize() {
        return taskList1.size( );
    }

    /**
     * Display's the task list starting from index 1, providing an easier approach for the user to choose the
     * operation from the main menu
     */
    public void showExistingTasks() {
        out.println("Task No\t\t Task title\t\tDue date\t Project name\t\tTask status");
        for (int i = 0; i < taskList1.size( ); i++)
            out.println("\t" + (i + 1) + "\t\t" + taskList1.get(i).toString( ));
    }
}



