
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class WeakBoss extends GameObject {

    Handler handler;

    public WeakBoss(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler; 
        this.health = 1;
        this.color = new Color(130,232,211,91);
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle(x,y,96,96);
    }

    @Override
    public void tick() {
        if (health <= 0) {
            handler.clearEnemies();
        }
    }


    @Override
    public void render(Graphics g){
        g.setColor(color);
        g.fillRect(x,y,96,96);
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