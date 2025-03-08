package rentalsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* @author aliad*/
public class FormPenyewaan extends JFrame implements ActionListener{
    private JTextField namaInput, noTelponInput, lamaSewaInput;
    private JComboBox<String> kendaraanBox;
    private JLabel hargaLabel;
    private String jenisKendaraan;
    private JButton btnSubmit;

    public FormPenyewaan(String jenisKendaraan) throws HeadlessException {
        this.jenisKendaraan = jenisKendaraan;
        
        setTitle("Form Pengisian Data Sewa");
        setLayout(new GridLayout(6, 1));
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        add(new JLabel("Nama\t: "));
        namaInput = new JTextField();
        add(namaInput);
        
        add(new JLabel("No Telepon\t: "));
        noTelponInput = new JTextField();
        add(noTelponInput);
        
        add(new JLabel("Kendaraan:"));
        String[] kendaraanMotor = {"Supra X", "Beat Karbu", "Motor Tetangga"};
        String[] kendaraanMobil = {"Avanza", "BMW 3 Series", "Mustang"};
        
        kendaraanBox = new JComboBox<>(this.jenisKendaraan.equals("Motor") ? kendaraanMotor : kendaraanMobil);
        add(kendaraanBox);
        
        add(new JLabel("Lama Sewa (Hari)\t: "));
        lamaSewaInput = new JTextField();
        add(lamaSewaInput);
        
        hargaLabel = new JLabel("Rp 100.000");
        add(hargaLabel);
        
        btnSubmit = new JButton("Submit");
        add(btnSubmit);
        btnSubmit.addActionListener(this);
        
        setVisible(true);

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            inputData();
        }
    }
    
    public void inputData(){
        try {
            String nama = namaInput.getText();
            String noTelpon = noTelponInput.getText();
            String namaKendaraan = (String) kendaraanBox.getSelectedItem();
            int lamaSewa = Integer.parseInt(lamaSewaInput.getText());
            
            double totalHarga = lamaSewa * 100000;
            
            DataRental data = new DataRental(nama, "Mobil", namaKendaraan , noTelpon, lamaSewa, totalHarga);
            new ResultRental(data);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Input tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
