package todoipsda;

import java.io.*;
import java.util.ArrayList;

/**
 * This class will contain a method to write the data of Tasks from Array list to data file
 * and a method to read the data file which will contain the data of previously saved tasks
 */

public class FileHandler {

    /**
     * A method to write and save the taskList to the file
     *
     * @param fileName a string specifying the full path and extension of data file
     */

    public void saveTaskList(String fileName, ArrayList<Task> taskList) throws IOException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(new File("src/main/resources/todolist.txt")));
        stream.writeObject(taskList);
        stream.close( );
    }

    /**
     * A method to read the file from the path and load it to the taskList
     *
     * @throws ClassNotFoundException if the class is present in the classpath at runtime or not.
     */
    public ArrayList<Task> load(String fileName) {
        ArrayList<Task> taskList = new ArrayList<>( );
        System.out.println("Load method called");
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream("src/main/resources/todolist.txt"))) {
            try {
                taskList = (ArrayList<Task>) stream.readObject( );
            } catch (ClassNotFoundException e) {
            }
            System.out.println("Read object called");
            System.out.println("Task list size :" + taskList.size( ));
            for (int i = 0; i < taskList.size( ); i++)
                System.out.println("Project name of task" + i + "=" + taskList.get(i).getProjectName( ));
            stream.close( );
        } catch (IOException e) {
            System.out.println("Currently there are no tasks to display");
        }
        return taskList;
    }
}

