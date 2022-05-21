package Main.display;

import java.awt.*;
import javax.swing.JFrame;

public class Display {

    private JFrame frame;
    private Canvas canvas;
    private String title;
    public int width, height;

    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }

    private void createDisplay(){
        frame = new JFrame(title);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//if there is error (alt+f4) and program will shut down
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setVisible(true);

        canvas = new Canvas();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        canvas.setPreferredSize(new Dimension(screenSize.width, screenSize.height));
        canvas.setMaximumSize(new Dimension(screenSize.width, screenSize.height));
        canvas.setMinimumSize(new Dimension(screenSize.width, screenSize.height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas(){
        return canvas;
    }

    public JFrame getFrame(){
        return frame;
    }
}