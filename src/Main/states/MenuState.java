package Main.states;

import Main.Handler;
import Main.UI.ClickListener;
import Main.UI.UIImageButton;
import Main.UI.UIManager;
import Main.textures.Assets;

import java.awt.*;

public class MenuState extends State {

    private UIManager uiManager;

    public MenuState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIImageButton(handler.getWidth()/2+100, handler.getHeight()/2+200, 240,80, Assets.exit, new ClickListener(){
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                System.exit(0);
            }
        }));

        uiManager.addObject(new UIImageButton(handler.getWidth()/2-200, handler.getHeight()/2, 400,150, Assets.start, new ClickListener(){
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));

        uiManager.addObject(new UIImageButton(handler.getWidth()/2-400, handler.getHeight()/2+200, 240,80, Assets.options, new ClickListener(){
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                handler.getMouseManager().setUiManager(new UIManager(handler));
                State.setState(new OptionsState(handler));
            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.backgroundImage, 0,0, handler.getWidth(), handler.getHeight(), null);
        uiManager.render(g);
    }
}