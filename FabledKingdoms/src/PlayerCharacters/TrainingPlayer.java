package PlayerCharacters;

import Maps.MapFrame;
import Maps.Pillars;
import Maps.TestingMap;

import java.awt.*;

public class TrainingPlayer extends Player {
    private int playerWidth, playerHeight;
    private int jumpCounter;
    public double playerSpeed,xSpeed, ySpeed;
    //private double ySpeed;


    private boolean canMove;

    private boolean lookingLeft, lookingRight;

    private int health;
    private int maxHealth;
    private boolean dead;
    private boolean flinching;
    private long flinchTime;

    private boolean lightAttacking;
    private boolean heavyAttacking;


    private Color color;


    public int xPos, yPos, w, h;
    private MapFrame mapFrame;

    public TrainingPlayer(int x, int y, Color c, MapFrame frame) {
        super(x, y);
        this.color = c;
        this.mapFrame = frame;

        playerWidth = 4;
        playerHeight = 7;

        jumpCounter = 0;
        playerSpeed = 0.5;
        xSpeed = 0;
        ySpeed = 0;

        maxHealth = 100;

        dead = false;

        canMove = true;

        lightAttacking = false;
        heavyAttacking = false;
    }

    @Override
    public void draw(Graphics g) {
        xPos = (int)(((double)this.xPosPlayer/100) * this.getScreenWidth);
        yPos = (int)(((double)this.yPosPlayer/100) * this.getScreenHeight);
        w = (int)(((double) playerWidth /100) * this.getScreenWidth);
        h = (int)(((double) playerHeight /100) * this.getScreenHeight);

        g.setColor(color);
        g.drawRect(xPos,yPos,w,h);
    }

    @Override
    public void updateWidth(int w) {
        this.getScreenWidth = w;
    }

    @Override
    public void updateHeight(int h) {
        this.getScreenHeight = h;
    }

    @Override
    public void movement() {
        xPosPlayer += xSpeed;
        yPosPlayer -= ySpeed;
        collisionDetection();
        outOfBounds();
        initiateGravity();

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

    public void up(){
        mapFrame.trainingPlayer = mapFrame.trainingPlayerSS.getImage(3,1,32,32);
        if(jumpCounter < 2){
            ySpeed = 6;
            jumpCounter++;
        }
    }

    public void left(){
        mapFrame.trainingPlayer = mapFrame.trainingPlayerSS.getImage(1,3,32,32);
        xSpeed = -1;
    }

    public void right(){
        mapFrame.trainingPlayer = mapFrame.trainingPlayerSS.getImage(1,2,32,32);
        xSpeed = 1;
    }

    public void lightAttack(){
        mapFrame.trainingPlayer = mapFrame.trainingPlayerSS.getImage(2,4,32,32);
        lightAttacking = true;
    }

    public void stopLightAttack(){
        //where you implement the hit delay
        mapFrame.trainingPlayer = mapFrame.trainingPlayerSS.getImage(5,1,32,32);
        lightAttacking = false;
    }

    public void heavyAttack(){
        heavyAttacking = true;
    }

    public void stopHeavyAttack(){
        //where you implement the hit delay
        heavyAttacking = false;
    }

    @Override
    public void collisionDetection() {
        int xCheck = (int)(xPosPlayer + (0.5 * playerWidth));
        int yCheck = yPosPlayer + playerHeight;



            //Floor
            if (Pillars.floor.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())) {
                yPosPlayer = (Pillars.floor.yPosMapComp - playerHeight);
                jumpCounter = 0;
                ySpeed = 0;
            }

            //Left Pillar
            if (Pillars.leftPillarTop.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){

                yPosPlayer = (Pillars.leftPillarTop.yPosMapComp - playerHeight);
                jumpCounter = 0;
                ySpeed = 0;
            }else if (Pillars.leftPillarRight.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
                xPosPlayer = (Pillars.leftPillarRight.xPosMapComp);
            }

            //Right Pillar
            if (Pillars.rightPillarTop.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())) {
                yPosPlayer = (Pillars.rightPillarTop.yPosMapComp - playerHeight);
                jumpCounter = 0;
                ySpeed = 0;
            } else if (Pillars.rightPillarLeft.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
                xPosPlayer = (Pillars.rightPillarLeft.xPosMapComp - playerWidth);
            }

