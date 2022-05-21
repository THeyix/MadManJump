package Main.textures;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width=36, height=36;

    public static BufferedImage player, startButton, hoveredStartButton, optionsButton, hoveredOptionsButton, exitButton,hoveredExitButton, backGroundImage, backButton, hoveredBackButton;
    public static BufferedImage[] exit, start, options, back;

    public static void init(){

        exitButton = ImageLoader.loadImage("res/background/exButton.png");
        hoveredExitButton = ImageLoader.loadImage("res/background/hExButton.png");
        startButton = ImageLoader.loadImage("res/background/stButton.png");
        hoveredStartButton = ImageLoader.loadImage("res/background/hStButton.png");
        optionsButton = ImageLoader.loadImage("res/background/opButton.png");
        hoveredOptionsButton = ImageLoader.loadImage("res/background/hOpButton.png");
        backButton = ImageLoader.loadImage("res/background/bkButton.png");
        hoveredBackButton = ImageLoader.loadImage("res/background/hBkButton.png");

        exit = new BufferedImage[]{exitButton, hoveredExitButton};
        start = new BufferedImage[]{startButton, hoveredStartButton};
        options = new BufferedImage[]{optionsButton, hoveredOptionsButton};
        back = new BufferedImage[]{backButton, hoveredBackButton};

        backGroundImage = ImageLoader.loadImage("res/background/mainMenu_bg.png");
    }
}
