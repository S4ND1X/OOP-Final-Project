import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;


public class PlayerBullet extends GameObject {

    private Handler handler;
    private Random rand = new Random();

    public PlayerBullet(int x, int y, ID id, Handler handler){
        super(x, y, id);

        this.handler = handler;

        velX = 9; 
        velY = 0;
    }

    @Override
    public void tick(){
         x += velX;
        //y -= velY;

        //If the bullet goes outside the map it will be removed.
        if(y <= 0) handler.removeObject(this);
        collission();
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
    
    
    //TODO preguntar a salinas
    public void collission() {
    	int bulletDamage = 4;
    	for(int i = 0; i < this.handler.object.size(); i++) {
    		GameObject tempObject = this.handler.object.get(i);
    		if(tempObject.getID() == ID.BossEnemy || tempObject.getID() == ID.Boss1 || tempObject.getID() == ID.WeakBoss) {
        		if(getBounds().intersects(tempObject.getBounds())){
                    tempObject.setHealth(tempObject.getHealth() - bulletDamage);
                    handler.removeObject(this);
                }
    		}

    	}
    }
    
}