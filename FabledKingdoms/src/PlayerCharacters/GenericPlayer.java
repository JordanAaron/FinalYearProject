package PlayerCharacters;

import Maps.Blockage;
import Maps.Pillars;
import Maps.TestingMap;
import java.awt.*;

public class GenericPlayer extends Player {
    private int playerWidth, playerHeight;
    private int jumpCounter;
    public double playerSpeed,xSpeed, ySpeed;
    private boolean canMove;

    private boolean lookingLeft, lookingRight;

    private int health;
    private int maxHealth;
    private boolean dead;
    private boolean flinching;
    private long flinchTime;

    private int lightAttack;
    private int heavyAttack;
    private int hitDelay;
    private boolean lightAttacking;
    private boolean heavyAttacking;

    public int xPos, yPos, w, h;

    //delete later
    private Color color;

    private String mapSelection;

    public GenericPlayer(int x, int y, Color c, String map){
        super(x,y);
        this.color = c;
        this.mapSelection = map;
        //System.out.println(mapSelection);

        playerWidth = 4;
        playerHeight = 7;

        jumpCounter = 0;
        playerSpeed = 0.5;
        xSpeed = 0;
        ySpeed = 0;

        canMove = true;

        maxHealth = 100;
        health = 100;

        dead = false;

        lightAttack = 4;
        heavyAttack = 7;
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

    public void updateWidth(int w){this.getScreenWidth = w;}

    public void updateHeight(int h){this.getScreenHeight = h;}

    @Override
    public void movement() {
        xPosPlayer += xSpeed;
        yPosPlayer -= ySpeed;
        collisionDetection();
        outOfBounds();

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

    public void onlineMovement(int x, int y){
        //System.out.println(xPos + "," + yPos);
        xPosPlayer = x;
        yPosPlayer = y;
        //System.out.println(xPos + yPos);
    }

    public void collisionDetection(){
        if (mapSelection.equals("TestingMap")){
            testingMapCollisions();
        } else if (mapSelection.equals("Blockage")){
            blockageCollisions();
        } else if (mapSelection.equals("Pillars")){
            pillarsCollisions();
        }
    }

    public void testingMapCollisions(){
//        int xCheck = (int)(xPosPlayer + (0.5 * playerWidth));
//        int yCheck = yPosPlayer + playerHeight;
//
//        if (TestingMap.floor.MapColliding(xCheck, yCheck)) {
//            yPosPlayer = (TestingMap.floor.yPosMapComp - playerHeight);
//            jumpCounter = 0;
//            ySpeed = 0;
//        } else if (TestingMap.leftPlatform.MapColliding(xCheck, yCheck) && ySpeed < 0){
//            yPosPlayer = (TestingMap.leftPlatform.yPosMapComp - playerHeight);
//            jumpCounter = 0;
//            ySpeed = 0;
//        } else if (TestingMap.rightPlatform.MapColliding(xCheck, yCheck) && ySpeed < 0){
//            yPosPlayer = (TestingMap.rightPlatform.yPosMapComp - playerHeight);
//            jumpCounter = 0;
//            ySpeed = 0;
//        } else {
//            initiateGravity();
//        }
//
//        if (TestingMap.trainingPlayer.playerColliding(xCheck,yCheck) && lightAttacking){
//            System.out.println("light attack collision");
//            damageImpact(lightAttack);
//        } else if (TestingMap.trainingPlayer.playerColliding(xCheck,yCheck) && heavyAttacking){
//            System.out.println("heavy attack collision");
//            damageImpact(heavyAttack);
//        }
//
//        if (TestingMap.p2.playerColliding(xCheck,yCheck) && lightAttacking){
//            System.out.println("light attack collision");
//            damageImpact(lightAttack);
//        } else if (TestingMap.p2.playerColliding(xCheck,yCheck) && heavyAttacking){
//            System.out.println("heavy attack collision");
//            damageImpact(heavyAttack);
//        }
    }

    public void blockageCollisions(){
        int xCheck = (int)(xPosPlayer + (0.5 * playerWidth));
        int yCheck = yPosPlayer + playerHeight;

//        if (Blockage.floor.MapColliding(xCheck, yCheck)) {
//            yPosPlayer = (Blockage.floor.yPosMapComp - playerHeight);
//            jumpCounter = 0;
//            ySpeed = 0;
//        } else if (Blockage.leftPlatform.MapColliding(xCheck, yCheck) && ySpeed < 0){
//            yPosPlayer = (Blockage.leftPlatform.yPosMapComp - playerHeight);
//            jumpCounter = 0;
//            ySpeed = 0;
//        } else if (Blockage.rightPlatform.MapColliding(xCheck, yCheck) && ySpeed < 0) {
//            yPosPlayer = (Blockage.rightPlatform.yPosMapComp - playerHeight);
//            jumpCounter = 0;
//            ySpeed = 0;
//        } else if (Blockage.topPlatform.MapColliding(xCheck, yCheck) && ySpeed < 0){
//            yPosPlayer = (Blockage.topPlatform.yPosMapComp - playerHeight);
//            jumpCounter = 0;
//            ySpeed = 0;
//        } else if (Blockage.block.MapColliding(xCheck,yCheck) && ySpeed <= 0) {
//            yPosPlayer = (Blockage.block.yPosMapComp - playerHeight);
//            jumpCounter = 0;
//            ySpeed = 0;
//        } else {
//            initiateGravity();
//        }
    }

    public void pillarsCollisions(){
        int xCheck = (int)(xPosPlayer + (0.5 * playerWidth));
        int yCheck = yPosPlayer + playerHeight;

        if (Pillars.floor.MapColliding(getLeftX(),getRightX(),getTopY(),getBottomY())) {

            yPosPlayer = (Pillars.floor.yPosMapComp - playerHeight);
            jumpCounter = 0;
            ySpeed = 0;
        } else if (Pillars.rightPillar.MapColliding(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            //System.out.println("collision");


            System.out.println("x: "+ overlap(getRightX(), Pillars.rightPillar.xPosMapComp));
            System.out.println("y: "+ overlap(getBottomY(), Pillars.rightPillar.yPosMapComp));

            if (getTopY() > (Pillars.rightPillar.yPosMapComp + playerHeight) || getLeftX() > (Pillars.rightPillar.xPosMapComp + playerWidth)){
                if (Math.abs(getRightX()-Pillars.rightPillar.xPosMapComp) > Math.abs(getBottomY()-Pillars.rightPillar.yPosMapComp)){
                    yPosPlayer = (Pillars.rightPillar.yPosMapComp - playerHeight);
                    jumpCounter = 0;
                } else {
                    xPosPlayer = (Pillars.rightPillar.xPosMapComp - playerWidth);
                }
            } else {
                if (Math.abs(getRightX()-Pillars.rightPillar.xPosMapComp) > Math.abs(getBottomY()-Pillars.rightPillar.yPosMapComp)){
                    xPosPlayer = (Pillars.rightPillar.xPosMapComp - playerWidth);
                } else {
                    yPosPlayer = (Pillars.rightPillar.yPosMapComp - playerHeight);
                    jumpCounter = 0;
                }
            }




//            yPosPlayer = (Pillars.rightPillar.yPosMapComp - playerHeight);
//            jumpCounter = 0;
//            ySpeed = 0;

//            if (xSpeed < 0){
//                xPosPlayer = (Pillars.rightPillar.xPosMapComp - playerWidth);
//            }

//            if (getBottomY() > Pillars.rightPillar.yPosMapComp){
//
//            }
//            if (getRightX() > Pillars.rightPillar.xPosMapComp && getBottomY() > Pillars.rightPillar.yPosMapComp){
//                xPosPlayer = (Pillars.rightPillar.xPosMapComp - playerWidth);
//                xSpeed = 0;
//            }


            //System.out.println("collision");


//        } else if (Pillars.rightPillar.collideWithTop(xCheck,yCheck) && ySpeed < 0){
//            yPosPlayer = (Pillars.rightPillar.yPosMapComp - playerHeight);
//            jumpCounter = 0;
//            ySpeed = 0;

//        } else if ((xPosPlayer + playerWidth) > Pillars.rightPillar.xPosMapComp){
//            xPosPlayer = Pillars.rightPillar.xPosMapComp - playerWidth;
        } else {
            initiateGravity();
        }

        //if you're on the right side of the platform then compare the left side of the player, otherwise compare the right side of the player
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

    private int overlap(int playerPosition, int objectPosition){
        return Math.abs(playerPosition - objectPosition);
    }

    public boolean playerColliding(int xPlayer, int yPlayer){
        //check the bound of the direction the player is looking in
        if (xPlayer >= this.xPosPlayer && xPlayer <= (this.xPosPlayer + this.playerWidth)){
            return true;
        }
        return false;
    }

    public void up(){
        if(jumpCounter < 2){
            ySpeed = 9;
            jumpCounter++;
        }
    }

    public void left(){
        xSpeed = -2;
    }

    public void right(){
        xSpeed = 2;
    }

    public void startMoving(){
        canMove = true;
    }

    public void stopMoving(){
        canMove = false;
    }

    public void initiateGravity(){
        ySpeed -= 2;
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

    public void lightAttack(){
        lightAttacking = true;
    }

    public void stopLightAttack(){
        //where you implement the hit delay
        lightAttacking = false;
    }

    public void heavyAttack(){
        heavyAttacking = true;
    }

    public void stopHeavyAttack(){
        //where you implement the hit delay
        heavyAttacking = false;
    }

    public void damageImpact(int damage){
        health = health - damage;
        System.out.println(health);

        if (health <= 0){
            health = 0;
            //dead = true;
        }
    }
}
