
import javax.swing.*;

public class Splash extends JFrame {

        Splash() {
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
            JLabel image = new JLabel(i1);
            add(image);
        
            
            
        setSize(730,550);
        setVisible(true);
        setLocation(500,200);

        
    }
public static void main(String  []args){
    new Splash();
    
}
}