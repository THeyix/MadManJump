package Main.entities;

import Main.Handler;
import Main.Scenes.SceneManager;

import java.awt.*;

public class Wall extends SceneManager {

    private int x, y, width, height;

    public Wall(Handler handler, int x, int y, int width, int height){
        super(handler, x, y, width, height);
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, y, width, height);
        g.setColor(Color.white);
        getLeftWallBounds();
        g.fillRect(300, y, 200, height);
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
//    public Rectangle getBounds(){
//        return new Rectangle(x, y, 32, 32);
//    }
//    public Rectangle getBoundsTop(){
//        return new Rectangle(x, y, 32, 32);
//    }
//    public Rectangle getBoundsRight(){
//        return new Rectangle(x, y, 32, 32);
//    }
    public Rectangle getLeftWallBounds() {
        return new Rectangle(300, y, 50, height); // bounds gonna be changed
    }
}