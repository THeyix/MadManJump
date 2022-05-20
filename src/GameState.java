import java.awt.*;
import java.awt.image.BufferedImage;

public class GameState extends State{


    public GameState(Handler handler){
        super(handler);
        //player = new player();
    }

    @Override
    public void tick() {
        //player.tick();
    }

    @Override
    public void render(Graphics g) {
        //player.render();
        //g.drawImage(image, 0,0, width, height, null);
    }
}
