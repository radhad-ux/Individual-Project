package todoipsda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the Main class of the project which provides an entry point to run the program
 * It also shows the welcome information of the main menu, the commands to execute the program
 * and takes the user input as options.
 */

public class Main {
    //An object of todo list to hold all tasks and their data
    ToDoList toDoList;

    // A string to hold the data file name which contains all tasks and their applications
    String fileName = "src/main/resources/todolist.txt";

    // An array list object to hold details of a task
    ArrayList<Task> taskList;

    //An object of the file handler class to load and save the tasks
    FileHandler fileHandler;

    // An object of the update task UI class to perform edit operations on a task
    UpdateTaskUI updateTaskUI;

    /**
     * A constructor of the main class that takes in initial parameters
     *
     * @param taskList     a list of tasks
     * @param toDoList     a instance of ToDoList
     * @param fileHandler  a file to save and load data
     * @param updateTaskUI a instance of edit task
     */

    public Main(ArrayList<Task> taskList, ToDoList toDoList, FileHandler fileHandler, UpdateTaskUI updateTaskUI) {
        this.taskList = taskList;
        this.toDoList = toDoList;
        this.fileHandler = fileHandler;
        this.updateTaskUI = updateTaskUI;
    }

    /**
     * A method which prints the welcome information of the Todo list application and allows
     * the user to input the option to perform
     */

    public void displayMainMenu() throws IOException {
        int choice = 0;
        while (choice != 4) {
            int numberOfTasksDone = toDoList.getNumberOfTasksDone( );
            System.out.println("------------------------------------------------------------");
            System.out.println("          Hello! Welcome to your To do List      ");
            System.out.println("------------------------------------------------------------");
            System.out.println("You have  " + (taskList.size( ) - numberOfTasksDone) + " task to do and  " +
                    numberOfTasksDone + "  tasks are done!");
            System.out.println("Pick an option to perform: ");
            System.out.println("     1) Display Task List (By project name or by due date)\n");
            System.out.println("     2) Add New Task\n");
            System.out.println("     3) Edit Task (update, mark task as done, delete\n");
            System.out.println("     4) Save and Exit\n");
            System.out.println("------------------------------------------------------------");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt( );
            switch (choice) {
                case 1:
                    toDoList.displayTask( ); // choice 1 display task method is invoked
                    break;
                case 2:
                    toDoList.addTask( );     // choice 2 add task method is invoked
                    break;
                case 3:
                    updateTaskUI.editTask( ); // choice 3 edit task method is invoked
                    break;
                case 4:
                    fileHandler.saveTaskList(fileName, taskList); // choice 4 save task method is invoked
                    System.out.println("Good Bye!");
                    break;
                default:
                    System.out.println("Not a valid input!");
                    break;
            }
        }
    }

    /**
     * main method to run the command line based ToDo List application
     *
     * @param args array of string holding command line parameters
     */

    public static void main(String[] args) throws IOException {
        String fileName = "src/main/resources/todolist.txt";
        ArrayList<Task> taskList = new ArrayList<>( );
        ToDoList toDoList = new ToDoList(taskList);
        FileHandler fileHandler = new FileHandler( );
        taskList = fileHandler.load(fileName);        // reading the file from data file
        toDoList.setListItems(taskList);
        UpdateTaskUI updateTaskUI = new UpdateTaskUI(taskList, toDoList);
        Main main = new Main(taskList, toDoList, fileHandler, updateTaskUI);
        main.displayMainMenu( );   //  method invoked to display main menu
    }
}




