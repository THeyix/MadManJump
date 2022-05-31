package Main.Scenes;

import Main.Handler;

import java.awt.*;

public class SceneManager {
    private Handler handler;
    private int x, y, width, height;

    public SceneManager(Handler handler, int x, int y, int width, int height){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    public void tick(){

    }

    public void render(Graphics g){

    }


}
