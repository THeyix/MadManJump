import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame implements ActionListener {

        JFrame frame;
        JButton exitButton, optionButton, startButton;
        JPanel panel;
        Frame() {
            frame = new JFrame("MadMan Jump");
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setUndecorated(true);
            frame.setVisible(true);
            frame.setLayout(null);

            exitButton = new JButton("Exit");
            exitButton.addActionListener(this);
            exitButton.setFocusable(false);
            startButton = new JButton("Start");
            startButton.addActionListener(this);
            startButton.setFocusable(false);
            optionButton = new JButton("Options");
            optionButton.addActionListener(this);
            optionButton.setFocusable(false);


            panel = new JPanel();
            panel.setLayout(null);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            panel.setBounds(0, 0, screenSize.width, screenSize.height);
            exitButton.setBounds(screenSize.width/2+210, screenSize.height/2+80, 80,40);
            startButton.setBounds(screenSize.width/2-50, screenSize.height/2-20, 100,40);
            optionButton.setBounds(screenSize.width/2-250, screenSize.height/2+80, 80,40);

            panel.add(exitButton);
            panel.add(startButton);
            panel.add(optionButton);


            frame.add(panel);
            frame.setVisible(true);
        }
        public void paint(Graphics g){
            Toolkit t = Toolkit.getDefaultToolkit();
            Image i = t.getImage("Zivilespixeliai.png");
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            g.drawImage(i, screenSize.width, screenSize.height,this);//Tomo uzduotis
        }
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == exitButton) {
                System.exit(0);
            }
    }

}