package rentalsystem;

/* @author aliad */
public class DataRental {
    private String namaPenyewa, jenisKendaraan, namaKendaraan, noTelpon;
    private int lamaSewa;
    private double hargaSewa, totalHarga;

    public DataRental(String nama, String jenis, String namaKendaraan, String noTelp, int lamaSewa, double hargaSewa) {
        this.namaPenyewa = nama;
        this.jenisKendaraan = jenis;
        this.noTelpon = noTelp;
        this.lamaSewa = lamaSewa;
        this.hargaSewa = hargaSewa;
        this.namaKendaraan = namaKendaraan;
    }

    public double getTotalHarga() {
        totalHarga = hargaSewa * lamaSewa;
        return totalHarga;
    }
    public String getDetail(){
        return 
            "Nama\t\t: " + this.namaPenyewa +
            "\nNo Telepon\t\t: " + this.noTelpon +
            "\nJenis Kendaraan\t: " + this.jenisKendaraan +
            "\nNama Kendaraan\t: " + this.namaKendaraan +
            "\nLama Sewa\t\t: " + this.lamaSewa + " Hari" +
            "\nTotal Biaya Sewa\t: " + this.getTotalHarga();
    }
}
