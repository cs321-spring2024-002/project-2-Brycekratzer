import java.util.ArrayList;

public class MaxHeap<T extends Comparable<T>>{
    private ArrayList<T> heap;
    private int heapSize;
    private int heapCapacity;

    public MaxHeap(int initiCapacity){
        heapCapacity = initiCapacity; // default capacity
        heapSize = 0;
        heap = new ArrayList(heapCapacity);
    }

    public MaxHeap(ArrayList<T> insertedHeap) {
        //TODO
    }

    public T max(){
        return heap.get(1);
    }

    public void extractMax(){

    }

    public void insert(T element){

    }
    
    public void increaseKey(int index, T key){
        if (key.compareTo(heap.get(index)) < 0){
            // throw new HeapException("new key must be larger than current key");TODO
        } 
        heap.remove(index);
        heap.add(index, key);
        while(index > 1 && heap.get(index/2).compareTo(heap.get(index)) < 0) {
            //TODO
        }

    }

    public boolean isEmpty(){
        return heapSize == 0;
    }

    private void heapify(int index){
        int leftChild = 2 * index;
        int rightChild = (2 * index) + 1;
        T largest = heap.get(index);
        if(leftChild <= heapSize && heap.get(leftChild).compareTo(heap.get(index)) > 0) {
                largest = heap.get(leftChild);
        }
        if(rightChild <= heapSize && heap.get(rightChild).compareTo(heap.get(index)) > 0) {
                largest = heap.get(rightChild);
        }
        if(largest != heap.get(index)){ //checks if current index is still largest generic
            T temporyVal = heap.remove(index); //if so removes from position and adds to value
            if(largest == heap.get(rightChild)) { //checks if largest value is right child node or left
                heap.add(index, largest);
                heap.add(rightChild, temporyVal);
            } else {
                heap.add(index, largest);
                heap.add(rightChild, temporyVal);
            }
            heapify(index);
        }
    }

    private void buildMaxHeap() {
        for(int i = heapSize/2; i > 0; i--){
            heapify(heapSize);
        }
    }

    public T getElement(int index){
        T element;
        element = heap.get(index);
        return element;
    }
}
