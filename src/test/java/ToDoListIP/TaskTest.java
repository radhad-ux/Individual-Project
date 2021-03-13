package ToDoListIP;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TaskTest {

    Task task;
    String validTitle = "Test Title";
    String validProject = "Test Project";
    LocalDate validDueDate = LocalDate.parse("2021-04-13");

    @Before
    public void setUp() throws Exception{
        try{
            task = new Task(validTitle, validDueDate, validProject);
        }catch(Exception e){
            System.out.println("There are few errors in testing of Task class");
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testEmptyTitle(){
        boolean success = false;
        try{
            task.setTitle("");
            fail("should throw a NullPointerException");
        } catch (NullPointerException e){
            success = true;
        }
        assertEquals(true, success);
    }
    @Test
    public void testNullTitle(){
        boolean success = false;
        try{
            task.setTitle(null);
            fail("should throw a NullPointerException");
        } catch (NullPointerException e){
            success = true;
        }
        assertEquals(true, success);
    }

   @Test
    public void testValidProject(){
        assertEquals(validProject, task.getProjectName());
    }
}
