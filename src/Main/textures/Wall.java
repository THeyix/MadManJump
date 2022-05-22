package Main.textures;

import Main.Handler;

import java.awt.*;

public class Wall {

    private Handler handler;
    private int x, y, width, height;

    public Wall(Handler handler, int x, int y, int width, int height) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }
    public Rectangle getBoundsTop(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }
    public Rectangle getBoundsRight(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }
    public Rectangle getBoundsLeft() {
        return new Rectangle((int) x, (int) y, 32, 32); // bounds gonna be changed
    }

}