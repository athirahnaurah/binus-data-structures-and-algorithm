public class LibraryBST {
    BookNode root;

    public LibraryBST(){
        this.root = null;
    }

    public void addBook(int callNumber, String title){
        this.root = insert(root,callNumber, title);
    }

    private BookNode insert(BookNode root, int callNumber, String title){
        if(root == null){
            root = new BookNode(callNumber,title);
            return root;
        }

        if(callNumber < root.callNumber){
            root.left = insert(root.left,callNumber,title);
        } else if (callNumber > root.callNumber) {
            root.right = insert(root.right,callNumber,title);
        }

        return root;
    }

    public BookNode findMax(){
        if(root == null){
            return null;
        }

        BookNode current = root;
        while(current.right != null){
            current = current.right;
        }
        return current;
    }
}
