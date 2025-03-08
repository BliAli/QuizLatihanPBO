package rentalsystem;

/* @author aliad */
public class DataRental {
    private String namaPenyewa, jenisKendaraan, namaKendaraan;
    private int noTelpon, lamaSewa;
    private double hargaSewa, totalHargaSewa;

    public DataRental(String nama, String jenis, String namaKendaraan, int noTelp, int lamaSewa, double harga) {
        this.namaPenyewa = nama;
        this.jenisKendaraan = jenis;
        this.noTelpon = noTelp;
        this.lamaSewa = lamaSewa;
        this.totalHargaSewa = harga;
        this.namaKendaraan = namaKendaraan;
    }

    public double getTotalHargaSewa() {
        return this.hargaSewa * this.lamaSewa;
    }
    
    
    
    public String getDetail(){
        return 
            "Nama\t\t: " + this.namaPenyewa +
            "\nNo Telepon\t: " + this.noTelpon +
            "\nJenis Kendaraan\t: " + this.jenisKendaraan +
            "\nNama Kendaraan\t: " + this.namaKendaraan +
            "\nLama Sewa\t: " + this.lamaSewa + " Hari" +
            "\nTotal Harga\t: " + this.getTotalHargaSewa();
    }
}
