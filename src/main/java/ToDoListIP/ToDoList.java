package ToDoListIP;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;


public class ToDoList {
    private String fileName;
    ArrayList<Task> taskList1;

    // Constructor to create a ToDo list


    public ToDoList(ArrayList<Task> taskList) {

        this.taskList1 = taskList;
    }

    // Method to return the number of tasks done
    public void setListItems(ArrayList<Task> taskList) {
        this.taskList1 = taskList;
    }

    public int getNumberOfTasksDone() { //stay
        int count = 0;
        for (Task task : taskList1) {
            if (task.isTaskDone( ))
                count = count + 1;
        }
        return count;
    }

    /**
     * Method to display task by projectName or Due date
     */

    public void displayTask() {  // move to ui
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

    /**
     * Display task by Project Name
     */

    public void displayTaskByProjectName() { // todo ask nour about stay here (change it easier to test)
        out.println("Task title\t\tDue date\t\tProject name\t\tTask status");
        taskList1.stream( )
                .sorted((t1, t2) -> t1.getProjectName( ).compareToIgnoreCase(t2.getProjectName( )))
                .forEach(out::println);
    }

    /**
     * Display task by Due Date
     */

    public void displayTaskByDueDate() {
        out.println("Task title\t\tDue date\t\t Project name\t\t Task status");
        taskList1.stream( )
                .sorted((t1, t2) -> t1.getDueDate( ).compareTo(t2.getDueDate( )))
                .forEach(out::println);
    }

    /**
     * This method adds a new task to the taskList using the User input
     */


    public void addTask() {
        out.println("Enter the task title to be added");

        Scanner input = new Scanner(System.in);
        out.println("The title of the task:\n ");
        String title = input.nextLine( );
        out.println("Due date of the project in the format yyyy-MM-dd:\n ");
        LocalDate dueDate = LocalDate.parse(input.nextLine( ));
        out.println("The name of the project:\n ");
        String projectName = input.nextLine( );

        Task newTask = new Task(title, dueDate, projectName);
        taskList1.add(newTask);
        out.println("Task has been added Successfully!");
        showExistingTasks( );

    }

    /**
     * This method helps to edit a task(Update,Mark as done, delete)
     */


    public void showExistingTasks() {
        out.println("Task No\t  Task title\tDue date\t Project name\tTask status");
        for (int i = 0; i < taskList1.size( ); i++)
            out.println("\t" + (i + 1) + "\t\t" + taskList1.get(i).toString( ));
    }
}



