/*Programa Realizado por 
 * Jorge Sanchez Diaz A01635375
 * Andres Diaz De Leon A01620020
*/
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    public static final int WIDTH = 1080, HEIGHT = WIDTH / 12 * 9;

    private Thread thread;
    private boolean running = false;

    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private Menu menu;
    private static Music music;

    private Random rand = new Random();
    
    
    //Estados de la aplicacion
	public enum STATE{
		Menu,
		Credits,
		End,
		Game
	};
    
    public STATE gameState = STATE.Menu;
    

    public Game() {
        handler = new Handler();
        hud = new HUD();        
        menu = new Menu(this, handler, hud);
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
        
      
        spawner = new Spawn(handler, hud);

        this.addKeyListener((KeyListener) new KeyInput(handler));
        new Window(WIDTH, HEIGHT, "CrackHead", this);
        if(gameState == STATE.Game) {
	        //*Players and First Enemies 
	        handler.addObject(new Player(WIDTH / 2, HEIGHT / 2, ID.Player, handler));
	        handler.addObject(new Dummy(2000,2000,ID.Dummy, handler));
        }

    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    // Game loop. It renders everything and makes possible the canges inthe whole
    // canvas
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        final double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            final long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                // System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
    	//Administrador de objetos
		handler.tick();
		
		//Si esta en estado de juego se actualizan los componentes del juego
		if(gameState == STATE.Game) {
			//Actualizar los enemigos			
			spawner.tick();
			//Actualizar el hud
			hud.tick();
			if(HUD.HEALTH <= 0) {
				HUD.HEALTH = 100;
				
				gameState = STATE.End;
				handler.clearEnemies();
			}
		}else if(gameState == STATE.Menu) {
			menu.tick();
			
		}
    			
    }

    private void render() {
    	BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		//Poder dibujar
		Graphics g = bs.getDrawGraphics();
		
		//Dibujar el tablero encima del Jframe	 
		g.setColor(new Color(49, 64, 87));
		g.fillRect(0, 0, WIDTH, HEIGHT );
		
		//Renderizar los objetos
		handler.render(g);
		//Si esta en estado de juego se crea un juego si no es el menu
		if(gameState == STATE.Game) {
			//Renderizar el HUD 
			hud.render(g);
		}else if(gameState == STATE.Menu || gameState == STATE.Credits || gameState == STATE.End) {
			menu.render(g);
		}
		
		
		g.dispose();
		bs.show();
    }

    public static int clamp(int var, int min, int max) {
        if (var >= max)
            return var = max;
        else if(var <= min)
            return var = min;
        else
            return var;
    }

    public static void main(final String[] args) {
        new Game();
        String filePath = "./hitch.wav";
        music = new Music();
        music.playMusic(filePath);
    }
}