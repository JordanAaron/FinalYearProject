package PlayerCharacters;

import Maps.MapFrame;
import Maps.TestingMap;

import java.awt.*;

public class GenericPlayer extends Player {
    private int playerWidth, playerHeight;
    private double xSpeed, ySpeed;
    private boolean canJump, canMove;

    private int xPos;
    private int yPos;

    private int jumpCounter;

    Color color;

    public GenericPlayer(int x, int y, Color c){
        super(x,y);
        this.color = c;

        playerWidth = 4;
        playerHeight = 7;

        xSpeed = 0;
        ySpeed = 0;

        canMove = true;

        canJump = true;
        jumpCounter = 0;

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);

        xPos = (int)(((double)this.xPosPlayer/100) * this.getScreenWidth);
        yPos = (int)(((double)this.yPosPlayer/100) * this.getScreenHeight);
        int w = (int)(((double) playerWidth /100) * this.getScreenWidth);
        int h = (int)(((double) playerHeight /100) * this.getScreenHeight);

        g.fillRect(xPos,yPos,w,h);
    }

    public void updateWidth(int w){this.getScreenWidth = w;}

    public void updateHeight(int h){this.getScreenHeight = h;}

    public void upArrow(){
        if(jumpCounter < 2){
            ySpeed = 9;
            jumpCounter++;
            canJump = false;
        }
        System.out.println(jumpCounter);
    }

    public void leftArrow(){
        xSpeed = -2;
    }

    public void rightArrow(){
        xSpeed = 2;
    }

    public void startMoving(){
        canMove = true;
    }

    public void stopMoving(){
        canMove = false;
    }

    @Override
    public void movement() {
        xPosPlayer += xSpeed;
        yPosPlayer -= ySpeed;
        collision();
        outOfBounds();

        //System.out.println(ySpeed);

        if(!canMove){
            if (xSpeed < 0){
                xSpeed += 0.5;
                if (xSpeed > 0){
                    xSpeed = 0;
                }
            } else if (xSpeed > 0) {
                xSpeed -= 0.5;
                if( xSpeed < 0){
                    xSpeed = 0;
                }
            }
        }
    }

    public void collision(){
        if (yPosPlayer >= (TestingMap.floor.yPosMapComp - playerHeight)){
            yPosPlayer = (TestingMap.floor.yPosMapComp - playerHeight);
            canJump = true;
            jumpCounter = 0;
            ySpeed = 0;
        } else {
            initiateGravity();
        }


        if (TestingMap.leftPlatform.colliding((int) (xPosPlayer + (0.5 * playerWidth)),yPosPlayer + playerHeight)){
            //yPosPlayer = (TestingMap.floor.yPosMapComp - playerHeight);
            canJump = true;
            jumpCounter = 0;
            ySpeed = 0;
            System.out.println("collide");
        }

//        if(/*yPosPlayer <= (TestingMap.leftPlatform.yPosMapComp - playerHeight) &&*/ xPosPlayer >= (TestingMap.leftPlatform.xPosMapComp - playerWidth) && xPosPlayer <=(TestingMap.leftPlatform.xPosMapComp + TestingMap.leftPlatform.w) && ySpeed <= 0){
//            if(yPosPlayer >= (TestingMap.leftPlatform.yPosMapComp - playerHeight)) {
//                yPosPlayer = (TestingMap.leftPlatform.yPosMapComp - playerHeight);
//                canJump = true;
//                jumpCounter = 0;
//                ySpeed = 0;
//            }
//        }
//
//        if(yPosPlayer <= (TestingMap.rightPlatform.yPosMapComp - playerHeight) && xPosPlayer >= (TestingMap.rightPlatform.xPosMapComp - playerWidth) && xPosPlayer <=(TestingMap.rightPlatform.xPosMapComp + TestingMap.rightPlatform.w) && ySpeed <=0){
//            if(yPosPlayer >= (TestingMap.leftPlatform.yPosMapComp - playerHeight)){
//                canJump = true;
//                jumpCounter = 0;
//                ySpeed = 0;
//            }
//        }


    }

    private double initiateGravity(){
        ySpeed -= 1;
        return ySpeed;
    }

    private void outOfBounds(){
        if(xPosPlayer < 0){
            xPosPlayer = 0;
        }
        if ((xPosPlayer + playerWidth) > 100){
            xPosPlayer = 100 - playerWidth;
        }

    }
}
