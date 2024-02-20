public class Task implements TaskInterface, Comparable<Task>{

    private int priorityLvl;
    private int waitingTime;
    private int timeCreated;
    private TaskInterface.TaskType taskType;
    private String taskDescript;


    public Task(int inputPriority, Task.TaskType inputTaskType, int inputWaitingTime, int inputTimeCreated, String inputTaskDescript) {
        priorityLvl = inputPriority;
        waitingTime = inputWaitingTime;
        timeCreated = inputTimeCreated;
        taskType = inputTaskType;
        taskDescript = inputTaskDescript;
    } 
    @Override
    public int getPriority() {
        return priorityLvl;
    }

    @Override
    public void setPriority(int priority) {
        priorityLvl = priority;
    }

    @Override
    public TaskInterface.TaskType getTaskType() {
        return taskType;
    }

    @Override
    public String getTaskDescription() {
        return taskDescript;
    }

    @Override
    public void incrementWaitingTime() {
        waitingTime++;
    }

    @Override
    public void resetWaitingTime() {
        waitingTime = 0;
    }

    @Override
    public int getWaitingTime() {
        return waitingTime;
    }

    public int getTimeCreated() {
        return timeCreated;
    }

    public String toString() {
        return this.taskType + " " + this.taskDescript + "at Hour: " + this.timeCreated + ":00";
    }

    @Override
    public int compareTo(Task compareTask) {
        int returnVal = 0;
        if(this.priorityLvl > compareTask.getPriority()) {
            returnVal = 1;
        } else if(this.priorityLvl < compareTask.getPriority()) {
            returnVal = -1;
        } else if(this.priorityLvl == compareTask.getPriority()) {
            if(timeCreated < compareTask.getTimeCreated()) {
                returnVal =  1;
            } else {
                returnVal = -1;
            }
        }
        return returnVal;
    }
}
