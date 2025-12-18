import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // test using 5 data
        int size = 5;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i*10);
        }

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = list.get(i);
        }
        /** comparison of traversal, searching, insertion, and deletion
        * between Array and ArrayList using 5 data elements
        * search value : 30
        * insert value : 25 at index-3
        * delete value at index-3
        */
        Comparison comparison = new Comparison(size, arr, list,30,25,3,3);
        comparison.compare();

        // test using 1000 data
        int size2 = 1000;
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list2.add(i);
        }

        int[] arr2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            arr2[i] = list2.get(i);
        }
        /**  comparison of traversal, searching, insertion, and deletion
        * between Array and ArrayList using 1000 data elements
        * search value : 457
        * insert value : 1001 at index-567
        * delete value at index-567
        */
        Comparison comparison2 = new Comparison(size2, arr2, list2,457,1001,567,567);
        comparison2.compare();

    }
}