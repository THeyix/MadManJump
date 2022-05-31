package Main;

import Main.Scenes.SceneManager;
import Main.entities.Wall;
import Main.input.KeyManager;
import Main.input.MouseManager;

public class Handler {

    private Game game;
    private SceneManager sceneManager;

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

    public SceneManager getSceneManager() {
        return sceneManager;
    }

}
