import java.util.Scanner;

public class Main {
    public static int size = 10;
    public static Barang[] dataBarang = new Barang[size];

    public static void main(String[] args) {

        /* Soal 1 Menambahkan dan Menampilkan Inventaris */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan total barang yang diinput: ");
        int jumlahBarang = scanner.nextInt();

        for(int i = 0; i < jumlahBarang; i++){
            if(i >= size){
                System.out.println("Maksimal jumlah barang " + size + "!");
                break;
            }
            scanner.nextLine();
            System.out.println("Masukkan Data Barang ke - "+(i+1));
            System.out.print("Nama: ");
            String name = scanner.nextLine();
            System.out.print("Harga: ");
            double harga = scanner.nextDouble();
            System.out.print("Jumlah Stok: ");
            int stok = scanner.nextInt();
            dataBarang[i] = new Barang(name,stok, harga);
        }
        System.out.println("Berhasil menambahkan data barang!");

        System.out.println("Data Inventaris Toko");
        displayAll(dataBarang);

        /* Soal 2 Mengupdate Stok dan Mencari Barang */

        /* Mengupdate stok */
        System.out.print("Masukkan nama barang yang ingin di update: ");
        scanner.nextLine();
        String cari = scanner.nextLine();
        System.out.print("Masukkan jumlah stok baru: ");
        int stokBaru = scanner.nextInt();
        updateStokByName(cari, stokBaru);

        System.out.println("Inventaris Setelah diupdate");
        displayAll(dataBarang);

        /* Mencari Barang */
        System.out.print("Masukkan nama barang yang ingin dicari: ");
        scanner.nextLine();
        String cari2 = scanner.nextLine();
        cariBarang(cari2);

        scanner.close();
    }

    public static void updateStokByName(String nama, int stokBaru){
        boolean found = false;
        for(Barang barang : dataBarang){
            if(barang != null){
                if(barang.getNama().equalsIgnoreCase(nama)){
                    found = true;
                    barang.setJumlahStok(stokBaru);
                    break;
                }
            }
        }
        if(!found){
            System.out.println("Barang " + nama + " tidak ditemukan!");
        }
    }

    public static void displayAll(Barang[] dataBarang){
        int i = 1;
        for(Barang barang: dataBarang){
            if(barang != null){
                System.out.println(i+". Nama: " + barang.getNama() +", Jumlah Stok: "+ barang.getJumlahStok() + ", Harga: " + barang.getHarga());
                i++;
            }
        }
    }

    public static void cariBarang(String nama){
        boolean found = false;
        for(Barang barang : dataBarang){
            if(barang != null){
                if(barang.getNama().equalsIgnoreCase(nama)){
                    System.out.println("Hasil pencarian:");
                    System.out.println("Nama: " + barang.getNama() +", Jumlah Stok: "+ barang.getJumlahStok() + ", Harga: " + barang.getHarga());
                    found = true;
                    break;
                }
            }
        }
        if(!found){
            System.out.println("Barang " + nama + " tidak ditemukan!");
        }
    }
}