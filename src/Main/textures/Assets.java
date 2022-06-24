package Main.textures;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width=36, height=36;


    public static BufferedImage backgroundImage, optionsBackgroundImage, firstStageBackgroundImage, escBackgroundImage;
    public static BufferedImage startButton, hoveredStartButton, optionsButton, hoveredOptionsButton, exitButton,hoveredExitButton, backButton, hoveredBackButton, resumeButton, hoveredResumeButton, restartButton, hoveredRestartButton, settingsButton, hoveredSettingsButton, menuButton, hoveredMenuButton;
    public static BufferedImage[] exit, start, options, back, resume, settings, menu;
    public static BufferedImage player, crouchPlayer;
    public static BufferedImage[] jumpingAnimation;

    public static void init(){

        exitButton = ImageLoader.loadImage("res/buttonImage/exitButton.png");
        hoveredExitButton = ImageLoader.loadImage("res/buttonImage/hoveredExitButton.png");

        startButton = ImageLoader.loadImage("res/buttonImage/startButtonImage.png");
        hoveredStartButton = ImageLoader.loadImage("res/buttonImage/hoveredStartButtonImage.png");

        optionsButton = ImageLoader.loadImage("res/buttonImage/optionsButton.png");
        hoveredOptionsButton = ImageLoader.loadImage("res/buttonImage/hoveredOptionsButton.png");

        backButton = ImageLoader.loadImage("res/buttonImage/backButton.png");
        hoveredBackButton = ImageLoader.loadImage("res/buttonImage/hoveredBackButton.png");

        resumeButton = ImageLoader.loadImage("res/buttonImage/resumeButton.png");
        hoveredResumeButton = ImageLoader.loadImage("res/buttonImage/hoveredResumeButton.png");

        settingsButton = ImageLoader.loadImage("res/buttonImage/settingsButton.png");
        hoveredSettingsButton = ImageLoader.loadImage("res/buttonImage/hoveredSettingsButton.png");

        menuButton = ImageLoader.loadImage("res/buttonImage/menuButton.png");
        hoveredMenuButton = ImageLoader.loadImage("res/buttonImage/hoveredMenuButton.png");


        exit = new BufferedImage[]{exitButton, hoveredExitButton};
        start = new BufferedImage[]{startButton, hoveredStartButton};
        options = new BufferedImage[]{optionsButton, hoveredOptionsButton};
        back = new BufferedImage[]{backButton, hoveredBackButton};
        resume = new BufferedImage[]{resumeButton, hoveredResumeButton};
        settings = new BufferedImage[]{settingsButton, hoveredSettingsButton};
        menu = new BufferedImage[]{menuButton, hoveredMenuButton};

        backgroundImage = ImageLoader.loadImage("res/background/mainMenuImage.png");
        optionsBackgroundImage = ImageLoader.loadImage("res/background/optionsBackgroundImage.png");
        firstStageBackgroundImage = ImageLoader.loadImage("res/background/1_StageBG.png");
        escBackgroundImage = ImageLoader.loadImage("res/background/escBackgroundImage.png");

        player = ImageLoader.loadImage("res/playerModels/Stand.png");
//        crouchPlayer = ImageLoader.loadImage("res/playerModels/crouchPlayer.png");

        jumpingAnimation = new BufferedImage[]{player, crouchPlayer};



    }
}
