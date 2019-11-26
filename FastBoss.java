/*Programa Realizado por 
 * Jorge Sanchez Diaz A01635375
 * Andres Diaz De Leon A01620020
*/
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;


public class FastBoss extends GameObject {

    private Handler handler;

    public FastBoss(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        velX = 9; 
        velY = 9;
        this.health = 3;
        
        this.color = new Color(153,232,231);
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
        g.fillRect(x, y, 32, 32);
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle(x,y,32,32);
    }



	@Override
	public void setColorHit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColorHealed() {
		// TODO Auto-generated method stub
		
	}
    
}