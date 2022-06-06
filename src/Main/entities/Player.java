package Main.entities;

import Main.Handler;
import Main.UI.UIManager;
import Main.states.EscState;
import Main.states.State;
import Main.textures.Animation;
import Main.textures.Assets;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends MovementLogic{

    private boolean falling = true;
    protected boolean jumping = false;
    protected float velX = 0, velY = 0;
    private float gravity = 5f;
    private Animation playerAnimation;


    public Player(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 32;
        bounds.height = 80;

        //Animatons
        playerAnimation = new Animation(0, Assets.jumpingAnimation);
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

        x += velX;
        y += velY;

        if(Wall.getLeftWallBounds().contains(x, y)){
            x = Wall.getLeftWallBounds().x + Wall.getLeftWallBounds().width + 1;
        }
        if(Wall.getRightWallBounds().contains(x + 50, y)){
            x = Wall.getRightWallBounds().x - 50;
        }

        if(falling || jumping) {

            velY += gravity;
            if (velY > 10f) {
                velY = 5f;
            }
            if(Wall.getBottomWallBounds().contains(x, y + 80)) {
                falling = false;
                velY = 0;
                y = Wall.getBottomWallBounds().y - 80;
            }else {
                falling = true;
            }
        }
    }

    public void getInput() {
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManager().left && (!falling || !jumping)) {
            xMove = -speed;
        }

        if (handler.getKeyManager().right && (!falling || !jumping)) {
            xMove = speed;
        }

        if (handler.getKeyManager().escape) {
            handler.getMouseManager().setUiManager(null);
            handler.getMouseManager().setUiManager(new UIManager(handler));
            State.setState(new EscState(handler));
        }

        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_SPACE) && !falling) {
            yMove = -speed*50;
            jumping = true;


        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) x, (int) y, 50, 80, null);

        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_SPACE)){
            g.drawImage(Assets.jumpingAnimation[0], (int) x, (int) y, 50, 80, null);
        }

//        g.setColor(Color.red);
//        g.fillRect((int) x - (bounds.x - 9), (int) y - bounds.y, bounds.width, bounds.height);

        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.WHITE);
//        g2d.draw(getBounds());
//        g2d.draw(getBoundsTop());
//        g2d.draw(getBoundsLeft());
//        g2d.draw(getBounds());

    }

//    public Rectangle getBounds(){
//        return new Rectangle((int) x - (boundsLeft.x - 9), (int) y - boundsLeft.y, boundsLeft.width - 18, boundsLeft.height);
//    }
//    public Rectangle getBoundsTop(){
//        return new Rectangle((int) x - (boundsLeft.x - 9), (int) y - boundsLeft.y, boundsLeft.width - 18, boundsLeft.height);
//    }

    public Rectangle getBounds(){
        return new Rectangle((int) x - (bounds.x - 9), (int) y - bounds.y, bounds.width , bounds.height);
    }
}
