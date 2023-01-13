package TaskB_Tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import TaskB.*;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomExecutorTests<V> {
    public static final Logger logger = LoggerFactory.getLogger(CustomExecutorTests.class);
    public static CustomExecutor customExecutor = new CustomExecutor();

//    @Test
//    public void partialTest(){
//        CustomExecutor customExecutor = new CustomExecutor();
//        var task = Task.createTask(() -> {
//            int sum = 0;
//            for (int i = 1; i <= 10; i++) {
//                sum += i;
//            }
//            return sum;
//        }, TaskType.COMPUTATIONAL);
//        var sumTask = customExecutor.submit(task);
//        final int sum;
//        try {
//            sum = (int) sumTask.get(1000, TimeUnit.MILLISECONDS);
//        } catch (InterruptedException | ExecutionException | TimeoutException e) {
//            throw new RuntimeException(e);
//        }
//        logger.info(() -> "Sum of 1 through 10 = " + sum);
//        Callable<Double> callable1 = () -> {
//            return 1000 * Math.pow(1.02, 5);
//        };
//        Callable<String> callable2 = () -> {
//            StringBuilder test = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
//            return test.reverse().toString();
//        };
//        // var is used to infer the declared type automatically
//        var priceTask = customExecutor.submit(() -> {
//            return 1000 * Math.pow(1.02, 5);
//        }, TaskType.COMPUTATIONAL);
//
//        var reverseTask = customExecutor.submit(callable2, TaskType.IO);
//        final Double totalPrice;
//        final String reversed;
//        try {
//            totalPrice = (Double) priceTask.get();
//            reversed = (String) reverseTask.get();
//        } catch (InterruptedException | ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//        assertEquals(reversed.toString(), "ZYXWVUTSRQPONMLKJIHGFEDCBA");
//        assertEquals(totalPrice, 1104.0808032);
//        assertEquals(customExecutor.getCurrentMax(), 0);
//        logger.info(() -> "Reversed String = " + reversed);
//        logger.info(() -> String.valueOf("Total Price = " + totalPrice));
//        logger.info(() -> "Current maximum priority = " +
//                customExecutor.getCurrentMax());
//        customExecutor.gracefullyTerminate();
//    }
    @BeforeAll
    public static void setup(){
        System.out.println("Setup");
        System.out.println(customExecutor.priQueue);
    }

    @Test
    public void testOfSubmit(){
        Task<Integer> tst = Task.createTask(() -> { return 2*2*2;}, TaskType.COMPUTATIONAL);
        Future<Integer> future = customExecutor.submit(tst);

        try {
            assertEquals(customExecutor.getCurrentMax(), tst.getType().getPriorityValue());
            assertEquals(future.get(), 8);
            assertEquals(customExecutor.getCurrentMax(), 1);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Test_General(){


        Callable<String> tst = () ->
        {
            StringBuilder test = new StringBuilder("One check One check Two check");
            sleep(1500);

            return test.reverse().toString();};

        Callable<String> tst2 = () ->
        {
            String test2 = "lets wrap it up";
            sleep(1500);
            return test2.toUpperCase();};

        Callable<String> tst3 = () ->
        {
            StringBuilder test3 = new StringBuilder("123456789");
            sleep(1500);
            return test3.reverse().toString();};

        Callable<Integer> tst4 = () -> {
            return (int) (Math.pow(8,4) * 3);};

        Callable<Integer> tst5 = () -> {
            return 1+1;};


        Future<String> IOTask = customExecutor.submit(tst, TaskType.IO);
        Future<String> EmpTask = customExecutor.submit(tst2);
        Future<String> IOTask2 = customExecutor.submit(tst3, TaskType.IO);

        Future<Integer> computationTsk = customExecutor.submit(tst4, TaskType.COMPUTATIONAL);
        Future<Integer> computationTsk2 = customExecutor.submit(tst5, TaskType.COMPUTATIONAL);

        String reversed,upperCase, reversed2;

        int computation, computation2;

        try
        {
            reversed = IOTask.get();
            upperCase = EmpTask.get();
            reversed2 = IOTask2.get();

            computation = computationTsk.get();
            computation2 = computationTsk2.get();
        }
        catch (ExecutionException | InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        assertEquals("kcehc owT kcehc enO kcehc enO", reversed.toString());
        assertEquals("LETS WRAP IT UP", upperCase.toString());
        assertEquals("987654321", reversed2.toString());

        assertEquals( 12288, computation);
        assertEquals( 2, computation2);
        customExecutor.gracefullyTerminate();
    }
    @Test
    public void anotherTests() throws ExecutionException, InterruptedException {

        Task<String> taskString = Task.createTask(()->{
            StringBuilder test = new StringBuilder("Hello ");
            for (char i = 'a'; i < 't'; i++) {
                test.append(i);
            }
            return test.toString();
        }, TaskType.IO);
        Future<String> futureString = customExecutor.submit(taskString);

        Task<Integer> task = Task.createTask(()->{
            // calculate the factorial of 5
            int sum = 1;
            for (int i = 1; i <= 5; i++) {
                sum *= i; //1*1=1, 1*2=2, 2*3=6, 6*4=24, 24*5=120
            }
            return sum;
        }, TaskType.COMPUTATIONAL);
        Future<Integer> futureTask = customExecutor.submit(task);

        assertEquals(futureTask.get(), 120);
        assertEquals("Hello abcdefghijklmnopqrs", futureString.get());

        try {
            Integer result = futureTask.get();
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        try {
            String result = futureString.get();
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }
}