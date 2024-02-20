import java.util.ArrayList;
/**
 * The following is a tester class used to test the usage of the MaxHeap Data Structure
 * 
 * @see MaxHeap.java
 */
public class MaxHeapTest {
    /**
     * initial varibables used throughout the test
     */
    enum pssibleResult { PASS, FAIL };
    ArrayList<Integer> arrayTest;
    final static int ELEMENT_A = 1;
    final static int ELEMENT_B = 2;
    final static int ELEMENT_C = 3;
    final static int ELEMENT_D = 4;
    final static int ELEMENT_E = 5;
    final static int ELEMENT_F = 6;
    final static int ELEMENT_G = 7; 
    

    public static void main(String[] args){
        System.out.println("============================");
        System.out.println("            Test            ");
        System.out.println("============================");
        System.out.println("emptyHeap.isEmpty(): " + isEmptyTest());
        System.out.print("\n");
        System.out.println("notEmptyHeap.isEmpty(): " + isEmpty_WithElement());
        System.out.print("\n");
        System.out.println("3Element_insert_rightPlace: " + insert3Element());
        System.out.print("\n");
        System.out.println("extractMax_callTwice: " + extractMax_callTwice());
        System.out.print("\n");
        System.out.println("extractMax_callThree: " + extractMax_callThree());
        System.out.print("\n");
        System.out.println("increaseKey_with_Two_element: " + increaseKey_twoElement());
        System.out.print("\n");
        System.out.println("increaseKey_with_Three_element: " + increaseKey_threeElement());
        System.out.print("\n");
        System.out.println("Check_if_max_heap_7Elements: " + insertAscendingTest());
        System.out.print("\n");
        System.out.println("Check_if_sorted__7Elements: " + insertDescendingTest());
        System.out.print("\n");
        System.out.println("Check_if_maxHeap__7RandomElements: " + insertRandomTest());
        System.out.print("\n");
        System.out.println("============================");

    }

     /**
     * Tests if an empty heap is correctly identified as empty.
     *
     * @return PASS if the test passes, FAIL otherwise
     */
    public static pssibleResult isEmptyTest(){
        pssibleResult result = null;
        MaxHeap<Integer> emptyHeap = new MaxHeap<>(10);
        if(emptyHeap.isEmpty() == false) {
            result = pssibleResult.FAIL;
        } else {
            result  = pssibleResult.PASS;
        }
        return result;
    }

    /**
     * Tests if a heap with one element is correctly identified as not empty.
     *
     * @return PASS if the test passes, FAIL otherwise
     */
    public static pssibleResult isEmpty_WithElement(){
        pssibleResult result = null;
        MaxHeap<Integer> emptyHeap = new MaxHeap<>(10);
        emptyHeap.insert(ELEMENT_A);

        if(emptyHeap.isEmpty() == false) {
            result = pssibleResult.PASS;
        } else {
            result  = pssibleResult.FAIL;
        }
        return result;
    }


    /**
     * Tests if inserting three elements maintains the max-heap property.
     *
     * @return PASS if the test passes, FAIL otherwise
     */
    public static pssibleResult insert3Element(){
        pssibleResult result = pssibleResult.FAIL;
        MaxHeap<Integer> emptyHeap = new MaxHeap<>(10);
        emptyHeap.insert(ELEMENT_A);
        emptyHeap.insert(ELEMENT_D);
        emptyHeap.insert(ELEMENT_B);
        int testPosition = 0;
        if(ELEMENT_D == emptyHeap.getElement(0)){
            result = pssibleResult.PASS;
            testPosition++;
        } 
        if(ELEMENT_B == emptyHeap.getElement(1) || ELEMENT_A == emptyHeap.getElement(1)){
            result = pssibleResult.PASS;
            testPosition++;
        } 
        if(ELEMENT_B == emptyHeap.getElement(2) || ELEMENT_A == emptyHeap.getElement(2)){
            result = pssibleResult.PASS;
            testPosition++;
        }
        if(testPosition != 3){
            result = pssibleResult.FAIL;
        }
        return result;
    }

    /**
     * Tests if extracting the max element twice returns the correct elements.
     *
     * @return PASS if the test passes, FAIL otherwise
     */
    public static pssibleResult extractMax_callTwice(){
        pssibleResult result = pssibleResult.PASS;
        MaxHeap<Integer> emptyHeap = new MaxHeap<>(10);
        emptyHeap.insert(ELEMENT_A);
        emptyHeap.insert(ELEMENT_B);
        emptyHeap.extractMax();
        emptyHeap.extractMax();
        
        if(ELEMENT_B != emptyHeap.getElement(0)) {
            result = pssibleResult.FAIL;
        }
        if(ELEMENT_A != emptyHeap.getElement(1)) {
            result = pssibleResult.FAIL;
        }
        return result;
    }

    /**
     * Tests if extracting the max element three times returns the correct elements.
     *
     * @return PASS if the test passes, FAIL otherwise
     */
    public static pssibleResult extractMax_callThree(){
        pssibleResult result = pssibleResult.PASS;
        MaxHeap<Integer> emptyHeap = new MaxHeap<>(10);
        emptyHeap.insert(ELEMENT_A);
        emptyHeap.insert(ELEMENT_B);
        emptyHeap.insert(ELEMENT_C);
        emptyHeap.extractMax();
        emptyHeap.extractMax();
        emptyHeap.extractMax();
        
        if(ELEMENT_C != emptyHeap.getElement(0)) {
            result = pssibleResult.FAIL;
        }
        if(ELEMENT_B != emptyHeap.getElement(1)) {
            result = pssibleResult.FAIL;
        }
        if(ELEMENT_A != emptyHeap.getElement(2)) {
            result = pssibleResult.FAIL; 
        }
        return result;
    }

