import java.util.ArrayList;
import java.util.Collections;

public class ArrayListOperations {
    /**
     * Method to traverse array list (access all element sequentially)
     * loop each element one by one and print it
     * */
    public void traversal(ArrayList<Integer> list) {
        list.forEach(value ->{
            System.out.print(value + " ");
        });
    }

    /**
     * This method is used to insert a value at a specific index
     *
     * insertion process uses the ArrayList function add(index, value)
     *
     * param list the original array list
     * param value the value to be inserted into the array list
     * param index the position where the value will be inserted
     * return the array list
     */
    public ArrayList insertion(ArrayList list, int value, int index){
        list.add(index,value);
        return list;
    }

    /**
     * This method is used to delete a value at a specific index
     *
     * deletion process uses the ArrayList function remove(index)
     *
     * param list the original array list
     * param index the position where the value will be deleted
     * return the array list
     */
    public ArrayList deletion(ArrayList list, int index){
        list.remove(index);
        return list;
    }

    /**
     * This method is used to sorting an array list
     *
     * sorting process uses the Collections function sort(list)
     *
     * param list the original array list
     * return the sorted array list
     */
    public void sorting(ArrayList list){
        Collections.sort(list);
    }

    /**
     * Performs a binary search on a array list
     *
     * This method searches uses the Collections function binarySearch
     *
     * param list the array list to be searched
     * param key the value to search for
     */
    public int searchUseBinarySearch(ArrayList list, int key){
        sorting(list);
        return Collections.binarySearch(list,key);
    }

    /**
     * Performs a linear search on a array list
     *
     * This method searches uses the ArrayList function indexOf
     *
     * param list the array list to be searched
     * param key the value to search for
     */
    public int searchUseLinearSearch(ArrayList list, int key){
        return list.indexOf(key);
    }
}
