package TaskB_Tests;

import TaskB.*;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class shaharTests {
    public static final Logger logger = LoggerFactory.getLogger(shaharTests.class);


    @Test
    public void testCustomExecutor() {
        CustomExecutor customExecutor = new CustomExecutor();
        Task<Integer> task = Task.createTask(() -> {
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                sum += i;
            }
            return sum;
        }, TaskType.COMPUTATIONAL);
        Task<Integer> task2 = Task.createTask(() -> {
            int sum = 1;
            for (int i = 1; i <= 10; i++) {
                sum += i;
            }
            return sum;
        }, TaskType.IO);
        var sumTask = customExecutor.submit(task2);
        final int sum;
        try {
            sum = sumTask.get(1, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
        var sumTask2 = customExecutor.submit(task);
        final int sum2;
        try {
            sum2 = sumTask2.get(1, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
        var sumTask3 = customExecutor.submit(task);
        final int sum3;
        try {
            sum3 = sumTask2.get(1, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
        var sumTask4 = customExecutor.submit(task);
        final int sum4;
        try {
            sum4 = sumTask.get(1, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
        Future<Integer> sumTask5 = customExecutor.submit(task);
        final int sum5;
        try {
            sum5 = sumTask2.get(1, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
        var sumTask6 = customExecutor.submit(task);
        final int sum6;
        try {
            sum6 = sumTask2.get(1, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
        var sumTask7 = customExecutor.submit(task);
        final int sum7;
        try {
            sum7 = sumTask.get(1, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
        var sumTask8 = customExecutor.submit(task);
        final int sum8;
        try {
            sum8 = sumTask2.get(1, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
        var sumTask9 = customExecutor.submit(task);
        final int sum9;
        try {
            sum9 = sumTask2.get(1, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
        var sumTask10 = customExecutor.submit(task);
        final int sum10;
        try {
            sum10 = sumTask.get(1, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
        var sumTask11 = customExecutor.submit(task);
        final int sum11;
        try {
            sum11 = sumTask2.get(1, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
        var sumTask12 = customExecutor.submit(task);
        final int sum12;
        try {
            sum12 = sumTask2.get(1, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }

        assertEquals(2, customExecutor.getCurrentMax());
    }

}
