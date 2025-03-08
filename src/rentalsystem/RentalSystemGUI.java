package rentalsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* @author aliad */
public class RentalSystemGUI extends JFrame implements ActionListener{
    private JLabel labelPilihan;
    private JButton btnMotor, btnMobil;
    
    public RentalSystemGUI() throws HeadlessException {
        setTitle("Rental System by Bli Ali");
        setLayout(new GridLayout(2, 1));
        setSize(400, 300);
        
        labelPilihan = new JLabel("Pilih Jenis Kendaraan Yang Ingin Anda Sewa : ", SwingConstants.CENTER);
        add(labelPilihan);
        
        JPanel btnKendaraan = new JPanel(new GridLayout(1, 2, 10, 0));
        btnMotor = new JButton("Motor");
        btnMobil = new JButton("Mobil");
        
        btnKendaraan.add(btnMotor);
        btnKendaraan.add(btnMobil);
        
        add(btnKendaraan);
        
        btnMotor.addActionListener(this);
        btnMobil.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnMotor) {
            new FormPenyewaan("Motor");
        } else if (e.getSource() == btnMobil){
            new FormPenyewaan("Mobil");
        }
    }
    
    
}
