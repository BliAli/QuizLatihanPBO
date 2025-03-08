package rentalsystem;

import java.awt.HeadlessException;
import java.awt.ScrollPane;
import javax.swing.*;

/* @author aliad */
public class ResultRental extends JFrame {

    public ResultRental(DataRental data) throws HeadlessException {
        setTitle("Result Penyewaan");
        setSize(400, 300);
        setLocationRelativeTo(null);
        
        JTextArea resultData = new JTextArea(data.getDetail());
        resultData.setEditable(false);
        add(new JScrollPane(resultData));
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
}
