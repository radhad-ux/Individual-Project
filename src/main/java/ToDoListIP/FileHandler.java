package ToDoListIP;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    public void saveTaskList(String fileName, ArrayList<Task> taskList) throws IOException
    {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(new File("todolist.txt")));

        stream.writeObject(taskList);
        stream.close();

    }

    public ArrayList<Task> load(String fileName)
    {
        ArrayList<Task> taskList = new ArrayList<>(  );
        try {
            try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(new File("todolist.txt")))) {

                taskList = (ArrayList<Task>) stream.readObject( );
                stream.close( );
            } catch (IOException e) {
                e.printStackTrace( );
            }

        }
        catch (ClassNotFoundException e) {
            e.printStackTrace( );
        }


        return taskList;

    }

}

