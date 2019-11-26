/*Programa Realizado por 
 * Jorge Sanchez Diaz A01635375
 * Andres Diaz De Leon A01620020
*/
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;


public class Boss1 extends GameObject {

    private Handler handler;
    private Random rand = new Random();
    private int timer = 80;
    private int timer2 = 50;

    public Boss1(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        this.health = 100;
        velX = 0; 
        velY = 2;
        
        this.color = new Color(130,232,211,91);
    }

    @Override
    public void tick(){
        x += velX;
        y += velY;

        timer--;
        if (timer <= 0) velY = 0;
        else timer--;

        if(timer <= 0) timer2--; 
        if (timer2 <= 0) {
            if (velX == 0) velX = 2;
            int spawn = rand.nextInt(10);
            if(spawn == 0) handler.addObject(new BulletBoss1((int)x + 48, (int)y + 48, ID.BasicEnemy, handler));
        }

        // if (y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 128) velX *= -1;

        //Damaging the boss
        if (health <= 0) {
            handler.clearEnemies();
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, 128, 128);
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle(x,y,128,128);
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