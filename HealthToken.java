
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;


public class HealthToken extends GameObject {

    private Handler handler;
    private Random rand = new Random();

    private int timer = 50;

    public HealthToken(int x, int y, ID id, Handler handler){
        super(x, y, id);

        this.handler = handler;

        velX = 0; 
        velY = 3;
        
        this.color = new Color(235,78,153);
    }

    @Override
    public void tick(){

        x += velX;
        y += velY;

        if(y >= Game.HEIGHT) handler.removeObject(this);
        
        
        
        

    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.drawArc(x, y, 10, 20, 0, 180);
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle(x,y,10,20);
    }

	@Override
	public void setColorHit() {

		
	}

	@Override
	public void setColorHealed() {

		
	}
    
}