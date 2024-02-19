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
            queueHeap.getElement(i).incrementWaitingTime();
            if(queueHeap.getElement(i).getWaitingTime() >= timeToIncrementPriority) {
                queueHeap.getElement(i).resetWaitingTime();
                if(queueHeap.getElement(i).getPriority() < maxPriority) {
                    queueHeap.getElement(i).setPriority(queueHeap.getElement(i).getPriority() + 1);
                    queueHeap.increaseKey(i, null);
                }
            }
        }
    }
    
}
