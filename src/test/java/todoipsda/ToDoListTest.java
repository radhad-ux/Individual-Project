package todoipsda;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;


public class ToDoListTest {
    ArrayList<Task> taskList;
    ToDoList toDoList;
    String title;
    LocalDate dueDate;
    String projectName;


    @BeforeEach
    public void setUp()
    {
        taskList = new ArrayList<Task>( );
        toDoList = new ToDoList(taskList);
        //taskList = new Task(title, dueDate, projectName);
    }

    @Test
    public void testAddTaskCorrectSize(){
        ArrayList<Task> taskList = new ArrayList<Task>();
        ToDoList toDoList = new ToDoList(taskList);
        toDoList.title = "Validate";
        toDoList.dueDate = LocalDate.parse("2021-04-13");
        toDoList.projectName = "project";
        toDoList.addNewTask();
        Assertions.assertEquals(1, toDoList.getSize());
    }

    @Test
    public void testAddTaskWrongSize()
    {
        ArrayList<Task> taskList = new ArrayList<Task>();
        ToDoList toDoList = new ToDoList(taskList);
        toDoList.title = "Validate";
        toDoList.dueDate = LocalDate.parse("2021-04-13");
        toDoList.projectName = "project";
        toDoList.addNewTask();
        Assertions.assertNotEquals(21, toDoList.getSize());
    }
    @Test
    public void testToGetNumberOfTasksDone() {

        Task task = new Task("Test Title",LocalDate.parse("2021-04-13"),"Test Project");
        task.setIsTaskDone(true);
        taskList.add(task);
        toDoList.addNewTask();

        Assertions.assertEquals(1, toDoList.getNumberOfTasksDone());
    }

    @Test
    public void testZeroTasksDone() {
        Task task = new Task("Test Title",LocalDate.parse("2021-04-13"),"Test Project");
        task.setIsTaskDone(false);
        taskList.add(task);
        toDoList.addNewTask();

        Assertions.assertEquals(0, toDoList.getNumberOfTasksDone());
    }

     
}
