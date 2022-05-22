package Main.player;

import Main.Handler;
import Main.UI.UIManager;
import Main.states.MenuState;
import Main.states.State;
import Main.textures.Assets;

import java.awt.*;

public class Player extends Entity{

    private Handler handler;

    public Player(Handler handler, float x, float y){
        super(x, y);
        this.handler = handler;
    }

    @Override
    public void tick() {

        if(handler.getKeyManager().left)
            x -= 1;
        if(handler.getKeyManager().right)
            x += 1;
        //if(handler.getKeyManager().jump)
            //ojoj cia bus blogai
        if(handler.getKeyManager().escape) {
            handler.getMouseManager().setUiManager(null);
            handler.getMouseManager().setUiManager(new UIManager(handler));
            State.setState(new MenuState(handler));}
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) x, (int) y, null);
    }

}
