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
        System.out.println("emptyHeap.isEmpty(): " + isEmptyTest());
        System.out.println("notEmptyHeap.isEmpty(): " + isEmpty_WithElement());
        System.out.println("3Element_insert_rightPlace: " + insert3Element());
        System.out.println("extractMax_callTwice: " + extractMax_callTwice());
        
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



}