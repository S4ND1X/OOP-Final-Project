import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {

	public Player(int x, int y, ID id) {
		super(x, y, id);
	}

	@Override
	public void tick() {
		this.x += velX;
		this.y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 36);
		y = Game.clamp(y, 0, Game.HEIGHT - 64);
		
	}
	

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}
	

	
}
