package TaskB;

import java.util.concurrent.FutureTask;

public class TaskC2R<T> extends FutureTask implements Comparable<TaskC2R<T>> {

    private Task<T> task;

    public TaskC2R(Task<T> task) {
        super(task);
        this.task = task;
    }
    public TaskType getType() {
        return task.getType();
    }

    public int getPriority() {
        return this.task.getType().getPriorityValue();
    }

    /**
     * Compares the priority of current task and one another.
     * @param othetTask - task to compare with.
     * @return -1 less then, 0 equals, 1 more then.
     */
    @Override
    public int compareTo(TaskC2R<T> othetTask) {
        return Integer.compare(this.task.getType().getPriorityValue(), othetTask.task.getType().getPriorityValue());
    }
}
