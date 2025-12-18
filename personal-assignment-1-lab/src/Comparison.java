import java.util.ArrayList;
import java.util.function.Supplier;

public class Comparison {
    private int n;
    private int[] arr;
    private ArrayList<Integer> list;
    private int keySearch;
    private int valueInsert;
    private int indexInsert;
    private int indexDelete;
    private ArrayOperations arrayOp= new ArrayOperations();
    private ArrayListOperations arrayListOp= new ArrayListOperations();
    // Constructor
    public Comparison(int n, int[] arr, ArrayList list, int keySearch, int valueInsert, int indexInsert, int indexDelete) {
        this.n = n;
        this.arr = arr;
        this.list = list;
        this.valueInsert = valueInsert;
        this.indexInsert = indexInsert;
        this.indexDelete = indexDelete;
        this.keySearch = keySearch;
    }
    /**
    * Method for run and count execution time for all operation (traversal, searching, insertion, deletion)
    * Compare time between process using Array and Array List
    * The comparison of execution times is displayed in a table
    * */
    public void compare() {
        // TRAVERSAL
        System.out.println("=== TRAVERSAL ===");
        System.out.print("Array Traversal: ");
        ResultWithTime<Void> resArrTraversal = runAndCountTime(()-> arrayOp.traversal(arr));
        System.out.print("\nArray List Traversal: ");
        ResultWithTime<Void> resListTraversal  = runAndCountTime(()-> arrayListOp.traversal(list));

        // SEARCHING
        System.out.println("\n\n=== SEARCHING ===");
        ResultWithTime<Integer> resBinarySearchArr = runAndCountTime(()-> arrayOp.binarySearch(arr,keySearch));
        ResultWithTime<Integer> resBinarySearchList = runAndCountTime(()-> arrayListOp.searchUseBinarySearch(list,keySearch));
        ResultWithTime<Integer> resLinearSearchArr = runAndCountTime(()-> arrayOp.linearSearch(arr,keySearch));
        ResultWithTime<Integer> resLinearSearchList = runAndCountTime(()-> arrayListOp.searchUseLinearSearch(list,keySearch));
        printResultSearching(resBinarySearchArr.result,keySearch,"Binary Search","Array");
        printResultSearching(resBinarySearchList.result,keySearch,"Binary Search","Array List");
        printResultSearching(resLinearSearchArr.result,keySearch,"Linear Search","Array");
        printResultSearching(resLinearSearchList.result,keySearch,"Binary Search","Array List");

        // INSERTION
        System.out.println("\n=== INSERTION ===");
        ResultWithTime<int[]> resInsertionArr = runAndCountTime(()->arrayOp.insertion(arr,valueInsert,indexInsert));
        ResultWithTime<ArrayList> resInsertionList = runAndCountTime(()->arrayListOp.insertion(list,valueInsert,indexInsert));
        System.out.print("Array setelah penyisipan " + valueInsert + " pada indeks ke-"+indexInsert +":");
        arrayOp.traversal(resInsertionArr.result);
        System.out.print("\nArray List setelah penyisipan " + valueInsert + " pada indeks ke-"+indexInsert +":");
        arrayListOp.traversal(resInsertionList.result);

        // DELETION
        System.out.println("\n\n=== DELETION ===");
        ResultWithTime<int[]> resDeletionArr = runAndCountTime(()->arrayOp.deletion(resInsertionArr.result,indexDelete));
        ResultWithTime<ArrayList> resDeletionList = runAndCountTime(()->arrayListOp.deletion(list,indexDelete));
        System.out.print("Array setelah penghapusan pada indeks ke-"+indexDelete +":");
        arrayOp.traversal(resDeletionArr.result);
        System.out.print("\nArray List setelah penghapusan pada indeks ke-"+indexDelete +":");
        arrayListOp.traversal(resDeletionList.result);

        System.out.println("\n\n=== Hasil Perbandingan Kinerja " + n +" data (dalam nano second) ===");
        System.out.printf("%-20s | %-15s | %-15s\n", "Operasi", "Array", "ArrayList");
        System.out.println("------------------------------------------------------------");

        printBodyTable("Traversal", resArrTraversal.duration, resListTraversal.duration);
        printBodyTable("Binary Search", resBinarySearchArr.duration, resBinarySearchList.duration);
        printBodyTable("Linear Search", resLinearSearchArr.duration, resLinearSearchList.duration);
        printBodyTable("Insertion", resInsertionArr.duration, resInsertionList.duration);
        printBodyTable("Deletion", resDeletionArr.duration, resDeletionList.duration);
    }

    private void printBodyTable(String label, long durationArray, long durationList) {
        System.out.printf("%-20s | %-15d | %-15d\n", label, durationArray,durationList);
    }

    private void printResultSearching(int result, int keySearch, String label, String arrOrList){
        if(result == -1){
            System.out.println(label + ": Pencarian " +  keySearch + " dalam " + arrOrList + ": tidak ditemukan!");
        }else{
            System.out.println(label + ": Pencarian " +  keySearch + " dalam " + arrOrList + " : Ditemukan di indeks ke-"+ result);
        }
    }

    /**
    * Run task and measures how long it takes to execute.
    * param <T> the type of result produced by the task
    * param task the task to be executed
    * return the result of the task along with its execution time (in nanoseconds)
    * */
    private static <T> ResultWithTime<T> runAndCountTime(Supplier<T> task) {
        long start = System.nanoTime();
        T result = task.get();
        long duration = System.nanoTime() - start;
        return new ResultWithTime<>(result, duration);
    }

    /**
     * Run task doesn't return any value and measures how long it takes to execute
     * used for operations that only perform actions (ex:traversal)
     * only return execute times in nanoseconds
     * */
    private static ResultWithTime<Void> runAndCountTime(Runnable task) {
        long start = System.nanoTime();
        task.run();
        long duration = System.nanoTime() - start;
        return new ResultWithTime<>(null, duration);
    }



}
