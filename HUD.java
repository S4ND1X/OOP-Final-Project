
import java.awt.Color;
import java.awt.Graphics;

import javafx.css.ParsedValue;

public class HUD {

    public static int HEALTH = 100;
    private int greenValue = 255;

    private int level = 0;

    public void tick(){
        HEALTH = Game.clamp(HEALTH,0,100);
        greenValue  = Game.clamp(greenValue,0,255);

        greenValue =HEALTH*2;
    }

    public void render(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 32);
        g.setColor(new Color(150,greenValue,0));
        g.fillRect(15, 15, HEALTH * 2, 32);
        g.setColor(Color.WHITE);
        g.drawRect(15, 15, 200, 32);
        g.drawString("Level: " + level, 15, 80);
    }


    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }
}