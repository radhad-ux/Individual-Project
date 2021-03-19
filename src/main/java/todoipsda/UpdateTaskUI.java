package todoipsda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * This class represents ToDoList which contains the Arraylist of task objects
 * It helps to edit the existing tasks in the Array list
 */
public class UpdateTaskUI {
    ArrayList<Task> taskListUI;
    ToDoList toDoListUI;

    public UpdateTaskUI(ArrayList<Task> tList, ToDoList tdList) {
        toDoListUI = tdList;
        taskListUI = tList;
    }

    /**
     * This method helps to edit task by receiving user input, who can choose among different choices
     * to edit the existing tasks
     */
    public void editTask() {
        int choice = 0;
        while (choice != 4) {
            out.println("************************************* ");
            out.println("Please pick your option to edit: \n");
            out.println("1)  Update a existing task");
            out.println("2)  Mark a task completed");
            out.println("3)  Delete a task");
            out.println("4)  Go back to the main menu");
            out.println("************************************* ");
            Scanner input = new Scanner(System.in);
            choice = Integer.parseInt(input.nextLine( ));
            switch (choice) {
                case 1:
                    updateTask( );
                    break;
                case 2:
                    markTaskAsDone( );
                    break;
                case 3:
                    deleteTask( );
                    break;
                case 4:
                    break;
                default:
                    out.println("Not a valid input!");
                    break;
            }
        }
    }

    /**
     * It tasks user input such as title, due date, project name, status and  update an existing task of user's choice
     */
    public void updateTask() {
        out.println("Choose a task no to update\n");
        toDoListUI.showExistingTasks( );
        Scanner input = new Scanner(System.in);
        int index = 0;
        index = Integer.parseInt(input.nextLine( ));
        if (index > 0 && index <= taskListUI.size( )) {
            out.println("Enter the title:\n");
            String title = input.nextLine( );
            taskListUI.get(index - 1).setTitle(title);

            out.println("Enter the due date in the format yyyy-MM-dd:\n: ");
            String dueDate = input.nextLine( );
            taskListUI.get(index - 1).setDueDate(LocalDate.parse(dueDate));

            out.println("Enter the project name\n: ");
            String projectName = input.nextLine( );
            taskListUI.get(index - 1).setProjectName(projectName);

            out.println("Enter the task status: Completed or Not Completed(ignore case)\n: ");
            String status = input.nextLine( );

            if (status.equalsIgnoreCase("Completed"))
                taskListUI.get(index - 1).setIsTaskDone(true);
            else if (status.equalsIgnoreCase("Not Completed"))
                taskListUI.get(index - 1).setIsTaskDone(false);
            else
                out.println("Not an appropriate input");
        }
        out.println("Task is updated Successfully \n");
        toDoListUI.showExistingTasks( );
    }

    /**
     * A method to select a particular task from Arraylist to update the status of the task as completed
     */
    public void markTaskAsDone() {
        out.println("Choose a task you want to mark as done\n ");
        toDoListUI.showExistingTasks( );
        Scanner input = new Scanner(System.in);
        int index = 0;
        index = Integer.parseInt(input.nextLine( ));
        boolean isMarkAsDone = markTaskAsDoneByIndex(index);
        toDoListUI.showExistingTasks( );
    }

    /**
     * A method to validate the task number and to mark as task completed
     */
    public boolean markTaskAsDoneByIndex(int index) {
        if (index > 0 && index <= taskListUI.size( )) {
            taskListUI.get(index - 1).setIsTaskDone(true);
            out.println("Task marked as done!");
            return true;
        } else {
            out.println("No such Task Exists");
            return false;
        }
    }

    /**
     * A method to get the user input for deleting the task at a specified index
     */
    public void deleteTask() {
        out.println("Choose a task to delete: \n");
        toDoListUI.showExistingTasks( );
        Scanner input = new Scanner(System.in);
        int index = 0;
        index = Integer.parseInt(input.nextLine( ));
        deleteTaskByIndex(index);
        out.println("Task has been deleted Successfully");
        toDoListUI.showExistingTasks( );
    }

    public void deleteTaskByIndex(int index) {
        if (index > 0 && index <= taskListUI.size( )) {
            taskListUI.remove(index - 1);
        } else
            out.println("No such Task to delete \n");
    }
}

