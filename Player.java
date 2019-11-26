
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



public class Player extends GameObject {

    Handler handler;
    private int wait = 0;

    public Player(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler; 
        
        this.color = new Color(143,130,232);
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle(x,y,32,32);
    }
    

    @Override
    public void tick() {
        x += velX;
        y += velY;
        
        x = Game.clamp(x, 0, Game.WIDTH - 37);
        y = Game.clamp(y, 0, Game.HEIGHT - 55);

        collission();

        if (wait > 0) {
            wait--;
        }
        if (shoot == 1 && wait == 0) {
            handler.addObject(new PlayerBullet((int)x + 8, (int)y + 8, ID.PlayerBullet, handler));
            wait += 15;
        }
    }


    private void collission(){
        for (int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);

            if (tempObject.getID() == ID.BasicEnemy 
                || tempObject.getID() == ID.FastEnemy 
                || tempObject.getID() == ID.SmartEnemy) { 
                    if(getBounds().intersects(tempObject.getBounds())){
                        HUD.HEALTH -= 4;
                        handler.removeObject(tempObject);
                    }
            }
            if (tempObject.getID() == ID.FatEnemy) {
                if(getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 8;
                    handler.removeObject(tempObject);
                }
            }
            if (tempObject.getID() == ID.Boss1 || tempObject.getID() == ID.WeakBoss) {
                if(getBounds().intersects(tempObject.getBounds())) 
                    HUD.HEALTH -= 100;
            }
            if (tempObject.getID() == ID.HealthToken) {
                if(getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH += 5;
                    handler.removeObject(tempObject);
                    this.setColorHealed();
                }
            }
            if (tempObject.getID() == ID.BossEnemyBullets) {
                if(getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 5;
                    handler.removeObject(tempObject);
                    this.setColorHit();
                }
            }
        }
    }

    @Override
    public void render(Graphics g){
    	int[] xP = {x,x+32,x};
    	int[] yP = {y,y+16,y+32};
        g.setColor(color);
        //g.drawRect(x,y,32,32);
        
        g.fillPolygon(xP,yP, 3);
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
		if(this.health < 100) {
			int r = this.color.getRed(),g = this.getColor().getGreen(), b = this.getColor().getBlue();
			r=(int) (r*1.05>255 ? 255: r*1.05);
			g=(int) (g*1.05>255 ? 255: g*1.05);
			b=(int) (b*1.05>255 ? 255: b*1.05);
			System.out.println(r + " " + g + " " + b);
			this.color = new Color(r,g,b);
		}
		
		
	}
    
}