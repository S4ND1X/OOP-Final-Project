
import java.util.Random;

public class Spawn {

    private Handler handler; 
    private HUD hud;

    private Random rand = new Random();

    private int scoreKeep = 0;
    private int timer = 500;

    public Spawn(Handler handler, HUD hud){
        this.handler =handler;
        this.hud = hud;
    }

    public void tick(){
        scoreKeep++;
        timer--;

        scoreKeep = 0;
        if (handler.object.size() == 1) {
            hud.setLevel(hud.getLevel()+1);
        }
        

        // if (hud.getLevel() % 2 == 0)
        //     handler.addObject(new BasicEnemy(rand.nextInt(Game.WIDTH - 50), rand.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
        // if (hud.getLevel() % 2 == 1)
        //     handler.addObject(new FastEnemy(rand.nextInt(Game.WIDTH - 50), rand.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
        // if (hud.getLevel() % 3 == 0)
        //     handler.addObject(new FatEnemy(rand.nextInt(Game.WIDTH - 50), rand.nextInt(Game.HEIGHT - 50), ID.FatEnemy, handler));
        // if (hud.getLevel() % 4 == 0)
        //     handler.addObject(new SmartEnemy(rand.nextInt(Game.WIDTH - 50), rand.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
        // if (hud.getLevel() == 5){
        //     handler.clearEnemies();
        //     handler.addObject(new Boss1(rand.nextInt((Game.WIDTH / 2 ) - 50), -120, ID.Boss1, handler));
        // }
        

        if (timer <= 0) {
            handler.addObject(new  HealthToken(rand.nextInt(Game.WIDTH - 50), 25, ID.HealthToken, handler));
            timer = 100; 
            int randNum = rand.nextInt((7-3)+1)+ 3;
            timer *= randNum;
        }
        else timer--;


    }

}