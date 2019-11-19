import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject {

	public Player(int x, int y, ID id) {
		super(x, y, id);
		Random r = new Random();
		this.velX = r.nextInt(10);
		this.velY = r.nextInt(10);
	}

	@Override
	public void tick() {
		this.x += velX;
		this.y += velY;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}
	

	
}
