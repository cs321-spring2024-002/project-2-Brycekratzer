import java.util.ArrayList;

/**
* Represents a max-heap data structure.
*
* A max-heap is a complete binary tree where every parent node is greater than or equal to its
* children. This implementation uses an ArrayList to store the heap elements.
*
* @param <T> the type of elements stored in the heap
*/
public class MaxHeap<T extends Comparable<T>>{

    private ArrayList<T> heap;
    private int heapSize;
    private int heapCapacity;

    /**
    * Creates a new MaxHeap with the specified initial capacity.
    *
    * @param initiCapacity the initial capacity of the heap
    */
    public MaxHeap(int initiCapacity){
        heapCapacity = initiCapacity; // default capacity
        heapSize = 0;
        heap = new ArrayList<>(heapCapacity);
    }

    /**
    * Creates a new MaxHeap from an existing ArrayList.
    *
    * @param insertedHeap the ArrayList to create the heap from
    * @see #buildMaxHeap()
    */
    public MaxHeap(ArrayList<T> insertedHeap) {
        heap = insertedHeap;
        buildMaxHeap();
    }

    /**
    * Returns the maximum element in the heap without removing it.
    *
    * @return the maximum element in the heap
    */
    public T max(){
        return heap.get(0);
    }

    /**
    * Extracts the maximum element from the heap, then removes it from heap reference
    *
    * @return the maximum element in the heap
    * @see #heapify(int)
    */
    public T extractMax(){
        T maxElement = getElement(0);
        heap.remove(0);
        heapSize--;
        heap.add(heap.size(), maxElement);
        heapify(0);
        return maxElement;
    }

   /**
    * Inserts a new element into the heap.
    *
    * @param element the element to insert
    * @see #increaseKey(int)
    */
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
    
    /**
    * Increases the key of a given element in the heap.
    *
    * @param index the index of the element to increase
    * @throws IndexOutOfBoundsException if the index is invalid
    */
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

    /**
    * Checks if the heap is empty.
    *
    * @return true if the heap is empty, false otherwise
    */
    public boolean isEmpty(){
        return heapSize == 0;
    }

    /**
    * Maintains the max-heap property for a subtree rooted at a given index.
    *
    * @param index the index of the root of the subtree
    */
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

    /**
     * Converts an existing ArrayList into a valid max-heap.
     *
     * This method iterates through the elements in the ArrayList from the middle towards the root,
     * ensuring that each element satisfies the max-heap property (parent is greater than or equal to
     * children). This process is necessary when creating a MaxHeap from an unsorted ArrayList.
     */
    private void buildMaxHeap() {
        for(int i = (heapSize / 2); i > 0; i--){
            heapSize--;
            heapify(heapSize);
        }
    }

    /**
     * Returns the element at a specific index in the heap.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     */
    public T getElement(int index){
        T element;
        element = heap.get(index);
        return element;
    }

    /**
     * Returns the current number of elements in the heap.
     *
     * @return the current size of the heap
     */
    public int getSize() {
        return heapSize;
    }
}
