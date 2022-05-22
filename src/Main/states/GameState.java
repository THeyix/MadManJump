package Main.states;

import Main.Handler;
import Main.UI.ClickListener;
import Main.UI.UIImageButton;
import Main.UI.UIManager;
import Main.player.Player;
import Main.textures.Assets;

import java.awt.*;

public class GameState extends State {

    private UIManager uiManager;
    private Player player;

    public State EscState;

    public GameState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler);
        player = new Player(handler, 600, 600);

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
        player.render(g);

    }
}
