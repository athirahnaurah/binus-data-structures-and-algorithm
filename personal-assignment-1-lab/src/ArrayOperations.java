public class ArrayOperations {
    /**
    * Method to traverse array (access all element sequentially)
    * loop each element one by one and print it
    * */
    public void traversal(int data[]){
        for(int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }
    }

    /**
     * Performs a linear search on an array
     *
     * This method searches for a target value by checking each element
     * in the array one by one from the beginning until the value is found
     *
     * param arr the array to be searched
     * param key the value to search for
     * return the index of the key if found, otherwise -1
     */
    public int linearSearch(int data[], int key){
        for(int i = 0; i < data.length; i++){
            if(data[i] == key){
                return i;
            }
        }
        return -1;
    }

    /**
     * Performs a binary search on a sorted array
     *
     * This method searches for a target value by repeatedly dividing
     * the search range into two halves
     *
     * param arr the array to be searched
     * param key the value to search for
     * return the index of the key if found, otherwise -1
     */
    public int binarySearch(int data[], int key){
        int low = 0, high = data.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (data[mid] == key) return mid;
            if (data[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    /**
     * This method is used to insert a value at a specific index
     *
     * param data the original array
     * param valueInsert the value to be inserted into the array
     * param indexInsert the position where the value will be inserted
     * return the new array
     */
    public int[] insertion(int data[], int valueInsert, int indexInsert){
        int newData[] = new int[data.length + 1];
        // copy data from the beginning of the array until element before the insert index into a new array
        System.arraycopy(data,0,newData,0,indexInsert);
        // insert new value at the specified index
        newData[indexInsert] = valueInsert;
        // copy remaining data from the insert index to the last index of the original array into the new array
        System.arraycopy(data,indexInsert,newData,indexInsert+1,data.length-indexInsert);
        return newData;
    }

    /**
     * This method is used to delete a value at a specific index
     *
     * param data the original array
     * param indexDelete the position where the value will be deleted
     * return the new array
     */
    public int[] deletion(int data[], int indexDelete){
        int newData[] = new int[data.length - 1];
        // copy data from the beginning of the array until element before the delete index into a new array
        System.arraycopy(data,0,newData,0,indexDelete);
        // copy remaining data from the delete index to the last index of the original array into the new array
        System.arraycopy(data,indexDelete + 1,newData,indexDelete,data.length - indexDelete - 1);
        return newData;
    }

}
