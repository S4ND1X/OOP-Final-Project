
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;


public class BulletBoss1 extends GameObject {

    private Handler handler;
    private Random rand = new Random();

    public BulletBoss1(int x, int y, ID id, Handler handler){
        super(x, y, id);

        this.handler = handler;

        velX = (rand.nextInt(5 - -5) + -5); 
        velY = 5;
    }

    @Override
    public void tick(){
        x += velX;
        y += velY;

        // if (y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        // if (x <= 0 || x >= Game.WIDTH - 32) velX *= -1;
        if(y >= Game.HEIGHT) handler.removeObject(this);

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 16, 16);
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle(x,y,16,16);
    }
    
}