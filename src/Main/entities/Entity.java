package Main.entities;

import Main.Handler;

import java.awt.*;

public abstract class Entity{

    protected Handler handler;
    protected float x, y;
    protected boolean falling = true;
    protected boolean jumping = false;


    public Entity(float x, float y){
        this.x = x;
        this.y = y;

    }

    public abstract void tick();

    public abstract void render(Graphics g);

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
}