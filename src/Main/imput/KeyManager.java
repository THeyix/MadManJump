package Main.imput;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean right, left, jump;

    public KeyManager(){
        keys = new boolean[256];
    }

    public void tick(){
        right = keys[KeyEvent.VK_D];
        left = keys[KeyEvent.VK_A];
        jump = keys[KeyEvent.VK_SPACE];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        System.out.println("Pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