    /**
     * Tests if increaseKey works properly with 2 elements
     *
     * @return PASS if the test passes, FAIL otherwise
     */
    public static pssibleResult increaseKey_twoElement(){
        pssibleResult result = pssibleResult.PASS;
        MaxHeap<Integer> emptyHeap = new MaxHeap<>(10);
        emptyHeap.insert(ELEMENT_A);
        emptyHeap.insert(ELEMENT_B);
        emptyHeap.increaseKey(1);

        if(ELEMENT_B != emptyHeap.getElement(0)) {
            result = pssibleResult.FAIL;
        }
        return result;
    }

    /**
     * Tests if increaseKey works properly with 3 elements
     *
     * @return PASS if the test passes, FAIL otherwise
     */
    public static pssibleResult increaseKey_threeElement(){
        pssibleResult result = pssibleResult.PASS;
        MaxHeap<Integer> emptyHeap = new MaxHeap<>(10);
        emptyHeap.insert(ELEMENT_A);
        emptyHeap.insert(ELEMENT_B);
        emptyHeap.insert(ELEMENT_E);
        emptyHeap.increaseKey(2);

        if(ELEMENT_E != emptyHeap.getElement(0)) {
            result = pssibleResult.FAIL;
        }
        return result;
    }

    /**
     * Helper method used to test if maxHeap is a maxHeap by comparing parent nodes with children nodes
     *
     * @return PASS if the test passes, FAIL otherwise
     */
    public static pssibleResult checkIfMaxHeap(int numOfParents, MaxHeap<Integer> testingHeap){
        pssibleResult result = pssibleResult.PASS;
        MaxHeap<Integer> emptyHeap = testingHeap;

        for(int i = 0; i < numOfParents; i++) {
            int parentNode = emptyHeap.getElement(i);
            int leftChild = (2 * i) + 1;
            int rightChild = (2 * i) + 2;
            if(parentNode < emptyHeap.getElement(rightChild) || parentNode < emptyHeap.getElement(leftChild)){
                result = pssibleResult.FAIL;
            }
        }
        return result;
    }

    /**
     * Helper method used to test if maxHeap is a sorted by comparing parent nodes with children nodes
     *
     * @return PASS if the test passes, FAIL otherwise
     */
    public static pssibleResult checkIfSorted(int numOfParents, MaxHeap<Integer> testingHeap){
        pssibleResult result = pssibleResult.PASS;
        MaxHeap<Integer> emptyHeap = testingHeap;

        for(int i = 0; i < numOfParents; i++) {
            int parentNode = emptyHeap.getElement(i);
            int leftChild = (2 * i) + 1;
            int rightChild = (2 * i) + 2;
            if(parentNode < emptyHeap.getElement(rightChild) || parentNode < emptyHeap.getElement(leftChild)){
                result = pssibleResult.FAIL;
            }
        }
        return result;
    }

    /**
     * Creates a heap by inserting 1, 2, …, n (as priority values). Then check if the resulting 
     * heap satisfies the max-heap property using checkIfMaxHeap helper method
     *
     * @return PASS if the test passes, FAIL otherwise
     */
    public static pssibleResult insertAscendingTest(){
        pssibleResult result = pssibleResult.PASS;
        MaxHeap<Integer> emptyHeap = new MaxHeap<>(10);
        emptyHeap.insert(ELEMENT_A);
        emptyHeap.insert(ELEMENT_B);
        emptyHeap.insert(ELEMENT_C);
        emptyHeap.insert(ELEMENT_D);
        emptyHeap.insert(ELEMENT_E);
        emptyHeap.insert(ELEMENT_F);
        emptyHeap.insert(ELEMENT_G);

        result = checkIfMaxHeap(3, emptyHeap);
        return result;
    }

    /**
     *  Creates a heap by inserting n, n-1, …, 2, 1 (as priority values). Then checks if the
     *  resulting heap satisfies the max-heap property using checkIfMaxHeap helper method.
     *
     * @return PASS if the test passes, FAIL otherwise
     */
    public static pssibleResult insertDescendingTest(){
        pssibleResult result = pssibleResult.PASS;
        MaxHeap<Integer> emptyHeap = new MaxHeap<>(10);
        emptyHeap.insert(ELEMENT_G);
        emptyHeap.insert(ELEMENT_F);
        emptyHeap.insert(ELEMENT_E);
        emptyHeap.insert(ELEMENT_D);
        emptyHeap.insert(ELEMENT_C);
        emptyHeap.insert(ELEMENT_B);
        emptyHeap.insert(ELEMENT_A);

        result = checkIfSorted(3, emptyHeap);
        return result;
    }

    /**
     * Creates a heap by randomly inserting n random values (as priority values) in the range 1..n. 
     * Then checks if the resulting heap satisfies the max-heap property using checkIfMaxHeap helper method. 
     *
     * @return PASS if the test passes, FAIL otherwise
     */
    public static pssibleResult insertRandomTest(){
        pssibleResult result = pssibleResult.PASS;
        MaxHeap<Integer> emptyHeap = new MaxHeap<>(10);
        emptyHeap.insert(ELEMENT_C);
        emptyHeap.insert(ELEMENT_F);
        emptyHeap.insert(ELEMENT_B);
        emptyHeap.insert(ELEMENT_G);
        emptyHeap.insert(ELEMENT_A);
        emptyHeap.insert(ELEMENT_E);
        emptyHeap.insert(ELEMENT_G);

        result = checkIfMaxHeap(3, emptyHeap);
        return result;
    }
}