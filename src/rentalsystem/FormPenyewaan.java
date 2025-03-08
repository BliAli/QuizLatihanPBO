package rentalsystem;

import java.util.HashMap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;

/* @author aliad*/
public class FormPenyewaan extends JFrame{
    private JTextField namaInput, noTelponInput, lamaSewaInput;
    private HashMap <String, Integer> daftarKendaraan;
    private ButtonGroup pilihanKendaraan;
    private JLabel hargaLabel;
    private String jenisKendaraan;
    private String kendaraanSelected;
    private double hargaSewa;
    private JButton btnSubmit;

    public FormPenyewaan(String jenisKendaraan) throws HeadlessException {
        this.jenisKendaraan = jenisKendaraan;
        
        setTitle("Form Pengisian Data Sewa");
        setLayout(new GridLayout(6, 1));
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        add(new JLabel("Nama\t: "));
        namaInput = new JTextField();
        add(namaInput);
        
        add(new JLabel("No Telepon\t: "));
        noTelponInput = new JTextField();
        add(noTelponInput);
        
        add(new JLabel("Daftar Kendaraaan:"));
        
        daftarKendaraan = new HashMap<>();
        if(jenisKendaraan.equals("Motor")){
            daftarKendaraan.put("Supra-X", 75000);
            daftarKendaraan.put("Beat Karbu", 90000);
            daftarKendaraan.put("Motor Tetangga", 120000);
        } else if(jenisKendaraan.equals("Mobil")){
            daftarKendaraan.put("Mercedes", 180000);
            daftarKendaraan.put("Truk Angkut", 200000);
            daftarKendaraan.put("McQueen", 250000);
        }
        hargaLabel = new JLabel("Harga\t: Rp. -");
        
        pilihanKendaraan = new ButtonGroup();
        JPanel pilihanKendaraanPanel = new JPanel();
        pilihanKendaraanPanel.setLayout(new FlowLayout());
        
        for (String namaKendaraan : daftarKendaraan.keySet()) {
            JRadioButton rbKendaraan = new JRadioButton(namaKendaraan);
            pilihanKendaraan.add(rbKendaraan);
            pilihanKendaraanPanel.add(rbKendaraan);
            
            rbKendaraan.addActionListener(e -> {
                kendaraanSelected = namaKendaraan;
                hargaSewa = daftarKendaraan.get(namaKendaraan);
                hargaLabel.setText("Harga\t: Rp. " + hargaSewa);
            });
        }
        add(hargaLabel);
        add(pilihanKendaraanPanel);
        
        add(new JLabel("Lama Sewa (Hari)\t: "));
        lamaSewaInput = new JTextField();
        add(lamaSewaInput);
        
        btnSubmit = new JButton("Submit");
        add(btnSubmit);
        btnSubmit.addActionListener(e -> inputData()); //biar cpt
        
        setVisible(true);
    }    
    public void inputData(){
        try {
            String nama = namaInput.getText();
            String noTelpon = noTelponInput.getText();
            int lamaSewa = Integer.parseInt(lamaSewaInput.getText());
            
            if (kendaraanSelected == null) {
                JOptionPane.showMessageDialog(this, "Pilih " + jenisKendaraan + " Yang Hendak Disewa !", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            DataRental data = new DataRental(nama, jenisKendaraan, kendaraanSelected , noTelpon, lamaSewa, hargaSewa);
            new ResultRental(data);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Input tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
