import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ToDoList toDoList;
    String filename = "src/main/resources/todolist.txt";
    private ArrayList<Task> taskList;

     public Main(ArrayList<Task> taskList, ToDoList toDoList) {
         this.taskList = taskList;
         this.toDoList = toDoList;
    }
     public void displayMainMenu(){
             int choice = 0;
             boolean endTask = false;
             Scanner input = new Scanner(System.in);
             System.out.println("    Hello! Welcome to your To do List      ");
             System.out.println("-------------------------------------------");
             System.out.println("     1- Display List      ");
             System.out.println("     2- Add New Task      ");
             System.out.println("     3- Edit Task         ");
             System.out.println("     4- Delete Task       ");
             System.out.println("     5- Update & Exit     ");
             System.out.println("-------------------------------------------");
             System.out.println(" Enter correct option");
             choice = input.nextInt( );
             while (!(endTask)) {

                 if (choice == 1) {
                     displayTask( );
                 }
                 if (choice == 2) {
                     addTask( );
                 }
                 if (choice == 3)
                     editTask( );
                 if (choice == 4)
                     saveAndExitTask( );
             }
         }



    public static void main(String[] args) {


    }
}
