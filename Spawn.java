import java.util.Random;

public class Spawn {

    private Handler handler; 
    private HUD hud;

    private Random rand = new Random();

    private int scoreKeep = 1;
    private int timer = 1000;

    public Spawn(Handler handler, HUD hud){
        this.handler =handler;
        this.hud = hud;
    }

    public void tick(){
        timer--;
        if (handler.object.size() == 1) {
            hud.setLevel(hud.getLevel() + 1);
            scoreKeep++;
            //TODO remplazar el dummy con algo menos laborioso y mas logico
            handler.addObject(new Dummy(1000,1000,ID.Dummy, handler));
        }

        if (scoreKeep == 1 ) {
            scoreKeep--;
            if (hud.getLevel() == 1) {
                handler.addObject(new WeakBoss((Game.WIDTH / 2), 50, ID.WeakBoss, handler));
            }
            if (hud.getLevel() == 2) {
                for (int i = 0; i < 600; i++){
                    if (i % 100 == 0){
                        handler.addObject(new BasicEnemy(rand.nextInt(Game.WIDTH - 50), rand.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                        handler.clearEnemies();
                    }
                }
            }
            if (hud.getLevel() == 3) {
                // handler.addObject(new FastEnemy(rand.nextInt(Game.WIDTH - 50), rand.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                //Oleada de enemigos basicos con enemigos basicos
            	handler.addObject(new BossEnemy(Game.WIDTH + 100, Game.HEIGHT / 2, ID.BossEnemy, handler));
            }
            if (hud.getLevel() == 4) {
                // handler.addObject(new FatEnemy(rand.nextInt(Game.WIDTH - 50), rand.nextInt(Game.HEIGHT - 50), ID.FatEnemy, handler));
                handler.addObject(new Boss1(Game.WIDTH / 2, -50, ID.Boss1, handler));
            }
            if (hud.getLevel() == 5){
                //Crear una oleada de fat, fast y basic enemies 
            }
            if (hud.getLevel() == 6){
                //Enemigos rápido con smartenemies 
            }
        }

        if (timer <= 0) {
            handler.addObject(new  HealthToken(rand.nextInt(Game.WIDTH - 50), 25, ID.HealthToken, handler));
            timer = 100; 
            int randNum = rand.nextInt((7-3)+1)+ 3;
            timer *= randNum;
        }
        else timer--;


    }

}