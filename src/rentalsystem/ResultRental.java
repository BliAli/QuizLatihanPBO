package rentalsystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/* @author aliad */
public class ResultRental extends JFrame implements ActionListener{
    JButton btnKembali, btnDone;
    JFrame prevPage;
    public ResultRental(DataRental data, JFrame prevPage) throws HeadlessException {
        this.prevPage = prevPage;
        setTitle("Result Penyewaan");
        setLayout(new BorderLayout(10, 10));
        setSize(400, 300);
        setLocationRelativeTo(null);
        
        JTextArea resultData = new JTextArea(data.getDetail());
        resultData.setEditable(false);
        add(new JScrollPane(resultData), BorderLayout.CENTER);
        
        JPanel panelBawah = new JPanel(new BorderLayout());
        JPanel panelKiri = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnKembali = new JButton("Kembali");
        btnKembali.addActionListener(this);
        panelKiri.add(btnKembali);
        panelBawah.add(panelKiri, BorderLayout.WEST);
        
        JPanel panelKanan = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnDone = new JButton("Done");
        btnDone.addActionListener(this);
        panelKanan.add(btnDone);
        panelBawah.add(panelKanan, BorderLayout.EAST);
        
        add(panelBawah, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnKembali) {
            dispose();
            prevPage.setVisible(true);
        } else if (e.getSource() == btnDone){
            System.exit(0);
        }
    }
    
    
    
}
