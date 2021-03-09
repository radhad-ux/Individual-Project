import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

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
            if (task.isTaskDone( )) count++;
        }
        return count;
    }

          /** Method to display task by projectName or Due date */

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
            option = input.nextInt( );
            switch (option) {
                case 1:
                    displayTaskByProjectName();
                    break;
                case 2:
                    displayTaskByDueDate( );
                    break;
                //case 3:
                default:
                    out.println("Not a valid input!");
                    break;
            }
        }
    }
     /** Display task by Project Name */

    public void displayTaskByProjectName() {
        out.println("Task title\t\tDue date\t\t Project name\t\t Task status");
        taskList.stream( )
                .sorted((t1, t2) -> t1.getProjectName( ).compareToIgnoreCase(t2.getProjectName( )))
                        .forEach(out::println);
    }

    /** Display task by Due Date */

    public void displayTaskByDueDate() {
        out.println("Task title\t\tDue date\t\t Project name\t\t Task status");
        taskList.stream( )
                .sorted((t1, t2) -> t1.getDueDate( ).compareTo(t2.getDueDate( )))
                .forEach(out::println);
    }

    /** This method adds a new task to the taskList using the User input */

    public void addTask() {
        out.println("Enter the new task to be added");
        Scanner input = new Scanner(System.in);
        out.println("The title of the task:\n ");
        String title = input.nextLine( );
        out.println("The name of the project:\n ");
        String projectName = input.nextLine( );
        out.println("Due date of the project in the format yyyy-MM-dd:\n ");
        LocalDate dueDate = LocalDate.parse(input.nextLine( ));
        Task newTask = new Task(title, projectName, dueDate);
        taskList.add(newTask);
    }

    /** This method helps to edit a task(Update,Mark as done, delete) */

    public void editTask() {
        int option = 0;

        while (option != 4) {
            out.println("************************************* ");
            out.println("Please pick your option to edit: \n");
            out.println("1)  Update a existing task");
            out.println("2)  Mark a task completed");
            out.println("3)  Delete a task");
            out.println("4)  Go back to the main menu");
            out.println("************************************* ");
            Scanner input = new Scanner(System.in);
            option = input.nextInt( );
            switch (option) {
                case 1:
                    updateTask( );
                    break;
                case 2:
                    markTaskAsDone( );
                    break;
                case 3:
                    deleteTask( );
                    break;
                default:
                    out.println("Not a valid input!");
                    break;
            }

        }
    }

    /** This method update's an existing tasks details */

    public void updateTask() {
        out.println("Choose a task no to update");
        showExistingTasks( );
        Scanner input = new Scanner(System.in);
        int index = input.nextInt( );
        if(index > 0 && index <= taskList.size( )) {
            System.out.println("Enter the title\n: ");
            String title = input.nextLine( );
            taskList.get(index - 1).setTitle(title);

            System.out.println("Enter the due date in the format yyyy-MM-dd:\n: ");
            LocalDate dueDate = LocalDate.parse(input.nextLine( ));
            taskList.get(index - 1).setDueDate(dueDate);

            System.out.println("Enter the project name\n: ");
            String projectName = input.nextLine( );
            taskList.get(index - 1).setProjectName(projectName);

            System.out.println("Enter the task status: Completed or Not Completed(ignore case)\n: ");
            String status = input.nextLine( );

            if (status.equalsIgnoreCase("Completed"))
                taskList.get(index - 1).setIsTaskDone(true);
            else if (status.equalsIgnoreCase("Not Completed"))
                taskList.get(index - 1).setIsTaskDone(false);
            else
                System.out.println("Not an appropriate input");
        }
            System.out.println("Task is updated Successfully \n");
            showExistingTasks();
        }


    public void markTaskAsDone() {
        out.println("Choose a task you want to mark as done\n ");
        showExistingTasks();
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();
        if(index >0 && index <= taskList.size()) {
            taskList.get(index - 1).setIsTaskDone(true);
        }
        else
            out.println("No such Task Exists");

        out.println("Task marked as done!");
        showExistingTasks();
    }

    public void deleteTask() {
        out.println("Choose a task to delete: \n");
        showExistingTasks( );
        Scanner input = new Scanner(System.in);
        int index = input.nextInt( );
        if (index > 0 && index <= taskList.size( )) {
            taskList.remove(index - 1);
        } else
            out.println("No such Task to delete \n");

        out.println("Task has been deleted Successfully");
        showExistingTasks( );
    }

    private void showExistingTasks() {
        out.println("Task No\t\tTask title\t\tDue date\t\t Project name\t\t Task status");
        for(int i = 0; i < taskList.size(); i++)
            out.println((i+1) + "\t\t\t" + taskList.get(i).toString());
    }

    public void saveTaskList(String fileName) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        for(Task task: taskList){
            bufferedWriter.write(task.toString());
        }
        bufferedWriter.close();
        System.out.println("All changes are saved");
    }

    public void load(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        //String line = "";
        while((bufferedReader.readLine( )) != null){
        //while((line = bufferedReader.readLine( )) != null){
           // Task task = parseDataToTask(line);
            Task task = new Task();
            taskList.add(task);
        }
        bufferedReader.close();
        }

    /*public Task parseDataToTask(String line){
        Task task = new Task();
        String[] data = line.split("\t");
        task.setTitle(data[0]);
        LocalDate dueDate = LocalDate.parse(("yyyy-MM-dd"));
        task.setDueDate(LocalDate.parse(data[1]));
        //task.setDueDate(dueDate.parse(data[1]));
        task.setProjectName(data[2]);
        if(data[3].equals("Completed")) task.setIsTaskDone(true);
        else
            task.setIsTaskDone(false);
        return task;
    }*/
}



