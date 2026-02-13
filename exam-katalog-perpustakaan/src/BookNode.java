public class BookNode {
    int callNumber;
    String title;
    BookNode left;
    BookNode right;

    public BookNode(int callNumber, String title){
        this.callNumber = callNumber;
        this.title = title;
        this.left = this.right = null;
    }
}
