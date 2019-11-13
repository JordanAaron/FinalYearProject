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

    private TestingMap map;

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
            jumpCounter++;
            //System.out.println(jumpCounter);
            ySpeed = 9;//jump speed-+
            canJump = false;
        }
    }

    public void leftArrow(){

//        if (xSpeed > -2){
//            xSpeed = xSpeed - 0.1;
//            System.out.println(xSpeed);
//        } else {
//            xSpeed = -2;
//        }
        xSpeed = -2;

    }
    public void rightArrow(){
        System.out.println("called");
//        if (xSpeed < 2){
//            xSpeed = xSpeed + 0.1;
//            System.out.println(xSpeed);
//        }else {
//            xSpeed = 2;
//        }

        xSpeed = 2;


    }

    public void startMoving(){
        canMove = true;
    }

    public void stopMoving(){
        System.out.println("stopping");
        canMove = false;
    }



    @Override
    public void movement() {
        xPosPlayer += xSpeed;
        yPosPlayer -= ySpeed;
        collision();


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

//    private double initiateGravity(){
//        return ySpeed -= 1;
//    }

    private double initiateGravity(){
        ySpeed -= 1;
        return ySpeed;
    }

    public void collision(){
        //System.out.println((TestingMap.floor.yPosMapComp)); THIS WORKED
        if (yPosPlayer >= (TestingMap.floor.yPosMapComp - playerHeight)){
            yPosPlayer = (TestingMap.floor.yPosMapComp - playerHeight);
            canJump = true;
            jumpCounter = 0;
            ySpeed = 0;
        } else {
            initiateGravity();
        }

        //System.out.println(ySpeed);
        if(yPosPlayer <= (TestingMap.leftPlatform.yPosMapComp - playerHeight) && xPosPlayer >= (TestingMap.leftPlatform.xPosMapComp - playerWidth) && xPosPlayer <=(TestingMap.leftPlatform.xPosMapComp + TestingMap.leftPlatform.w) && ySpeed <= 0){
            if(yPosPlayer >= (TestingMap.leftPlatform.yPosMapComp - playerHeight)){
                canJump = true;
                jumpCounter = 0;
                ySpeed = 0;
                //yPosPlayer = TestingMap.leftPlatform.yPosMapComp -playerHeight;
            }
        }

        if(yPosPlayer <= (TestingMap.rightPlatform.yPosMapComp - playerHeight) && xPosPlayer >= (TestingMap.rightPlatform.xPosMapComp - playerWidth) && xPosPlayer <=(TestingMap.rightPlatform.xPosMapComp + TestingMap.rightPlatform.w) && ySpeed <=0){
            System.out.println("in position");
            if(yPosPlayer >= (TestingMap.leftPlatform.yPosMapComp - playerHeight)){
                //System.out.println("collide");
                //yPosPlayer = (TestingMap.leftPlatform.yPosMapComp - playerHeight);
                canJump = true;
                jumpCounter = 0;
                ySpeed = 0;
            }
        }

//        if (TestingMap.colliding(this.xPosPlayer,this.yPosPlayer,this.map) && ySpeed > 0) {
//            ySpeed = 0;
//            canJump = true;
//            jumpCounter = 0;
//        }

    }

    private void outOfBounds(){
        if(yPosPlayer < 0){
            yPosPlayer = 0;
        }
        if (yPosPlayer > this.getScreenHeight){
            yPosPlayer = this.getScreenHeight - playerHeight;
        }

    }









}
