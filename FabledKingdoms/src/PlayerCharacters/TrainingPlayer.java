package PlayerCharacters;

import Maps.TestingMap;

import java.awt.*;

public class TrainingPlayer extends Player {
    private int playerWidth, playerHeight;
    private double ySpeed;

    private int jumpCounter;

    private boolean lookingLeft, lookingRight;

    private int health;
    private int maxHealth;
    private boolean dead;
    private boolean flinching;
    private long flinchTime;

    private Color color;


    public TrainingPlayer(int x, int y, Color c) {
        super(x, y);
        this.color = c;

        playerWidth = 4;
        playerHeight = 7;

        jumpCounter = 0;
        ySpeed = 0;

        maxHealth = 100;

        dead = false;
    }

    @Override
    public void draw(Graphics g) {
        int xPos = (int)(((double)this.xPosPlayer/100) * this.getScreenWidth);
        int yPos = (int)(((double)this.yPosPlayer/100) * this.getScreenHeight);
        int w = (int)(((double) playerWidth /100) * this.getScreenWidth);
        int h = (int)(((double) playerHeight /100) * this.getScreenHeight);

        g.setColor(color);
        g.fillRect(xPos,yPos,w,h);
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
        yPosPlayer -= ySpeed;
        collisionDetection();
    }

    @Override
    public void collisionDetection() {
        int xCheck = (int)(xPosPlayer + (0.5 * playerWidth));
        int yCheck = yPosPlayer + playerHeight;

        if (TestingMap.floor.MapColliding(xCheck, yCheck)) {
            yPosPlayer = (TestingMap.floor.yPosMapComp - playerHeight);
        } else if (TestingMap.leftPlatform.MapColliding(xCheck,yCheck) && ySpeed < 0){
            yPosPlayer = (TestingMap.leftPlatform.yPosMapComp - playerHeight);
        } else if (TestingMap.rightPlatform.MapColliding(xCheck, yCheck) && ySpeed < 0){
            yPosPlayer = (TestingMap.rightPlatform.yPosMapComp - playerHeight);
        } else {
            initiateGravity();
        }
    }

    @Override
    public boolean playerColliding(int xPlayer, int yPlayer) {
        if (xPlayer >= this.xPosPlayer && xPlayer <= (this.xPosPlayer + this.playerWidth)){
            return true;
        }
        return false;
    }

    public void up(){
        System.out.println("Got here");
        if(jumpCounter < 2){
            ySpeed = 9;
            jumpCounter++;
        }
    }

    private void initiateGravity(){
        ySpeed -=1;
    }
}
