package Main.states;

import Main.Handler;
import Main.player.Player;
import Main.textures.Assets;

import java.awt.*;

public class GameState extends State {

    private Player player;

    public GameState(Handler handler){
        super(handler);
        player = new Player(handler, 600, 600);
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
