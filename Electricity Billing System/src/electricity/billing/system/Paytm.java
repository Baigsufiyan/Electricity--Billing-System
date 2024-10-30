package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class Paytm extends JFrame implements ActionListener {

    String meter;
    JButton back;

    Paytm(String meter) {
        this.meter = meter;

        // Set background color to white
        getContentPane().setBackground(Color.WHITE);

        // Create a simple interface
        JLabel label = new JLabel("Click the button to pay with Paytm:");
        label.setBounds(50, 50, 300, 30);
        label.setForeground(Color.BLACK); // Set text color to black for visibility
        add(label);

        // Create the Pay button
        JButton payButton = new JButton("Pay with Paytm");
        payButton.setBounds(50, 100, 150, 30);
        payButton.addActionListener(this);
        add(payButton);

        back = new JButton("Back");
        back.setBounds(640, 20, 80, 30);
        back.addActionListener(e -> {
            setVisible(false);
            new PayBill(meter);
        });
        add(back);

        setSize(800, 500);
        setLocation(230, 150);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Desktop.getDesktop().browse(new URI("https://paytm.com/electricity-bill-payment"));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to open Paytm payment page.");
        }
    }

    public static void main(String[] args) {
        new Paytm("");
    }
}
