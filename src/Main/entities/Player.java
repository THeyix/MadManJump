package Main.entities;

import Main.Handler;
import Main.UI.UIManager;
import Main.states.EscState;
import Main.states.State;
import Main.textures.Assets;

import java.awt.*;

public class Player extends Entity{

    private Handler handler;
//    private float gravity = 0.1f;
//    private float maxSpeed = 1000000;
//    private float yVel;


    public Player(Handler handler, float x, float y){
        super(x, y);
        this.handler = handler;


        //Animatons
//         = new Animation(500, Assets.player_jumpLeft);
//         = new Animation(500, Assets.player_jumpRight);
//         = new Animation(500, Assets.player_landLeft);
//         = new Animation(500, Assets.player_landRight);
//         = new Animation(500, Assets.player_fallLeft);
//         = new Animation(500, Assets.player_fallRight);
//         = new Animation(500, Assets.player_feltOnTheGround);
//         = new Animation(500, Assets.player_crouch);
//         = new Animation(500, Assets.player_left);
//        animRight = new Animation(500, Assets.player_right);
    }


    @Override
    public void tick() {

//        y = yVel;

        if(handler.getKeyManager().left)
            x -= 1;
        if(handler.getKeyManager().right)
            x += 1;
//        if(handler.getKeyManager().jump)


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

//    private void collision(){
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
