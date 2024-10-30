package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.awt.Image;


public class Project extends JFrame{
    Project(){
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
            Image i2 = i1.getImage().getScaledInstance(1550,850,Image.SCALE_DEFAULT); 
            ImageIcon i3 = new ImageIcon(i2);
            JLabel Image = new JLabel(i3);
            add(Image);
    
    JMenuBar mb = new JMenuBar();
    setJMenuBar(mb);
    
    JMenu master =new JMenu("master");
    mb.add(master);
    
    JMenuItem newcustomer = new JMenuItem("New Customer");
    newcustomer.setFont(new Font("monospaced",Font.PLAIN,12));
    newcustomer.setBackground(Color.white);
    
    ImageIcon icon1= new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
    Image image2 = icon1.getImage().getScaledInstance(20,20,Image.ABORT);
    newcustomer.setIcon(new ImageIcon(image1));
    newcustomer.setMnemonic('D');
    
    master.add(newcustomer);
    
    setLayout(new FlowLayout());
    
    setVisible(true);
    }
public static void main(String[] args){
    new Project();
    
}
}
      


