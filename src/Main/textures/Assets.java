package Main.textures;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width=36, height=36;


    public static BufferedImage backgroundImage, optionsBackgroundImage, firstStageBackgroundImage, escBackgroundImage;
    public static BufferedImage player, startButton, hoveredStartButton, optionsButton, hoveredOptionsButton, exitButton,hoveredExitButton, backButton, hoveredBackButton;
    public static BufferedImage[] exit, start, options, back;

    public static void init(){

        exitButton = ImageLoader.loadImage("res/buttonImage/exitButton.png");
        hoveredExitButton = ImageLoader.loadImage("res/buttonImage/hoveredExitButton.png");

        startButton = ImageLoader.loadImage("res/buttonImage/startButtonImage.png");
        hoveredStartButton = ImageLoader.loadImage("res/buttonImage/hoveredStartButtonImage.png");

        optionsButton = ImageLoader.loadImage("res/buttonImage/optionsButton.png");
        hoveredOptionsButton = ImageLoader.loadImage("res/buttonImage/hoveredOptionsButton.png");

        backButton = ImageLoader.loadImage("res/buttonImage/backButton.png");
        hoveredBackButton = ImageLoader.loadImage("res/buttonImage/hoveredBackButton.png");


        exit = new BufferedImage[]{exitButton, hoveredExitButton};
        start = new BufferedImage[]{startButton, hoveredStartButton};
        options = new BufferedImage[]{optionsButton, hoveredOptionsButton};
        back = new BufferedImage[]{backButton, hoveredBackButton};

        backgroundImage = ImageLoader.loadImage("res/background/mainMenuImage.png");
        optionsBackgroundImage = ImageLoader.loadImage("res/background/optionsBackgroundImage.png");
        firstStageBackgroundImage = ImageLoader.loadImage("res/background/mainMenu_bg.png");
        escBackgroundImage = ImageLoader.loadImage("res/background/escBackgroundImage.png");

        player = ImageLoader.loadImage("res/playerModels/mainPlayer.png");


    }
}
