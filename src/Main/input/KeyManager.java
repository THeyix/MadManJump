package Main.input;

import Main.UI.UIManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean right, left, jump, escape;
    private UIManager uiManager;

    public KeyManager(){
        keys = new boolean[256];
    }

    public void tick(){
        right = keys[KeyEvent.VK_D];
        left = keys[KeyEvent.VK_A];
        jump = keys[KeyEvent.VK_SPACE];
        escape = keys[KeyEvent.VK_ESCAPE];
    }

    public void setUiManager(UIManager uiManager){
        this.uiManager = uiManager;
    }

    public UIManager getUiManager() {
        return uiManager;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


}
