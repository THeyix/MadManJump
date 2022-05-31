package Main.entities;

import Main.Handler;
import Main.UI.UIManager;
import Main.states.EscState;
import Main.states.State;
import Main.textures.Assets;

import java.awt.*;

public class Player extends MovementLogic {

//    private float gravity = 0.1f;
//    private float maxSpeed = 1000000;
//    private float yVel;


    public Player(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);

        boundsLeft.x = 0;
        boundsLeft.y = 10;
        boundsLeft.width = width / 5;
        boundsLeft.height = height-10;
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
        //TODO animacijos neturi but cia
    }


    @Override
    public void tick() {
        getInput();
        move();
    }

    public void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().left)
            xMove = -speed;

        if(handler.getKeyManager().right)
            xMove = speed;

        if(handler.getKeyManager().escape) {
            handler.getMouseManager().setUiManager(null);
            handler.getMouseManager().setUiManager(new UIManager(handler));
            State.setState(new EscState(handler));}

//        if(handler.getKeyManager().jump)

//        if(falling || jumping){
//            yVel += gravity;
//
//            if(yVel > maxSpeed){   // gravitation
//                yVel = maxSpeed;
//            }
//        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) x, (int) y, null);// after int x, int y, 40, 70 must be;(could be changed)
        g.drawRect((int) x, (int) y, boundsLeft.width, boundsLeft.height);
    }
}
