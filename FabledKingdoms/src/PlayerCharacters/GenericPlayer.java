package PlayerCharacters;

import Maps.TestingMap;
import java.awt.*;

public class GenericPlayer extends Player {
    private int playerWidth, playerHeight;
    private int jumpCounter;
    private double playerSpeed,xSpeed, ySpeed;
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



    //delete later
    private Color color;

    public GenericPlayer(int x, int y, Color c){
        super(x,y);
        this.color = c;

        playerWidth = 4;
        playerHeight = 7;

        jumpCounter = 0;
        playerSpeed = 0.5;
        xSpeed = 0;
        ySpeed = 0;

        canMove = true;

        maxHealth = 100;

        dead = false;

        lightAttack = 4;
        heavyAttack = 7;
        lightAttacking = false;
        heavyAttacking = false;
    }

    @Override
    public void draw(Graphics g) {
        int xPos = (int)(((double)this.xPosPlayer/100) * this.getScreenWidth);
        int yPos = (int)(((double)this.yPosPlayer/100) * this.getScreenHeight);
        int w = (int)(((double) playerWidth /100) * this.getScreenWidth);
        int h = (int)(((double) playerHeight /100) * this.getScreenHeight);

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

    public void collisionDetection(){
        int xCheck = (int)(xPosPlayer + (0.5 * playerWidth));
        int yCheck = yPosPlayer + playerHeight;

        if (TestingMap.floor.MapColliding(xCheck, yCheck)) {
            yPosPlayer = (TestingMap.floor.yPosMapComp - playerHeight);
            jumpCounter = 0;
            ySpeed = 0;
        } else if (TestingMap.leftPlatform.MapColliding(xCheck, yCheck) && ySpeed < 0){
            yPosPlayer = (TestingMap.leftPlatform.yPosMapComp - playerHeight);
            jumpCounter = 0;
            ySpeed = 0;
        } else if (TestingMap.rightPlatform.MapColliding(xCheck, yCheck) && ySpeed < 0){
            yPosPlayer = (TestingMap.rightPlatform.yPosMapComp - playerHeight);
            jumpCounter = 0;
            ySpeed = 0;
        } else {
            initiateGravity();
        }

        if (TestingMap.trainingPlayer.playerColliding(xCheck,yCheck) && lightAttacking){
            System.out.println("light attack collision");
        } else if (TestingMap.trainingPlayer.playerColliding(xCheck,yCheck) && heavyAttacking){
            System.out.println("heavy attack collision");
        }

    }

    public boolean playerColliding(int xPlayer, int yPlayer){
        //check the bound of the direction the player is looking in
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

    private void initiateGravity(){
        ySpeed -= 1;
    }

    private void outOfBounds(){
        if(xPosPlayer < 0){
            xPosPlayer = 0;
        }
        if ((xPosPlayer + playerWidth) > 100){
            xPosPlayer = 100 - playerWidth;
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


}
