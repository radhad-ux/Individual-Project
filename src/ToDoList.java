import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<Task> taskList;

    // Constructor to create a ToDo list


    public ToDoList(ArrayList<Task> taskList) {

        this.taskList = taskList;
    }
    // Method to return the number of tasks done

    public int getNumberOfTasksDone() {
        int count = 0;
        for (Task task : taskList) {
            if (task.isComplete( ))
                count++;
        }
        return count;
    }

    //
    public void displayTask() {
        int option = 0;
        while (option != 3) {
            System.out.println("*********************************************");
            System.out.println("Please pick your option: ");
            System.out.println("1)  Show all the tasks by projectName");
            System.out.println("2)  Show all the tasks by due date");
            System.out.println("3)  Go Back to the main menu");
            System.out.println("*********************************************");

            Scanner input = new Scanner(System.in);
            option = input.nextInt( );
            switch (option) {
                case 1:
                    showTaskByProjectName( );
                    break;
                case 2:
                    showTaskByDueDate( );
                    break;
                //case 3:
                default:
                    System.out.println("Not a valid input!");
                    break;
            }
        }
    }

    public void showTaskByProjectName() {
    }

    public void showTaskByDueDate() {
    }


    // This method adds a new task to the taskList using the User input

    public void addTask() {
        System.out.println("Enter the new task to be added");
        Scanner input = new Scanner(System.in);
        System.out.println("The title of the task:\n ");
        String title = input.nextLine( );
        System.out.println("The name of the project:\n ");
        String projectName = input.nextLine( );
        System.out.println("Due date of the project in the format yyyy-MM-dd:\n ");
        LocalDate dueDate = LocalDate.parse(input.nextLine( ));
        Task newTask = new Task(title, projectName, dueDate);
        taskList.add(newTask);
    }
    // This method helps to edit a task

    public void editTask() {
        //Task task = taskList.get(0);
        int option = 0;

        while (option != 4) {
            System.out.println("************************************* ");

        }
    }
}

