package PlayerCharacters;

import java.awt.*;

public class GenericPlayer extends Player {
    private int width, height;
    private float xSpeed, ySpeed;
    Color color;

    public GenericPlayer(int x, int y, Color c){
        super(x,y);
        this.color = c;
        width = 4;
        height = 7;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);

        int xPos = (int)(((double)this.xPosPlayer/100) * this.getScreenWidth);
        int yPos = (int)(((double)this.yPosPlayer/100) * this.getScreenHeight);
        int w = (int)(((double) width/100) * this.getScreenWidth);
        int h = (int)(((double) height/100) * this.getScreenHeight);

        g.fillRect(xPos,yPos,w,h);
    }

    @Override
    public void movement() {

    }

    public void updateWidth(int w){this.getScreenWidth = w;}

    public void updateHeight(int h){this.getScreenHeight = h;}

    public int getPlayerHeight(){
        return height;
    }
}
