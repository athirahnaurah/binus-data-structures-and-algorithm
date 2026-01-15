import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SingleLinkedList list = new SingleLinkedList();

        int maksData = 5;
        int count = 0;

        while (count < maksData) {
            System.out.println("\nMasukkan Data Mahasiswa ke-" + (count + 1));

            // VALIDASI NIM
            System.out.print("NIM: ");
            String nim = scanner.nextLine();
            if (!nim.matches("\\d{1,10}")) {
                System.out.println("NIM harus angka dan maksimal 10 digit!");
                continue;
            }

            // VALIDASI NAMA
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            if (nama.length() > 30) {
                System.out.println("Nama maksimal 30 karakter!");
                continue;
            }

            // VALIDASI JURUSAN
            System.out.print("Jurusan: ");
            String jurusan = scanner.nextLine();
            if (jurusan.length() > 50) {
                System.out.println("Jurusan maksimal 50 karakter!");
                continue;
            }

            Mahasiswa mhs = new Mahasiswa(nim, nama, jurusan);
            list.insertTail(mhs);
            count++;
        }

        // SORT & DISPLAY
        list.sortByNim();
        System.out.println("\n=== DAFTAR MAHASISWA (SORT BY NIM) ===");
        list.display();

        scanner.close();

        // POP DATA MAHASISWA
        while (list.head != null) {
            list.pop();
        }
        System.out.println("\n=== DAFTAR MAHASISWA AFTER POP ===");
        list.display();
    }
}