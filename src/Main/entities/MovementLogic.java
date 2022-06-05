package Main.entities;

import Main.Handler;

import java.awt.*;

public abstract class MovementLogic {

    public static final float DEFAULT_SPEED = 5f;

    protected Handler handler;
    protected float x, y;
    protected float xMove, yMove;
    protected int width, height;
    protected float speed;
    protected boolean falling = true;
    protected boolean jumping = false;
    protected Rectangle bounds;


    public MovementLogic(Handler handler, float x, float y, int width, int height){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        xMove = 0;
        yMove = 0;
        speed = DEFAULT_SPEED;

        bounds = new Rectangle(0, 0, width, height);
    }

    public void move(){
        moveX();
        moveY();
    }

    public void moveX() {

            int tx = (int) (x + xMove);
            if (xMove > 0) { // moving right

                if (!collisionWithWall(tx, (int) (y)) &&
                        !collisionWithWall(tx, (int) (y + bounds.height))) {
                    x += xMove;
                } else {
                    x = tx - 1;
                }
            } else if (xMove < 0) { //moving left

                if (!collisionWithWall(tx, (int) (y)) &&
                        !collisionWithWall(tx, (int) (y + bounds.height))) {
                    x += xMove;
                } else {
                    x = tx + 1;
                }
            }
        }

    public void moveY(){

        if(yMove < 0){ // jumping
            int ty = (int) (y + yMove);

                if(!collisionWithWall((int) (x), ty) &&
                    !collisionWithWall((int) (x + bounds.width), ty)){
                y += yMove;
            }
                else{
                    y = ty + 1;

                    if(!collisionWithWall((int) (x), (int) (y)) &&
                        !collisionWithWall((int) (x + bounds.width), (int) (y))){
                        falling = false;
                        yMove = 0;
                    }

                    else{
                        falling = true;
                    }
                }
        }
        else if(yMove > 0){ // falling
            int ty = (int) (y + yMove);

                if(!collisionWithWall((int) (x), ty) &&
                    !collisionWithWall((int) (x + bounds.width), ty)){
                y += yMove;
            }
                else{
                    y = ty - 1;

                    if(!collisionWithWall((int) (x), (int) (y)) &&
                        !collisionWithWall((int) (x + bounds.width), (int) (y))){
                        falling = false;
                        yMove = 0;
                    }

                        else{
                            falling = true;
                        }

                }
        }
    }

    protected boolean collisionWithWall(int x, int y){
        if(Wall.getLeftWallBounds().contains(x, y)){
            return true;
        }else if(Wall.getRightWallBounds().contains(x + 50, y)) {
            return true;
        }
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

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }


}