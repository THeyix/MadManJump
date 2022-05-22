package Main.player;

import Main.Handler;
import Main.UI.UIManager;
import Main.states.EscState;
import Main.states.MenuState;
import Main.states.State;
import Main.textures.Assets;
import Main.textures.Wall;

import java.awt.*;

public class Player extends Entity{

    private Handler handler;
//    private float gravity = 0.1f;
//    private float maxSpeed = 1000000;
//    private float yVel;


    public Player(Handler handler, float x, float y){
        super(x, y);
        this.handler = handler;
    }

    @Override
    public void tick() {

//        y = yVel;

        if(handler.getKeyManager().left)
            x -= 1;
        if(handler.getKeyManager().right)
            x += 1;
        //if(handler.getKeyManager().jump)
            //ojoj cia bus blogai

//        if(falling || jumping){
//            yVel += gravity;
//
//            if(yVel > maxSpeed){   // gravitation
//                yVel = maxSpeed;
//            }
//        }

        if(handler.getKeyManager().escape) {
            handler.getMouseManager().setUiManager(null);
            handler.getMouseManager().setUiManager(new UIManager(handler));
            State.setState(new EscState(handler));}

    }

//    private void collission(){
//        if(getBounds().intersects(wall.getBounds())){
//            y = wall.getY() - height;
//            yVel = 0;
//        }
//    }

//    public Rectangle getBounds(){
//        return new Rectangle((int)x, (int)y, 32, 32);
//    }
//    public Rectangle getBoundsTop(){
//        return new Rectangle((int)x, (int)y, 32, 32);
//    }
//    public Rectangle getBoundsRight(){
//        return new Rectangle((int)x, (int)y, 32, 32);
//    }
//    public Rectangle getBoundsLeft(){
//        return new Rectangle((int)x, (int)y, 32, 32); // bounds gonna be changed
//    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) x, (int) y, null);
    }
}
