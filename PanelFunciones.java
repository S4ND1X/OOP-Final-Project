import javax.swing.*;
import java.awt.*;


public class PanelFunciones extends JPanel {

    private JButton btAdd, 
                    btClear;
    private JTextField func; 
    private Functions fs;

    public PanelFunciones(Functions fs){
        super();
        this.fs = fs; 
        this.setPreferredSize(new Dimension(300,1000));
        this.setVisible(true); 
        this.func = new JTextField(25);
        this.btAdd = new JButton("Add"); 
        this.btClear = new JButton("Clear");

        this.func.setBounds(50,50,200,50);
        this.func.setVisible(true);
        this.btAdd.setBounds(50, 1000, 100, 50);
        this.btClear.setBounds(150,1000,100,50);
        
        //Add Elements 
        this.add(func);
        this.add(btAdd);
        this.add(btClear);
    }
}