import java.util.ArrayList;

public class MaxHeapTest {
    public static void main(String[] args){

        ArrayList<Integer> compareList = new ArrayList<>(10);

        //Test if isEmpty returns true
        MaxHeap<Integer> testingHeap = new MaxHeap(0);
        isEmptyTest(testingHeap, "emptyHeap");

        //Test if insert works for two values
        MaxHeap<Integer> insertToHeap = new MaxHeap(3);
        insertToHeap.insert(1);
        insertToHeap.insert(2);
        compareList.add(1,1); 
        compareList.add(2,2);
        if (insertToHeap.getElement(1) == compareList.get(1)) {
            System.out.print("Insert two element list passed for first element\n");
        } else {
            System.out.print("Insert two element list failed for first element\n");
        }
        if (insertToHeap.getElement(2) == compareList.get(2)) {
            System.out.print("Insert two element list passed for second element\n");
        } else {
            System.out.print("Insert two element list failed for second element\n");
        }

        //Test if extractMax method 

        




    }

    public static void isEmptyTest(MaxHeap<Integer> heap, String scenario) {
        if (heap.isEmpty() == true) {
            System.out.print(scenario + " PASSED");
        } else {
            System.out.print(scenario + " FAILED");
        }
    }
}