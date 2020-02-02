package MapComponents;

import java.awt.*;

public abstract class Component {
    public int xPosMapComp, yPosMapComp, x2PosMapComp, y2PosMapComp, x3PosMapComp, y3PosMapComp, w, h, screenWidth, screenHeight;
    Color c;

    public Component(int x, int y, int width, int height, Color color){
        this.xPosMapComp = x;
        this.yPosMapComp = y;
        this.w = width;
        this.h = height;
        this.c = color;
    }

    //Overloading constructors to support different map components

//    //AngledPlatform(DrawLine)
//    public Component(int x, int y, int x2, int y2, Color color){
//        this.xPosMapComp = x;
//        this.yPosMapComp = y;
//        this.x2PosMapComp = x2;
//        this.y2PosMapComp = y2;
//    }

    //Stairs(Polygon)
    public Component(int x, int y, int x2, int y2, int x3, int y3, Color color){
        this.xPosMapComp = x;
        this.yPosMapComp = y;
        this.x2PosMapComp = x2;
        this.y2PosMapComp = y2;
        this.x3PosMapComp = x3;
        this.y3PosMapComp = y3;
        this.c = color;
    }


    public abstract void draw(Graphics g);

    public abstract void updateWidth(int w);

    public abstract void updateHeight(int h);

    public abstract boolean MapColliding(int x, int y);

}
