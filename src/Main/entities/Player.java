package Main.entities;

import Main.Handler;
import Main.UI.UIManager;
import Main.states.EscState;
import Main.states.State;
import Main.textures.Assets;

import java.awt.*;

public class Player extends MovementLogic {

    private boolean falling = true;
    protected boolean jumping = false;
    protected float velX = 0, velY = 0;
    private float gravity = 0.25f;


    public Player(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);

        boundsLeft.x = 0;
        boundsLeft.y = 0;
        boundsLeft.width = 50;
        boundsLeft.height = 80;

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

//        x += velX;
//        y += velY;
//
//        if(falling || jumping) {
//            velY += gravity;
//
//            if(velY > 0.75) {
//                velY = 0.03f;
//            }
//        }
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
//    private void Collision(){
//        for(int i = 0; i < handler, i++){
//
//        }
//    }
//
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) x, (int) y, 50, 80, null);

        g.setColor(Color.red);
        g.fillRect((int) x - (boundsLeft.x - 9), (int) y - boundsLeft.y, boundsLeft.width - 18, boundsLeft.height);

        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.WHITE);
//        g2d.draw(getBounds());
//        g2d.draw(getBoundsTop());
        g2d.draw(getBoundsLeft());
        g2d.draw(getBoundsRight());

    }

//    public Rectangle getBounds(){
//        return new Rectangle((int) x - (boundsLeft.x - 9), (int) y - boundsLeft.y, boundsLeft.width - 18, boundsLeft.height);
//    }
//    public Rectangle getBoundsTop(){
//        return new Rectangle((int) x - (boundsLeft.x - 9), (int) y - boundsLeft.y, boundsLeft.width - 18, boundsLeft.height);
//    }
    public Rectangle getBoundsLeft(){
        return new Rectangle((int) x - (boundsLeft.x - 9), (int) y - boundsLeft.y, boundsLeft.width - 18, boundsLeft.height);
    }
    public Rectangle getBoundsRight(){
        return new Rectangle((int) x - (boundsRight.x - 9), (int) y - boundsRight.y, boundsRight.width , boundsRight.height);
    }
}
