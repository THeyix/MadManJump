package Main.states;

import Main.Handler;
import Main.textures.Assets;

import java.awt.*;

public class GameState extends State {


    public GameState(Handler handler){
        super(handler);
        //Main.player = new Main.player();
    }

    @Override
    public void tick() {
        //Main.player.tick();
    }

    @Override
    public void render(Graphics g) {
        //Main.player.render();

        g.drawImage(Assets.firstStageBackgroundImage, 0,0, handler.getWidth(), handler.getHeight(), null);
    }
}
