import java.awt.*;
import javax.swing.*;



public class Ventana extends JFrame {

    public Ventana() {
        super("Grafer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Functions fs = new Functions();
        this.add(fs);
        this.add(new PanelFunciones(fs),BorderLayout.EAST);
        this.setVisible(true);
        this.pack();
        this.setResizable(false);
    }

    public static void main(String[] args) {
        new Ventana();
    }
}