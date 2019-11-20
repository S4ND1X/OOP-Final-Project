import java.awt.Dimension;
import javax.swing.JFrame;

public class Window  extends JFrame{
	
	private static final long serialVersionUID = -8255319694373975038L;
	
	public Window(int width, int height, String title, Game game) {
		super();
		//Crear el frame donde se dibujara		
		//Propiedades del JFrame
		this.setPreferredSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(width, height));
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null); 
		this.add(game);
		this.setVisible(true);
		game.start();
		
	}
	

}
