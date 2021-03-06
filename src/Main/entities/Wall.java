package Main.entities;

import Main.Handler;

import java.awt.*;

public class Wall {
    private static Handler handler;
    private int x, y;
    private int width, height;

    public Wall(Handler handler, int x, int y, int width, int height){
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

    public static Rectangle getLeftWallBounds() {
        return new Rectangle(0, 0, 200, handler.getHeight()); // bounds gonna be changed
    }
    public static Rectangle getRightWallBounds() {
        return new Rectangle(handler.getWidth()-200, 0, 200, handler.getHeight()); // bounds gonna be changed
    }
    public static Rectangle getBottomWallBounds() {
        return new Rectangle(0, handler.getHeight()-200, handler.getWidth(), 200); // bounds gonna be changed
    }
}