package Main.states;

import Main.Handler;
import Main.UI.ClickListener;
import Main.UI.UIImageButton;
import Main.UI.UIManager;
import Main.entities.Wall;
import Main.entities.Player;
import Main.textures.Assets;

import java.awt.*;

public class GameState extends State {

    private UIManager uiManager;
    private Player player;

    public static Wall leftWall, rightWall, bottomWall;

    public State EscState;

    public GameState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler);
        player = new Player(handler, 600, 600, 32, 50);//width and height not final, depends on the players final model
        leftWall = new Wall(handler, 0, 0, 200, handler.getHeight());
        rightWall = new Wall(handler, handler.getWidth()-200, 0, 200, handler.getHeight());
        bottomWall = new Wall(handler, 0, handler.getHeight()-200, handler.getWidth(), 200);


        handler.getKeyManager().setUiManager(uiManager);
        uiManager.addObject(new UIImageButton(handler.getWidth()/2-400, handler.getHeight()/2+200, 240,80, Assets.options, new ClickListener(){
            @Override
            public void onClick() {
                handler.getKeyManager().setUiManager(null);
                handler.getKeyManager().setUiManager(new UIManager(handler));
                State.setState(new EscState(handler));
            }
        }));
    }

    @Override
    public void tick() {
        player.tick();
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.firstStageBackgroundImage, 0,0, handler.getWidth(), handler.getHeight(), null);

        leftWall.render(g);
        rightWall.render(g);
        bottomWall.render(g);

        player.render(g);
    }
}
