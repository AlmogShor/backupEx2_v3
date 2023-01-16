package TaskB;

import java.util.Comparator;
import java.util.concurrent.FutureTask;

class comprtrEx2BlockingQueue implements Comparator<Object> {

    /**
     * Compares two objects and returns who are bigger numerically.
     * 0 - (o1 == o2)
     * <0 - (o1 < o2)
     * >0 - (o1 > o2)
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return int value of comparison of 2 objects, based on priority values.
     */
    @Override
    public int compare(Object o1, Object o2) {
        if((o1 instanceof FutureTask<?> && o2 instanceof FutureTask<?>) ||
                (o1 instanceof Task<?> && o2 instanceof Task<?>)){
            return Integer.compare(o1.hashCode(), o2.hashCode());
        }
        else throw new IllegalArgumentException("Object is not task type");
    }
}