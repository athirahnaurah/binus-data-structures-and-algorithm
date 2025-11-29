public class Barang {
    private String nama;
    private int jumlahStok;
    private double harga;
    public Barang(String nama, int jumlahStok, double harga){
        this.nama = nama;
        this.jumlahStok = jumlahStok;
        this.harga = harga;
    }
    public String getNama(){
        return this.nama;
    }
    public int getJumlahStok(){
        return this.jumlahStok;
    }
    public double getHarga(){
        return this.harga;
    }

    public void setJumlahStok(int jumlahStok){
        this.jumlahStok = jumlahStok;
    }
}
