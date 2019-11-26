
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;


public class FastEnemy extends GameObject {

    private Handler handler;

    public FastEnemy(int x, int y, ID id, Handler handler){
        super(x, y, id);

        this.handler = handler;

        velX = 2; 
        velY = 9;
        
        this.color = new Color(255,233,181);
    }

    @Override
    public void tick(){
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 32) velX *= -1;

    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, 16, 16);
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle(x,y,16,16);
    }

	@Override
	public void setColorHit() {
		int r = this.color.getRed(),g = this.getColor().getGreen(), b = this.getColor().getBlue();
		r*=0.95;
		g*=0.95;
		b*=0.95;
		this.color = new Color(r,g,b);
		
	}

	@Override
	public void setColorHealed() {
		// TODO Auto-generated method stub
		
	}
    
}