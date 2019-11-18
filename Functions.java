//Andrés Díaz de León 
//Jorge Sanchez 

import java.awt.*; 
import  javax.swing.*; 

public class Functions extends JPanel {

    public Functions(){
        super();
        this.setPreferredSize(new Dimension(1000,1000));
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(500,0,500,1000); 
        g.drawLine(0,500,1000,500);
        g.setColor(Color.BLUE);
        g.drawLine(999,0,999,1000); 
        g.fillOval(0, 0, 5, 5);
    }

}