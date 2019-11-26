/*Programa Realizado por 
 * Jorge Sanchez Diaz A01635375
 * Andres Diaz De Leon A01620020
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Dummy extends GameObject {

    Handler handler;

    public Dummy(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler; 
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle(x,y,10,10);
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(x,y,10,10);
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