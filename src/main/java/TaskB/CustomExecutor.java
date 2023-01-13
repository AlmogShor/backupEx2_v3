package TaskB;

import java.util.concurrent.*;

/**
 * @author Yulia and Almog
 * @version 1.0
 * @since 2022-01-09
 */


public class CustomExecutor extends ThreadPoolExecutor {
    private int currentMax = 0;
    public int[] priQueue = new int[10];


    /**
     * Thread pool constructor
     * The size depends on operating system.
     * Min thread pool size - half of available processors
     * Max thread pool size - the number of available processors is less than one.
     * Keep alive time 3 seconds - used to specify the amount of time that pool threads should be kept running when idle.
     * Queue of task from type - Priority Queue.
     */
    public CustomExecutor() {
        super(Runtime.getRuntime().availableProcessors() / 2,
                Runtime.getRuntime().availableProcessors() - 1,
                300,
                TimeUnit.MILLISECONDS
                , new PriorityBlockingQueue<>());
    }

    /**
     * This basic submit method takes the callable task, convert it to Future task and execute it to the thread pool.
     * At the same time the new task enter to priority queue.
     *
     * @param task to execute
     * @param <T>  Generic task return value type
     * @return Executes the task
     */
    public <T> Future<T> submit(Task<T> task) {
        ++priQueue[task.getType().getPriorityValue() - 1];
        TaskC2R adaptedTask = new TaskC2R(task);
        super.execute(adaptedTask);
        return adaptedTask;
    }

    /**
     * @return current maximum priority value.
     */
    public int getCurrentMax() {
        return currentMax;
    }

    /**
     * @param task - task to do
     * @param <T>  - Generic task return value type
     * @return Submitting of the task while creating, without type definition.
     */
    public <T> Future<T> submit(Callable<T> task) {
        return this.submit(Task.createTask(task));
    }

    /**
     * @param task - task to do
     * @param type of the task
     * @param <T>  - Generic task return value type
     * @return Submitting of the task while creating.
     */
    public <T> Future<T> submit(Callable<T> task, TaskType type) {
        return this.submit(Task.createTask(task, type));
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {

        this.priQueue[((TaskC2R)r).getType().getPriorityValue() - 1]--;
        super.beforeExecute(t, r);
    }

    /**
     * Option to stop the CustomExecutor as follows:
     * Stops accepting new tasks
     * Waits for already submitted tasks to complete even if they didn't start yet.
     * Complete all tasks that are in the queue
     */
    public void gracefullyTerminate() {
        super.shutdown();
        while (!super.isTerminated()) {
            try {
                super.awaitTermination(300, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}