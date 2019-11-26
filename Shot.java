import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;


public class Shot extends GameObject {

    private Handler handler;
    private Random rand = new Random();

    public Shot(int x, int y, ID id, Handler handler){
        super(x, y, id);

        this.handler = handler;

        velX = 0; 
        velY = 9;
    }

    @Override
    public void tick(){
        // x += velX;
        y -= velY;

        //If the bullet goes outside the map it will be removed.
        if(y <= 0) handler.removeObject(this);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(x, y, 10, 10);
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle(x,y,10,10);
    }
    
}