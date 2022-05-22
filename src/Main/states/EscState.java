package Main.states;

import Main.Handler;
import Main.UI.ClickListener;
import Main.UI.UIImageButton;
import Main.UI.UIManager;
import Main.textures.Assets;

import java.awt.*;

public class EscState extends State {

    private UIManager uiManager;

    public EscState(Handler handler){
        super(handler);

        uiManager = handler.getMouseManager().getUiManager();
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIImageButton(handler.getWidth()/2-180, handler.getHeight()/2, 320,80, Assets.back, new ClickListener(){
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                handler.getMouseManager().setUiManager(new UIManager(handler));
                State.setState(handler.getGame().gameState);

            }
        }));

        uiManager.addObject(new UIImageButton(handler.getWidth()/2-180, handler.getHeight()/2+150, 320,80, Assets.back, new ClickListener(){
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                handler.getMouseManager().setUiManager(new UIManager(handler));
                State.setState(new OptionsState(handler));

            }
        }));

        uiManager.addObject(new UIImageButton(handler.getWidth()/2-180, handler.getHeight()/2+300, 320,80, Assets.exit, new ClickListener(){
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                handler.getMouseManager().setUiManager(new UIManager(handler));
                State.setState(new MenuState(handler));

            }
        }));
    }

    @Override
    public void tick() {

        uiManager.tick();

    }

    @Override
    public void render(Graphics g) {

        g.drawImage(Assets.escBackgroundImage, 0,0, handler.getWidth(), handler.getHeight(), null);
        uiManager.render(g);

    }
}
