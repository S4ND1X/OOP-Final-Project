import java.awt.Canvas;

public class Game extends Canvas implements Runnable{


	private static final long serialVersionUID = -1442798787354930462L;
	
	public static final int WIDTH = 640, 
							HEIGHT = WIDTH / 12 * 9;
	
	private Thread thread;
	private boolean running = false;
	public Game() {
		///Crear ventana nueva
		new Window(WIDTH,HEIGHT,"Cornville", this);
	}

	public synchronized void start() {
		this.thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		try {
			this.thread.join();
			this.running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void main(String[] args) {
		
		new Game();
		
	}
}
