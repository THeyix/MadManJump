package Main.entities;

import Main.Handler;

import java.awt.*;

public class Block {
    private static Handler handler;
    private int x;
    private static int y;
    private static int width;
    private int height;

    public Block(Handler handler, int x, int y, int width, int height){
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

    public static int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static int getWidth() {
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

    public static Rectangle get1BlockBounds() {
        return new Rectangle(handler.getWidth()-400, handler.getHeight()-350, 250, 20); // bounds gonna be changed
    }

}