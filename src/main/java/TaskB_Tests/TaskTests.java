package TaskB_Tests;

import TaskB.Task;
import TaskB.TaskType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {


    @Test
    public void testTask() {
        Task<Integer> test = Task.createTask(() -> {
            int tst = 1+1;
            return tst;}, TaskType.COMPUTATIONAL);
        Task<Integer> test2 = Task.createTask(() -> {
            int tst = 1+1;
            return tst;});
        assertEquals(TaskType.COMPUTATIONAL, test.getType());
        assertEquals(TaskType.OTHER, test2.getType());
    }
}
