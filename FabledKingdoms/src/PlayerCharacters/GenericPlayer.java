package PlayerCharacters;

import Maps.*;

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

    private MapFrame mapFrame;

    public GenericPlayer(int x, int y, Color c, String map, MapFrame mapFrame){
        super(x,y);
        this.color = c;
        this.mapSelection = map;
        this.mapFrame = mapFrame;
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
        //Graphics gg = get
        xPos = (int)(((double)this.xPosPlayer/100) * this.getScreenWidth);
        yPos = (int)(((double)this.yPosPlayer/100) * this.getScreenHeight);
        w = (int)(((double) playerWidth /100) * this.getScreenWidth);
        h = (int)(((double) playerHeight /100) * this.getScreenHeight);

        g.setColor(color);
        g.drawRect(xPos,yPos,w,h);

        //g.drawImage(MapFrame.player, xPos, yPos, w, h, (img, infoflags, x, y, width, height) -> false);
    }

    public void updateWidth(int w){this.getScreenWidth = w;}

    public void updateHeight(int h){this.getScreenHeight = h;}

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

    public void onlineMovement(int x, int y){
        xPosPlayer = x;
        yPosPlayer = y;
    }

    public void collisionDetection(){
        if (mapSelection.equals("TestingMap")){
            testingMapCollisions();
        } else if (mapSelection.equals("Blockage")){
            blockageCollisions();
        } else if (mapSelection.equals("Pillars")){
            pillarsCollisions();
        } else if (mapSelection.equals("CenterCore")){
            centerCoreCollisions();
        }
    }

    private void testingMapCollisions(){
        int xCheck = (int)(xPosPlayer + (0.5 * playerWidth));
        int yCheck = yPosPlayer + playerHeight;

        //Floor
        if (TestingMap.floor.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            yPosPlayer = (TestingMap.floor.yPosMapComp - playerHeight);
            jumpCounter = 0;
            ySpeed = 0;
        }

        //Left Platform
        if (TestingMap.leftPlatformTop.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())){
            yPosPlayer = (TestingMap.leftPlatformTop.yPosMapComp - playerHeight);
            jumpCounter = 0;
            ySpeed = 0;
        } else if (TestingMap.leftPlatformBottom.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            yPosPlayer = (TestingMap.leftPlatformBottom.yPosMapComp);
            ySpeed = 0;
        } else if (TestingMap.leftPlatformLeft.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            xPosPlayer = (TestingMap.leftPlatformLeft.xPosMapComp - playerWidth);
        } else if (TestingMap.leftPlatformRight.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            xPosPlayer = (TestingMap.leftPlatformRight.xPosMapComp);
        }

        //Right Platform
        if (TestingMap.rightPlatformTop.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())){
            yPosPlayer = (TestingMap.rightPlatformTop.yPosMapComp - playerHeight);
            jumpCounter = 0;
            ySpeed = 0;
        } else if (TestingMap.rightPlatformBottom.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            yPosPlayer = (TestingMap.rightPlatformBottom.yPosMapComp);
            ySpeed = 0;
        } else if (TestingMap.rightPlatformLeft.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            xPosPlayer = (TestingMap.rightPlatformLeft.xPosMapComp - playerWidth);
        } else if (TestingMap.rightPlatformRight.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            xPosPlayer = (TestingMap.rightPlatformRight.xPosMapComp);
        }

        if (TestingMap.trainingPlayer.playerColliding(xCheck,yCheck) && lightAttacking){
            System.out.println("light attack collision");
            damageImpact(lightAttack);
        } else if (TestingMap.trainingPlayer.playerColliding(xCheck,yCheck) && heavyAttacking){
            System.out.println("heavy attack collision");
            damageImpact(heavyAttack);
        }

        if (TestingMap.p2.playerColliding(xCheck,yCheck) && lightAttacking){
            System.out.println("light attack collision");
            damageImpact(lightAttack);
        } else if (TestingMap.p2.playerColliding(xCheck,yCheck) && heavyAttacking){
            System.out.println("heavy attack collision");
            damageImpact(heavyAttack);
        }
    }

    private void blockageCollisions(){
        //Floor
        if (Blockage.floor.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            yPosPlayer = (Blockage.floor.yPosMapComp - playerHeight);
            jumpCounter = 0;
            ySpeed = 0;
        }

        //Block
        if (Blockage.blockTop.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
            yPosPlayer = (Blockage.blockTop.yPosMapComp - playerHeight);
            jumpCounter = 0;
            ySpeed = 0;
        } else if (Blockage.blockBottom.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
            yPosPlayer = (Blockage.blockBottom.yPosMapComp);
            ySpeed = 0;
        } else if (Blockage.blockLeft.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
            xPosPlayer = (Blockage.blockLeft.xPosMapComp - playerWidth);
        } else if (Blockage.blockRight.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
            xPosPlayer = (Blockage.blockRight.xPosMapComp);
        }

        //Left Platform
        if (Blockage.leftPlatformTop.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
            yPosPlayer = (Blockage.leftPlatformTop.yPosMapComp - playerHeight);
            jumpCounter = 0;
            ySpeed = 0;
        } else if (Blockage.leftPlatformBottom.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
            yPosPlayer = (Blockage.leftPlatformBottom.yPosMapComp);
            ySpeed = 0;
        } else if (Blockage.leftPlatformLeft.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
            xPosPlayer = (Blockage.leftPlatformLeft.xPosMapComp - playerWidth);
        } else if (Blockage.leftPlatformRight.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
            xPosPlayer = (Blockage.leftPlatformRight.xPosMapComp);
        }

        //Right Platform
        if (Blockage.rightPlatformTop.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
            yPosPlayer = (Blockage.rightPlatformTop.yPosMapComp - playerHeight);
            jumpCounter = 0;
            ySpeed = 0;
        } else if (Blockage.rightPlatformBottom.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
            yPosPlayer = (Blockage.rightPlatformBottom.yPosMapComp);
            ySpeed = 0;
        } else if (Blockage.rightPlatformLeft.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
            xPosPlayer = (Blockage.rightPlatformLeft.xPosMapComp - playerWidth);
        } else if (Blockage.rightPlatformRight.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
            xPosPlayer = (Blockage.rightPlatformRight.xPosMapComp);
        }

        //Top Platform
        if (Blockage.topPlatformTop.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
            yPosPlayer = (Blockage.topPlatformTop.yPosMapComp - playerHeight);
            jumpCounter = 0;
            ySpeed = 0;
        } else if (Blockage.topPlatformBottom.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
            yPosPlayer = (Blockage.topPlatformBottom.yPosMapComp);
            ySpeed = 0;
        } else if (Blockage.topPlatformLeft.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
            xPosPlayer = (Blockage.topPlatformLeft.xPosMapComp - playerWidth);
        } else if (Blockage.topPlatformRight.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
            xPosPlayer = (Blockage.topPlatformRight.xPosMapComp);
        }

    }

    private void pillarsCollisions(){
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

    private void centerCoreCollisions(){
        //Floor
        if (CenterCore.floor.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())) {
            yPosPlayer = (CenterCore.floor.yPosMapComp - playerHeight);
            jumpCounter = 0;
            ySpeed = 0;
        }

        //Middle Platform
        if (CenterCore.middlePlatformTop.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())){
            yPosPlayer = (CenterCore.middlePlatformTop.yPosMapComp - playerHeight);
            jumpCounter = 0;
            ySpeed = 0;
        } else if (CenterCore.middlePlatformBottom.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            yPosPlayer = (CenterCore.middlePlatformBottom.yPosMapComp);
            ySpeed = 0;
        } else if (CenterCore.middlePlatformLeft.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            xPosPlayer = (CenterCore.middlePlatformLeft.xPosMapComp - playerWidth);
        } else if (CenterCore.middlePlatformRight.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            xPosPlayer = (CenterCore.middlePlatformRight.xPosMapComp);
        }

        //LBase
        if (CenterCore.LBaseTop.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())){
            yPosPlayer = (CenterCore.LBaseTop.yPosMapComp - playerHeight);
            jumpCounter = 0;
            ySpeed = 0;
        } else if (CenterCore.LBaseBottom.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            yPosPlayer = (CenterCore.LBaseBottom.yPosMapComp);
            ySpeed = 0;
        } else if (CenterCore.LBaseLeft.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            xPosPlayer = (CenterCore.LBaseLeft.xPosMapComp - playerWidth);
        } else if (CenterCore.LBaseRight.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            xPosPlayer = (CenterCore.LBaseRight.xPosMapComp);
        }

        //LHeight
        if (CenterCore.LHeightTop.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())){
            yPosPlayer = (CenterCore.LHeightTop.yPosMapComp - playerHeight);
            jumpCounter = 0;
            ySpeed = 0;
        } else if (CenterCore.LHeightBottom.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            yPosPlayer = (CenterCore.LHeightBottom.yPosMapComp);
            ySpeed = 0;
        } else if (CenterCore.LHeightLeft.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            xPosPlayer = (CenterCore.LHeightLeft.xPosMapComp - playerWidth);
        } else if (CenterCore.LHeightRight.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
            xPosPlayer = (CenterCore.LHeightRight.xPosMapComp);
        }

        //JBase
        if (CenterCore.JBaseTop.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())){
            yPosPlayer = (CenterCore.JBaseTop.yPosMapComp - playerHeight);
            jumpCounter = 0;
            ySpeed = 0;
        } else if (CenterCore.JBaseBottom.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            yPosPlayer = (CenterCore.JBaseBottom.yPosMapComp);
            ySpeed = 0;
        } else if (CenterCore.JBaseLeft.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            xPosPlayer = (CenterCore.JBaseLeft.xPosMapComp - playerWidth);
        } else if (CenterCore.JBaseRight.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            xPosPlayer = (CenterCore.JBaseRight.xPosMapComp);
        }

        //JHeight
        if (CenterCore.JHeightTop.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())){
            yPosPlayer = (CenterCore.JHeightTop.yPosMapComp - playerHeight);
            jumpCounter = 0;
            ySpeed = 0;
        } else if (CenterCore.JHeightBottom.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            yPosPlayer = (CenterCore.JHeightBottom.yPosMapComp);
            ySpeed = 0;
        } else if (CenterCore.JHeightLeft.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            xPosPlayer = (CenterCore.JHeightLeft.xPosMapComp - playerWidth);
        } else if (CenterCore.JHeightRight.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
            xPosPlayer = (CenterCore.JHeightRight.xPosMapComp);
        }

        //Left Wall
        if (CenterCore.leftWallTop.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            yPosPlayer = (CenterCore.leftWallTop.yPosMapComp - playerHeight);
            jumpCounter = 0;
            ySpeed = 0;
        } else if (CenterCore.leftWallLeft.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            xPosPlayer = (CenterCore.leftWallLeft.xPosMapComp - playerWidth);
        } else if (CenterCore.leftWallRight.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
            xPosPlayer = (CenterCore.leftWallRight.xPosMapComp);
        }

        //Right Wall
        if (CenterCore.rightWallTop.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            yPosPlayer = (CenterCore.rightWallTop.yPosMapComp - playerHeight);
            jumpCounter = 0;
            ySpeed = 0;
        } else if (CenterCore.rightWallLeft.MapCollisionDetection(getLeftX(), getRightX(),getTopY(),getBottomY())) {
            xPosPlayer = (CenterCore.rightWallLeft.xPosMapComp - playerWidth);
        } else if (CenterCore.rightWallRight.MapCollisionDetection(getLeftX(),getRightX(),getTopY(),getBottomY())){
            xPosPlayer = (CenterCore.rightWallRight.xPosMapComp);
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
        mapFrame.genPlayer = mapFrame.genericPlayerSS.getImage(2,1,32,32);
        if(jumpCounter < 2){
            ySpeed = 6;
            jumpCounter++;
        }
    }

    public void left(){
        xSpeed = -1;
    }

    public void right(){
        xSpeed = 1;
    }

    public void startMoving(){
        canMove = true;
    }

    public void stopMoving(){
        canMove = false;
    }

    public void initiateGravity(){
        ySpeed -= 1;
        if (ySpeed < -4){
            ySpeed = -4;
        }
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


    public static int points;
    public void capturePoints(int points){
        this.points = points;
    }
}
