import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ToDoList toDoList;
    String fileName = "src/main/resources/todolist.txt";
    private ArrayList<Task> taskList;

    public Main(ArrayList<Task> taskList, ToDoList toDoList) {
        this.taskList = taskList;
        this.toDoList = toDoList;
    }

    public void displayMainMenu() throws IOException {
        int choice = 0;
        while (!(choice == 4)) {
            int numberOfTasksDone = toDoList.getNumberOfTasksDone( );
            System.out.println("-------------------------------------------");
            System.out.println("    Hello! Welcome to your To do List      ");
            System.out.println("-------------------------------------------");
            System.out.println("You have  " + (taskList.size( ) - numberOfTasksDone)  +  "  to do and  " +
                    numberOfTasksDone + "  tasks are done!");
            System.out.println("Pick an option to perform: ");
            System.out.println("     1) Display Task List (By project name or by due date)");
            System.out.println("     2) Add New Task");
            System.out.println("     3) Edit Task (update, mark task as done, delete");
            System.out.println("     4) Save and Exit");
            System.out.println("-------------------------------------------");

            Scanner input = new Scanner(System.in);
            choice = input.nextInt( );

            switch (choice) {
                case 1:
                    toDoList.displayTask( );
                    break;
                case 2:
                    toDoList.addTask( );
                    break;
                case 3:
                    toDoList.editTask( );
                    break;
                case 4:
                    toDoList.saveTaskList(fileName);
                    System.out.println("Good Bye!");
                    break;

                default:
                    System.out.println("Not a valid input!");
                    break;

            }
        }
    }

    public static void main(String[] args) throws IOException {
        String fileName = "src/main/resources/todolist.txt"; //todo refactor this to have it once
        ArrayList<Task> taskList = new ArrayList<>( );
        ToDoList toDoList = new ToDoList(taskList);
        toDoList.load(fileName);

        Main main = new Main(taskList, toDoList);
        main.displayMainMenu( );
    }
}




