/*Programa Realizado por 
 * Jorge Sanchez Diaz A01635375
 * Andres Diaz De Leon A01620020
*/
import java.awt.Canvas; 
import java.awt.Canvas; 
import java.awt.Dimension;
import javax.swing.*;


public class Window extends Canvas {

    private static final long serialVersionUID = 1L;

    public Window(int width, int height, String title, Game game) {
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}