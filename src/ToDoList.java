import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private int choice;
    private boolean endTask;

    public void display() {
        System.out.println("     Welcome to your To do List          ");
        System.out.println("-------------------------------------------");
        System.out.println("     1- Display List      ");
        System.out.println("     2- Add New Task      ");
        System.out.println("     3- Edit Task         ");
        System.out.println("     4- Delete Task       ");
        System.out.println("     5- Update & Exit       ");
        System.out.println("---------------------------------------------");
        System.out.println(" Enter correct option");
        choice = scanInput();
        while(!(endTask))
        {

       //Display the To do list task

            if(choice == 1)
            {
                System.out.println("Correct Choice");
                displayTask();
            }
            /*
             *  Add new task to the list
             */
            if(choice == 2)
            {
                addTask();
            }
            /*
             *  Edit the Todo List
             */
            if(choice == 3)
            {
                editTask();
            }
            /*
             * Delete the task from the list
             */
            if (choice == 4)
            {
                deleteTask();
            }
            /*
             *  Save and Exit
             */
            if(choice == 5)
            {
                updateExitTask();
            }
        }
    }
    public int scanInput()
    {
        Scanner input = new Scanner(System.in);
        int value = input.nextInt();
        return value;
    }
    /*
     * Read the input FileReader
     */
    public String scanString()
    {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        return line;
    }

    public void displayTask(){
        ArrayList<String> arr = new ArrayList<String>(  );



    }
    public void addTask(){
    }
    public void editTask(){

    }
    public void deleteTask(){

    }
    public void updateExitTask(){

    }
    public static void main(String[] args){
        ToDoList t1 = new ToDoList();
        t1.display();


    }

}
