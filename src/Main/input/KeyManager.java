package Main.input;

import Main.UI.UIManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys, justPressed, cantPressed;
    public boolean right, left, jump, escape;
    private UIManager uiManager;

    public KeyManager(){
        keys = new boolean[525];
        justPressed = new boolean[keys.length];
        cantPressed = new boolean[keys.length];
    }

    public void tick(){
        for (int i = 0; i < keys.length; i++){
            if (cantPressed[i] && !keys[i]){
                cantPressed[i] = false;
            } else if (justPressed[i]){
                cantPressed[i] = true;
                justPressed[i] = false;
            }
            if (!cantPressed[i] && keys[i]){
                justPressed[i] = true;
            }
        }

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

    public boolean keyJustPressed(int keyCode){
        if(keyCode < 0 || keyCode >= keys.length)
            return false;
        return justPressed[keyCode];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
