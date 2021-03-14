package ToDoListIP;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    public void saveTaskList(String fileName, ArrayList<Task> taskList) throws IOException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(new File("src/main/resources/todolist.txt")));
        stream.writeObject(taskList);
        stream.close( );
    }

    public ArrayList<Task> load(String fileName) {
        ArrayList<Task> taskList = new ArrayList<>( );
        System.out.println("Load method called");
        try {
            try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream("src/main/resources/todolist.txt"))) {
                taskList = (ArrayList<Task>) stream.readObject( );
                System.out.println("Read object called");
                System.out.println("Task list size :" + taskList.size( ));
                for (int i = 0; i < taskList.size( ); i++)
                    System.out.println("Project name of task" + i + "=" + taskList.get(i).getProjectName( ));
                stream.close( );
            } catch (IOException e) {
                e.printStackTrace( );
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace( );
        }
        return taskList;
    }
}

