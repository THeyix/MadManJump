package Main;

import Main.display.Display;
import Main.input.KeyManager;
import Main.input.MouseManager;
import Main.states.GameState;
import Main.states.MenuState;
import Main.states.State;
import Main.textures.Assets;
import Main.textures.Wall;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{

    private Display display;
    public String title;
    private int width, height;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    //States
    public State gameState;
    public State menuState;

    //Input
    private KeyManager keyManager;
    private MouseManager mouseManager;

    //Main.Handler
    private Handler handler;


    public Game(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();

        handler = new Handler(this);
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        State.setState(menuState);
    }

    private void tick(){
        keyManager.tick();

        if(State.getState() != null)
            State.getState().tick();
    }

    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0,0, width, height);
        // We can draw here

        if(State.getState() != null)
            State.getState().render(g);

        //Draw ends here

        bs.show();
        g.dispose();

    }

    public void run(){
        init();

        while(running){
            tick();
            render();
        }

        stop();
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public MouseManager getMouseManager(){
        return mouseManager;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
