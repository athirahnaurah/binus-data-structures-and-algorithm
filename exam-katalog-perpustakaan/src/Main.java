public class Main {
    public static void main(String[] args) {

        LibraryBST libraryBST = new LibraryBST();

        // add 5 books
        libraryBST.addBook(101,"Buku 101");
        libraryBST.addBook(250,"Buku 250");
        libraryBST.addBook(55,"Buku 55");
        libraryBST.addBook(301,"Buku 301");
        libraryBST.addBook(175,"Buku 175");
        // find max
        BookNode bookNode = libraryBST.findMax();
        System.out.println("Buku dengan callNumber tertinggi: " + bookNode.callNumber + "-" + bookNode.title);

    }
}