package Main.entities;

import Main.Handler;

import java.awt.*;

public abstract class MovementLogic {

    public static final float DEFAULT_SPEED = 1f;

    protected Handler handler;
    protected float x, y;
    protected float xMove, yMove;
    protected int width, height;
    protected float speed;
    protected boolean falling = true;
    protected boolean jumping = false;
    protected Rectangle boundsLeft, boundsRight, boundsTop, boundsBottom;


    public MovementLogic(Handler handler, float x, float y, int width, int height){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        xMove = 0;
        yMove = 0;
        speed = DEFAULT_SPEED;

        boundsLeft = new Rectangle(0, 0, width, height);
    }

    public void move(){
        moveX();
        moveY();
    }

    public void moveX() {
        if (xMove > 0){ // moving right
            x += xMove;
        }

        else if(xMove < 0) { //moving left
            int tx = (int) (x + xMove + boundsLeft.x);

            if(!collisionWithWall(tx, (int) (y + boundsLeft.y))){
                x += xMove;
            }
            else{
                x = tx - boundsLeft.x - 1;
            }
        }
    }

    public void moveY(){
        y += yMove;
    }

    protected boolean collisionWithWall(int x, int y){
//        if(Wall.getLeftWallBounds().intersects(getBoundsLeft())){
//            return true;
//        }
        return false;
    }

    public abstract void tick(); //cannot override without these

    public abstract void render(Graphics g);// same here

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public boolean isFalling() {
        return falling;
    }

    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public Rectangle getBoundsLeft() {
        return boundsLeft;
    }

    public void setBoundsLeft(Rectangle boundsLeft) {
        this.boundsLeft = boundsLeft;
    }

    public Rectangle getBoundsRight() {
        return boundsRight;
    }

    public void setBoundsRight(Rectangle boundsRight) {
        this.boundsRight = boundsRight;
    }

    public Rectangle getBoundsTop() {
        return boundsTop;
    }

    public void setBoundsTop(Rectangle boundsTop) {
        this.boundsTop = boundsTop;
    }

    public Rectangle getBoundsBottom() {
        return boundsBottom;
    }

    public void setBoundsBottom(Rectangle boundsBottom) {
        this.boundsBottom = boundsBottom;
    }
}