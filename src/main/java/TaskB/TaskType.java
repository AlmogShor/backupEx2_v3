package TaskB;

/**
 *
 * @author Yulia and Almog
 * @version 1.0
 * @since 2016-11-15
 *
 */

public enum TaskType {
    /**
     * Given class - enum for task type
     * Three given priority types and a constructor for self type defenition.
     */
    COMPUTATIONAL(1){
        @Override
        public String toString(){
            return "Computational CustomCallable";
        }
    },
    IO(2){
        @Override
        public String toString(){
            return "IO-Bound CustomCallable";
        }
    },
    OTHER(3){
        @Override
        public String toString(){
            return "Unknown CustomCallable" ;
        }
    };

    private int typePriority;

    /**
     * Constructor for the enum types.
     * @param priority - the priority integer value of the type.
     */
    private TaskType(int priority){
        if (validatePriority(priority)) typePriority = priority;
        else
            throw new IllegalArgumentException("Priority is not an integer") ;
    }

    /**
     * Setter to the priority value.
     * @param priority - integer value represents the wanted priority.
     */
    public void setPriority(int priority){
        if(validatePriority(priority)) this.typePriority = priority;
        else
            throw new IllegalArgumentException("Priority is not an integer");
    }

    /**
     * Getter for the priority value.
     * @return an integer represents the priority value.
     */
    public int getPriorityValue(){
        return typePriority;
    }

    /**
     * Getter for the TaskType.
     * @return the instance TaskType.
     */
    public TaskType getType(){
        return this;
    }

    /**
     * Ensures that a given priority is a valid priority - an integer between 1 - 10.
     * @param priority - the priority to validate.
     * @return True - if priority is valid,
     *         False - if priority is not valid.
     */
    private static boolean validatePriority(int priority){
        if (priority < 1 || priority >10)
            return false;
        return true;
    }
}


