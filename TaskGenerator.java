import java.util.Random;

public class TaskGenerator implements TaskGeneratorInterface {

    Task generatedTask;
    int currentEnergyStorage;
    double passOutProbability;
    double deathProbability;
    boolean generateTask;
    double taskGenerationProbability;
    long userSeed;
    boolean isSeed;
    Random randGen;

    TaskGenerator(double taskGenerationProbability, long seed){
        this.taskGenerationProbability = taskGenerationProbability;
        this.userSeed = seed;
        randGen = new Random(userSeed);
        isSeed = true;
    }
    
    TaskGenerator(double taskGenerationProbability){
        this.taskGenerationProbability = taskGenerationProbability;
        isSeed = false;
    }

    @Override
    public Task getNewTask(int hourCreated, TaskInterface.TaskType taskType, String taskDescription) {
        generatedTask = new Task(0, taskType, 0, hourCreated, taskDescription);
        passOutProbability = taskType.getPassingOutProbability();
        deathProbability = taskType.getDyingProbability();
        return generatedTask;
    }

    @Override
    public void decrementEnergyStorage(TaskInterface.TaskType taskType) {
        int taskEnergy = taskType.getEnergyPerHour();
        currentEnergyStorage = currentEnergyStorage - taskEnergy;
    }

    @Override
    public void resetCurrentEnergyStorage() {
        currentEnergyStorage = TaskGeneratorInterface.DEFAULT_ENERGY;
    }

    @Override
    public int getCurrentEnergyStorage() {
        return currentEnergyStorage;
    }

    @Override
    public void setCurrentEnergyStorage(int newEnergyNum) {
        currentEnergyStorage = newEnergyNum;
    }

    @Override
    public boolean generateTask() {
        double randomNum;
        if(isSeed == true) {
            randomNum = randGen.nextDouble();
            if(taskGenerationProbability >= randomNum) {
                generateTask = true;
            } else {
                generateTask = false;
            }
        } else  {
            Random randGen = new Random();
            randomNum = randGen.nextDouble();
            if(taskGenerationProbability >= randomNum) {
                generateTask = true;
            } else {
                generateTask = false;
            }
        }
        return generateTask;
    }

    @Override
    public int getUnlucky(Task task, double unluckyProbability) {
        if(unluckyProbability <= passOutProbability) {
            if(unluckyProbability <= deathProbability && task.getTaskType() == TaskInterface.TaskType.MINING) {
                currentEnergyStorage = (int)(currentEnergyStorage * .75);
                task.setPriority(0);
                return 2;
            } else {
                currentEnergyStorage = (int)(currentEnergyStorage / 2);
                return 1;
            }
        } else {
            return 0;
        }
    }
    
        /**
     * Create a String containing the Task's information.
     *
     * @param task - the Task
     * @param taskType - the Task's type
     */
    @Override
    public String toString(Task task, Task.TaskType taskType) {
        if(taskType == Task.TaskType.MINING) {
            return "     Mining " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == Task.TaskType.FISHING) {
            return "     Fishing " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")" ;
        }
        if(taskType == Task.TaskType.FARM_MAINTENANCE) {
            return "     Farm Maintenance " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == Task.TaskType.FORAGING) {
            return "     Foraging " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")" ;
        }
        if(taskType == Task.TaskType.FEEDING) {
            return "     Feeding " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == Task.TaskType.SOCIALIZING) {
            return "     Socializing " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        else { return "nothing to see here..."; }
}

}
