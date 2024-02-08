public class Task implements TaskInterface{

    private int priorityLvl;
    //TODO instance varibales 
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
        return null;
    }

    @Override
    public String getTaskDescription() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTaskDescription'");
    }

    @Override
    public void incrementWaitingTime() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'incrementWaitingTime'");
    }

    @Override
    public void resetWaitingTime() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resetWaitingTime'");
    }

    @Override
    public int getWaitingTime() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWaitingTime'");
    }
    
    @Override
    public int compareTo(Task one, Task two) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWaitingTime'");
    }
}
