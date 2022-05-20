import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.security.Key;

public class Game implements Runnable{

    private Display display;
    public String title;
    public int width, height;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    private BufferedImage backgroundtest;

    //States
    private State gameState;
    private State menuState;

    //Input
    private KeyManager keyManager;

    private Handler handler;

    public Game(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        keyManager = new KeyManager();

    }

    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        backgroundtest = ImageLoader.loadeImage("res/background/mainMenu_bg.png");

        handler = new Handler(this);
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        State.setState(gameState);
    }

    private void tick(){
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

        g.drawImage(backgroundtest, 0, 0, width, height, null);
//        if(State.getState() != null)
//            State.getState().render(g);

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
