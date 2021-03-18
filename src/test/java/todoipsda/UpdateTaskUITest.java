package todoipsda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class UpdateTaskUITest {
    ArrayList<Task> taskList;
    ToDoList toDoList;


    @BeforeEach
    public void setUp() {
        taskList = new ArrayList<Task>( );
        toDoList = new ToDoList(taskList);

        Task task = new Task("Test Title", LocalDate.parse("2021-04-13"),"Test Project");
        taskList.add(task);

        Task task1 = new Task("Test Title", LocalDate.parse("2021-04-13"),"Test Project");
        taskList.add(task1);
    }
    @Test
    public void testToDeleteTask(){
        UpdateTaskUI updateTaskUI = new UpdateTaskUI(taskList, toDoList);
        Assertions.assertEquals(2,toDoList.getSize());
        updateTaskUI.deleteTaskByIndex(1);
        Assertions.assertEquals(1,toDoList.getSize());
    }

    @Test
    public void testMarkTaskAsDone(){
        UpdateTaskUI updateTaskUI = new UpdateTaskUI(taskList, toDoList);
        Assertions.assertEquals(true,updateTaskUI.markTaskAsDoneByIndex(1));
    }

    @Test
    public void testMarkTaskAsDoneNotSuccess(){
        UpdateTaskUI updateTaskUI = new UpdateTaskUI(taskList, toDoList);
        updateTaskUI.deleteTaskByIndex(2);
        updateTaskUI.deleteTaskByIndex(1);
        Assertions.assertEquals(false,updateTaskUI.markTaskAsDoneByIndex(1));
    }
}