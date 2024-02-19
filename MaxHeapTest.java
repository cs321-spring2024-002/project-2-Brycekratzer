import java.util.ArrayList;

public class MaxHeapTest {
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

    public static pssibleResult increaseKey_twoElement(){
        pssibleResult result = pssibleResult.PASS;
        MaxHeap<Integer> emptyHeap = new MaxHeap<>(10);
        emptyHeap.insert(ELEMENT_A);
        emptyHeap.insert(ELEMENT_B);
        emptyHeap.increaseKey(1, ELEMENT_D);

        if(ELEMENT_D != emptyHeap.getElement(0)) {
            result = pssibleResult.FAIL;
        }
        return result;
    }

    public static pssibleResult increaseKey_threeElement(){
        pssibleResult result = pssibleResult.PASS;
        MaxHeap<Integer> emptyHeap = new MaxHeap<>(10);
        emptyHeap.insert(ELEMENT_A);
        emptyHeap.insert(ELEMENT_B);
        emptyHeap.insert(ELEMENT_E);
        emptyHeap.increaseKey(2, ELEMENT_E);

        if(ELEMENT_E != emptyHeap.getElement(0)) {
            result = pssibleResult.FAIL;
        }
        return result;
    }

    public static pssibleResult checkIfMaxHeap(int numOfParents, MaxHeap<Integer> testingHeap){
        pssibleResult result = pssibleResult.PASS;
        MaxHeap<Integer> emptyHeap = testingHeap;
        emptyHeap.insert(ELEMENT_A);
        emptyHeap.insert(ELEMENT_B);
        emptyHeap.insert(ELEMENT_C);
        emptyHeap.insert(ELEMENT_D);
        emptyHeap.insert(ELEMENT_E);
        emptyHeap.insert(ELEMENT_F);
        emptyHeap.insert(ELEMENT_G);

        for(int i = 0; i < 3; i++) {
            int parentNode = emptyHeap.getElement(i);
            if(parentNode < emptyHeap.getElement(i + 1) || parentNode < emptyHeap.getElement(i + 2)){
                result = pssibleResult.FAIL;
            }
        }
        return result;
    }

    public static pssibleResult checkIfSorted(int numOfParents, MaxHeap<Integer> testingHeap){
        pssibleResult result = pssibleResult.PASS;
        MaxHeap<Integer> emptyHeap = testingHeap;

        for(int i = 0; i < numOfParents; i++) {
            int parentNode = emptyHeap.getElement(i);
            if(parentNode < emptyHeap.getElement(i + 1) || parentNode < emptyHeap.getElement(i + 2)){
                result = pssibleResult.FAIL;
            }
        }
        return result;
    }

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