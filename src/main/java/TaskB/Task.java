package TaskB;
import java.util.Objects;
import java.util.concurrent.Callable;

/**
 *
 * @author Yulia and Almog
 * @version 1.0
 * @since 2016-11-15
 *
 */


public class Task<T> implements Callable<T> {
    private TaskType type;
    private Callable<T> callable;

    /**
     * A method with a generic return value
     * @return
     * @throws Exception - if the call method failed.
     */
    @Override
    public T call() throws Exception {
        return callable.call();
    }

    /**
     * Task constructor - Defined as a private method in order to maintain the creation of the tasks in a controlled manner.
     * @param callable -  the task
     * @param type - type of task, according to TaskType enum
     * @return new Task
     *
     */
    private Task(Callable<T> callable, TaskType type){
        this.callable = callable ;
        this.type = type ;
    }

    /**
     * Factory method - Published method to create a task.
     * @param callable
     * @param type - type of task, according to TaskType enum
     * @return new Task
     *
     */
    public static Task createTask(Callable callable, TaskType type) {
        return new Task(callable, type);
    }

    /**
     * Factory method - Published task creation in case the type is other - not defined.
     * @param callable
     * @return new Task
     *
     */
    public static Task createTask(Callable callable) {
        return new Task(callable, TaskType.OTHER);
    }

    public TaskType getType() {
        return type;
    }

    /**
     * Compares between two tasks
     * @param otherTask
     * @return
     */
    @Override
    public boolean equals(Object otherTask) {
        if (this == otherTask) return true;
        if (otherTask == null || getClass() != otherTask.getClass()) return false;
        Task<?> task = (Task<?>) otherTask;
        return type == task.type && Objects.equals(callable, task.callable);
    }

    /**
     * @return Hash performance of task
     */
    @Override
    public int hashCode() {

        return Objects.hash(type, callable);
    }


    public boolean isNull() {
        return this == null;
    }
}