            //Left Middle Pillar
            if (Pillars.middleLeftPillarTop.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
                yPosPlayer = (Pillars.middleLeftPillarTop.yPosMapComp - playerHeight);
                jumpCounter = 0;
                ySpeed = 0;
            }
            if (Pillars.middleLeftPillarLeft.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
                xPosPlayer = (Pillars.middleLeftPillarLeft.xPosMapComp - playerWidth);
            }
            if (Pillars.middleLeftPillarRight.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
                xPosPlayer = (Pillars.middleLeftPillarRight.xPosMapComp);
            }

            //Right Middle Pillar
            if (Pillars.middleRightPillarTop.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
                yPosPlayer = (Pillars.middleRightPillarTop.yPosMapComp - playerHeight);
                jumpCounter = 0;
                ySpeed = 0;
            }
            if (Pillars.middleRightPillarLeft.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
                xPosPlayer = (Pillars.middleRightPillarLeft.xPosMapComp - playerWidth);
            }
            if (Pillars.middleRightPillarRight.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
                xPosPlayer = (Pillars.middleRightPillarRight.xPosMapComp);
            }

//        if (Pillars.rightPillar.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
//            //System.out.println("collision");
//
//
//            //System.out.println("x: "+ overlap(getRightX(), Pillars.rightPillar.xPosMapComp));
//            //System.out.println("y: "+ overlap(getBottomY(), Pillars.rightPillar.yPosMapComp));
//
//
////            if (getTopY() > (Pillars.rightPillar.yPosMapComp + (playerHeight / 2)) || getLeftX() > (Pillars.rightPillar.xPosMapComp + (playerWidth / 2)) && getRightX() > (Pillars.rightPillar.xPosMapComp + (playerWidth / 2))) {
////                //System.out.println("not on corner");
////                if (Math.abs(getRightX() - Pillars.rightPillar.xPosMapComp) > Math.abs(getBottomY() - Pillars.rightPillar.yPosMapComp)) {
////                    yPosPlayer = (Pillars.rightPillar.yPosMapComp - playerHeight);
////                    ySpeed = 0;
////                    jumpCounter = 0;
////                } else {
////                    xPosPlayer = (Pillars.rightPillar.xPosMapComp - playerWidth);
////                }
////            } else {
////                //System.out.println("corner");
////                if (Math.abs(getRightX() - Pillars.rightPillar.xPosMapComp) > Math.abs(getBottomY() - Pillars.rightPillar.yPosMapComp)) {
////                    xPosPlayer = (Pillars.rightPillar.xPosMapComp - playerWidth);
////                } else {
////                    yPosPlayer = (Pillars.rightPillar.yPosMapComp - playerHeight);
////                    jumpCounter = 0;
////                }
////            }
////
////
//      }
            //if you're on the right side of the platform then compare the left side of the player, otherwise compare the right side of the player

    }

    @Override
    public boolean playerColliding(int xPlayer, int yPlayer) {
        if (xPlayer >= this.xPosPlayer && xPlayer <= (this.xPosPlayer + this.playerWidth)){
            return true;
        }
        return false;
    }


    private void outOfBounds(){
        if(xPosPlayer < 0){
            xPosPlayer = 0;
        }
        if (getRightX() > 100){
            xPosPlayer = 100 - playerWidth;
            //xSpeed = 0;
        }
    }
    public int getLeftX(){
        return xPosPlayer;
    }

    public int getRightX(){
        return xPosPlayer + playerWidth;
    }

    public int getTopY(){
        return yPosPlayer;
    }

    public int getBottomY(){
        return yPosPlayer + playerHeight;
    }

    private void initiateGravity(){
        ySpeed -=1;
    }

    public void startMoving(){
        canMove = true;
    }

    public void stopMoving(){
        mapFrame.trainingPlayer = mapFrame.trainingPlayerSS.getImage(5,1,32,32);
        canMove = false;
    }
}
