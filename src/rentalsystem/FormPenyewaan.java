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
    private JButton btnSubmit, btnKembali;
    private JFrame prevPage;

    public FormPenyewaan(String jenisKendaraan, JFrame prevPage) throws HeadlessException {
        this.jenisKendaraan = jenisKendaraan;
        this.prevPage = prevPage;
        
        setTitle("Form Pengisian Data Sewa");
        setLayout(new BorderLayout(10, 10));
        setSize(450, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 20, 20));
        
        formPanel.add(new JLabel("Nama\t: "));
        namaInput = new JTextField();
        formPanel.add(namaInput);
        
        formPanel.add(new JLabel("No Telepon\t: "));
        noTelponInput = new JTextField();
        formPanel.add(noTelponInput);
        
        formPanel.add(new JLabel("Daftar Kendaraaan:"));
        
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
        
        JPanel pilihanKendaraanPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pilihanKendaraan = new ButtonGroup();
        
        for (String namaKendaraan : daftarKendaraan.keySet()) {
            JRadioButton rbKendaraan = new JRadioButton(namaKendaraan);
            pilihanKendaraan.add(rbKendaraan);
            pilihanKendaraanPanel.add(rbKendaraan);
            
            rbKendaraan.addActionListener(e -> {
                kendaraanSelected = namaKendaraan;
                hargaSewa = daftarKendaraan.get(namaKendaraan);
                hargaLabel.setText("Harga\t: Rp. " + hargaSewa + " /hari");
            });
        }
        formPanel.add(pilihanKendaraanPanel);
        
        hargaLabel = new JLabel("Harga\t: Rp. - /hari");
        JPanel hargaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        hargaPanel.add(hargaLabel);
        
        formPanel.add(new JLabel("Lama Sewa (Hari)\t: "));
        lamaSewaInput = new JTextField();
        formPanel.add(lamaSewaInput);
        
        btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(e -> inputData()); //biar cpt
        
        btnKembali = new JButton("Kembali");
        btnKembali.addActionListener(e -> {
            dispose();
            prevPage.setVisible(true);
        });
                
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.add(btnKembali);
        btnPanel.add(btnSubmit);
        
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(hargaPanel, BorderLayout.NORTH);
        bottomPanel.add(btnPanel, BorderLayout.CENTER);
        
        add(formPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);   
        
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
