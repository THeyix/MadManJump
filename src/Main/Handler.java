package Main;

import Main.imput.KeyManager;
import Main.imput.MouseManager;

public class Handler {

    private Game game;
    //private World world;

    public Handler(Game game){
        this.game = game;

    }

    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }

    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHeight();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
