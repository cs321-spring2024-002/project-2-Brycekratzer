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
        T maxElement = getElement(0);
        heap.remove(0);
        heapSize--;
        heap.add(heap.size(), maxElement);
        heapify(0);
        return maxElement;
    }

    public void insert(T element){
        if(isEmpty() == true) {
            heap.add(0, element);
            heapSize++;
        } else {
            heap.add(heapSize, element);
            increaseKey(heapSize);
            heapSize++;
        }
    }
    
    public void increaseKey(int index){
        if( index < 0 || index > heapSize) {
            throw new IndexOutOfBoundsException("");
        }
        int parentNode = index/2;
        if(heap.get(index).compareTo(heap.get(parentNode)) > 0) {
            T tempVal = heap.get(index);
            heap.set(index, heap.get(parentNode));
            heap.set(parentNode, tempVal); 
            increaseKey(parentNode);
        }
    }

    public boolean isEmpty(){
        return heapSize == 0;
    }

    private void heapify(int index) {
        int leftChild = (2 * index) + 1;
        int rightChild = (2 * index) + 2;
        int largest = index;
        if (leftChild < heapSize && heap.get(leftChild).compareTo(heap.get(index)) > 0) {
            largest = leftChild;
        } else {
            largest = index;
        }
        if (rightChild < heapSize && heap.get(rightChild).compareTo(heap.get(largest)) > 0) {
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
        for(int i = (heapSize / 2); i > 0; i--){
            heapSize--;
            heapify(heapSize);
        }
    }

    public T getElement(int index){
        T element;
        element = heap.get(index);
        return element;
    }

    public int getSize() {
        return heapSize;
    }

}
