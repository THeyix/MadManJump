package Main.entities;

import Main.Handler;
import Main.UI.UIManager;
import Main.input.KeyManager;
import Main.states.EscState;
import Main.states.State;
//import Main.textures.Animation;
import Main.textures.Assets;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;

public class Player extends MovementLogic{

    protected boolean onGround = false;
    protected boolean canJump = true;
    protected float jumpValue = 0;

    public static boolean spaceReleased = false;
    public static boolean rightReleased = false;
    public static boolean leftReleased = false;

    protected float velX = 0, velY = 0;
    private float gravity = 5f;

    //private Animation playerAnimation;

    public Player(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 60;
        bounds.height = 100;

        //Animatons
        //playerAnimation = new Animation(0, Assets.jumpingAnimation);
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
        getInput();
        move();

        x += velX;
        y += velY;


        if(Wall.getLeftWallBounds().contains(x, y)){
            x = Wall.getLeftWallBounds().x + Wall.getLeftWallBounds().width + 1;
        }
        if(Wall.getRightWallBounds().contains(x + bounds.width, y)){
            x = Wall.getRightWallBounds().x - bounds.width - 1;
        }
//        if(y == Block.getY() && handler.getWidth()-400 <= x && x <= (handler.getWidth()-400) + Block.getWidth()){
//            y = Block.getY();
//        }
        // sita galima patobulint ir veiktu
        if(Block.get1BlockBounds().contains(x, y)){
            x = Block.get1BlockBounds().x - bounds.width;
        }


        if(!onGround) {

            velY += gravity;
            if (velY > 10f) {
                velY = 10f;
            }
            if(Wall.getBottomWallBounds().contains(x, y + bounds.height)) {
                onGround = true;
                velY = 0;
                y = Wall.getBottomWallBounds().y - bounds.height - 2;// kazkas cia negerai
            }else {
                onGround = false;
            }
        }
    }

    public void getInput() {
        xMove = 0;
        yMove = 0;

        if(onGround){
            velY = 0;
            velX = 0;
        }

        if(handler.getKeyManager().left && onGround && jumpValue==0) {
            xMove = -DEFAULT_SPEED;
        }

        if(handler.getKeyManager().right && onGround && jumpValue==0) {
            xMove = DEFAULT_SPEED;
        }

        if(handler.getKeyManager().escape) {
            handler.getMouseManager().setUiManager(null);
            handler.getMouseManager().setUiManager(new UIManager(handler));
            State.setState(new EscState(handler));
        }

        if(handler.getKeyManager().jump && onGround && canJump) {
            jumpValue += 0.3f;
            xMove = 0;
            //System.out.println("jumpValue: " + jumpValue);
        }

        if(jumpValue >= 15 && onGround){
            jumpValue = 15;
        }

        if(spaceReleased && onGround && canJump && !handler.getKeyManager().right && !handler.getKeyManager().left) {
            velY = -jumpValue * 3f;
            jumpValue = 0;

            canJump = true;
            onGround = false;
            spaceReleased = false;
        }

        if(spaceReleased && onGround && canJump && handler.getKeyManager().right) {
            velX += 10f;
            velY = -jumpValue * 3f;
            jumpValue = 0;

            canJump = true;
            onGround = false;
            spaceReleased = false;
            rightReleased = false;
        }

        if(spaceReleased && onGround && canJump && handler.getKeyManager().left) {
            velX -= 10f;
            velY = -jumpValue * 3f;
            jumpValue = 0;

            canJump = true;
            onGround = false;
            spaceReleased = false;
            rightReleased = false;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) x, (int) y, 60, 100, null);

//        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_SPACE)){
//            g.drawImage(Assets.jumpingAnimation[0], (int) x, (int) y, 60, 100, null);
//        }

    }

    public Rectangle getBounds(){
        return new Rectangle((int) x - bounds.x, (int) y - bounds.y, bounds.width , bounds.height);
    }

    public static void setSpaceReleased(boolean spaceReleased) {
        Player.spaceReleased = spaceReleased;
    }

    public static void setRightReleased(boolean rightReleased) {
        Player.rightReleased = rightReleased;
    }

    public static void setLeftReleased(boolean leftReleased) {
        Player.leftReleased = leftReleased;
    }
}
