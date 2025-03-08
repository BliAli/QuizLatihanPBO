package rentalsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* @author aliad*/
public class FormPenyewaan extends JFrame implements ItemListener{
    private JTextField namaInput, noTelponInput, lamaSewaInput;
    private JRadioButton rb1, rb2, rb3;
    private ButtonGroup daftarKendaraan;
    private JLabel hargaLabel;
    private String jenisKendaraan;
    private JButton btnSubmit;
    private String kendaraanSelected;

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
        JPanel daftarKendaraanPanel = new JPanel();
        daftarKendaraanPanel.setLayout(new FlowLayout());
        
        if(jenisKendaraan.equals("Motor")){
            rb1 = new JRadioButton("Supra-X");
            rb2 = new JRadioButton("Beat Karbu");
            rb3 = new JRadioButton("Motor Tetangga");
        } else if(jenisKendaraan.equals("Mobil")){
            rb1 = new JRadioButton("Avanza");
            rb2 = new JRadioButton("Inova");
            rb3 = new JRadioButton("Mclaren lo warna apa?");
        }
        daftarKendaraan = new ButtonGroup();
        daftarKendaraan.add(rb1);
        daftarKendaraan.add(rb2);
        daftarKendaraan.add(rb3);
        
        daftarKendaraanPanel.add(rb1);
        daftarKendaraanPanel.add(rb2);
        daftarKendaraanPanel.add(rb3);
        add(daftarKendaraanPanel);
        
        rb1.addItemListener(this);
        rb2.addItemListener(this);
        rb3.addItemListener(this);
        
        add(new JLabel("Lama Sewa (Hari)\t: "));
        lamaSewaInput = new JTextField();
        add(lamaSewaInput);
        
        hargaLabel = new JLabel("Rp 100.000");
        add(hargaLabel);
        
        btnSubmit = new JButton("Submit");
        add(btnSubmit);
        btnSubmit.addActionListener(e -> inputData()); //biar cpt
        
        setVisible(true);

        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JRadioButton btnSelected = (JRadioButton) e.getItem();
        if (e.getStateChange() == ItemEvent.SELECTED){
            kendaraanSelected = btnSelected.getText();
        } else {
        }
    }        
    public void inputData(){
        try {
            String nama = namaInput.getText();
            String noTelpon = noTelponInput.getText();
            int lamaSewa = Integer.parseInt(lamaSewaInput.getText());
            
            double totalHarga = lamaSewa * 100000;
            
            DataRental data = new DataRental(nama, jenisKendaraan, kendaraanSelected , noTelpon, lamaSewa, totalHarga);
            new ResultRental(data);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Input tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
