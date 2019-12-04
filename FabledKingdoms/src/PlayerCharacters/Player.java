package PlayerCharacters;

import java.awt.*;

public abstract class Player {
    int xPosPlayer, yPosPlayer, getScreenWidth, getScreenHeight;

    Player(int x, int y){
        this.xPosPlayer = x;
        this.yPosPlayer = y;

    }

    public abstract void draw(Graphics g);

    public abstract void updateWidth(int w);

    public abstract void updateHeight(int h);

    public abstract void movement();

    public abstract  void collisionDetection();

    public abstract boolean playerColliding(int x, int y);


}
