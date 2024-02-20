public class MyPriorityQueue implements PriorityQueueInterface {


    private MaxHeap<Task> queueHeap;
    private int queueHeapSize;
    
    MyPriorityQueue() {
        queueHeapSize = 6;
        queueHeap = new MaxHeap<Task>(queueHeapSize);
    }
    @Override
    public void enqueue(Task task) {
        queueHeap.insert(task);
    }

    @Override
    public Task dequeue() {
        return queueHeap.extractMax();
    }

    @Override
    public boolean isEmpty() {
        return queueHeap.isEmpty();
    }

    @Override
    public void update(int timeToIncrementPriority, int maxPriority) {
        for(int i = 0; i < queueHeap.getSize(); i++) {
            Task currentElement = queueHeap.getElement(i);
            currentElement.incrementWaitingTime();
            if(currentElement.getWaitingTime() >= timeToIncrementPriority) {
                currentElement.resetWaitingTime();
                if(currentElement.getPriority() < maxPriority) {
                    currentElement.setPriority(currentElement.getPriority() + 1);
                    queueHeap.increaseKey(i);
                }
            }
        }
    }
}
