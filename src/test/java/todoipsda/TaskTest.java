package todoipsda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {

    Task task;
    String validTitle = "Test Title";
    String validProject = "Test Project";
    LocalDate validDueDate = LocalDate.parse("2021-04-13");

    @BeforeEach
    public void setUp() {
        task = new Task(validTitle, validDueDate, validProject);
    }

    @Test
    public void testEmptyTitle() {
        Task task1 = new Task(validTitle, validDueDate, validProject);
        assertThrows(NullPointerException.class, ()-> task1.setTitle(""));
    }

    @Test
    public void testNotEmptyTitle() {
        Task task1 = new Task(validTitle, validDueDate, validProject);
        assertDoesNotThrow(()-> task1.setTitle("Java"));
    }

    @Test
    public void testValidProjectName(){
        assertEquals(validProject, task.getProjectName());
    }

    @Test
    public void testValidDueDate(){
        assertEquals(validDueDate, task.getDueDate());
    }
}

