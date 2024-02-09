import java.util.ArrayList;

public class MaxHeap<T extends Comparable<T>>{
    private ArrayList<T> heap;
    private int heapSize;
    private int heapCapacity;

    public MaxHeap(int initiCapacity){
        heapCapacity = initiCapacity; // default capacity
        heapSize = 0;
        heap = new ArrayList<>(heapCapacity);
    }

    public MaxHeap(ArrayList<T> insertedHeap) {
        heap = insertedHeap;
        buildMaxHeap();
    }

    public T max(){
        return heap.get(0);
    }

    public T extractMax(){
        T max = heap.get(0);
        heap.add(heapSize, max);
        heapSize--;
        heapify(0);
        return max;
    }

    public void insert(T element){
        if(isEmpty() == true) {
            heap.add(0, element);
            heapSize++;
        } else {
            heap.add(heapSize, element);
            increaseKey(heapSize, element);
            heapSize++;
        }
    }
    
    public void increaseKey(int index, T key){
        int parentNode;
        if(index % 2 == 0) {
            parentNode = (index/2) - 1;
        } else {
            parentNode = index/2;
        }
        while(index > 0 && heap.get(parentNode).compareTo(heap.get(index)) < 0) {
            T temporaryVal = heap.get(parentNode);
            heap.set(parentNode, heap.get(index));
            heap.set(index, temporaryVal); 
            index = parentNode;
        }

    }

    public boolean isEmpty(){
        return heapSize == 0;
    }

    private void heapify(int index){
        int leftChild = (2 * index) + 1;
        int rightChild = (2 * index) + 2;
        int largest = index;
        if (leftChild <= heapSize && heap.get(leftChild).compareTo(heap.get(index)) > 0) {
            largest = leftChild;
        }
        if (rightChild <= heapSize && heap.get(rightChild).compareTo(heap.get(index)) > 0) {
            largest = rightChild;
        }
        if (largest != index) {
            T temp = heap.get(index);
            heap.set(index, heap.get(largest));
            heap.set(largest, temp);
            heapify(largest);
        }
    }

    private void buildMaxHeap() {
        int parentNode;
        if(heapSize % 2 == 0) {
            parentNode = (heapSize/2) - 1;
        } else {
            parentNode = heapSize/2;
        }
        for(int i = parentNode; i > 0; i--){
            heapSize--;
            heapify(heapSize);
        }
    }

    public T getElement(int index){
        T element;
        element = heap.get(index);
        return element;
    }
}
