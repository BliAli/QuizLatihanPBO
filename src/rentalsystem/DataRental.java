package rentalsystem;

/* @author aliad */
public class DataRental {
    private String namaPenyewa, jenisKendaraan, namaKendaraan, noTelpon;
    private int lamaSewa;
    private double hargaSewa;

    public DataRental(String nama, String jenis, String namaKendaraan, String noTelp, int lamaSewa, double harga) {
        this.namaPenyewa = nama;
        this.jenisKendaraan = jenis;
        this.noTelpon = noTelp;
        this.lamaSewa = lamaSewa;
        this.hargaSewa = harga;
        this.namaKendaraan = namaKendaraan;
    }
    
    
    public String getDetail(){
        return 
            "Nama\t\t: " + this.namaPenyewa +
            "\nNo Telepon\t: " + this.noTelpon +
            "\nJenis Kendaraan\t: " + this.jenisKendaraan +
            "\nNama Kendaraan\t: " + this.namaKendaraan +
            "\nLama Sewa\t: " + this.lamaSewa + " Hari";
    }
}
