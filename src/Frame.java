import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.OpenType;

public class Frame implements ActionListener {

        //JFrame frame;
        JButton exitButton, optionButton, startButton;
        JPanel panel;
        Font myFont = new Font("Times New Roman",Font.BOLD,50);

        Frame() {
//            frame = new JFrame("MadMan Jump");
//            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//            frame.setUndecorated(true);
//            frame.setLayout(null);

            Icon icon = new ImageIcon("Images/Test.png");//tas random exitas

            exitButton = new JButton(icon);
            exitButton.setFont(myFont);
            //exitButton.setForeground(Color.YELLOW);
            exitButton.setContentAreaFilled(false);
            exitButton.setBorderPainted(false);
            exitButton.addActionListener(this);
            exitButton.setFocusable(false);

            startButton = new JButton("START");
            startButton.setFont(myFont);
            startButton.setForeground(Color.YELLOW);
            startButton.setContentAreaFilled(false);
            startButton.setBorderPainted(false);
            startButton.addActionListener(this);
            startButton.setFocusable(false);

            optionButton = new JButton("OPTIONS");
            optionButton.setFont(myFont);
            optionButton.setForeground(Color.YELLOW);
            optionButton.setContentAreaFilled(false);
            optionButton.setBorderPainted(false);
            optionButton.addActionListener(this);
            optionButton.setFocusable(false);

            panel = new JPanel();

            panel.setLayout(null);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            panel.setBounds(0, 0, screenSize.width, screenSize.height);
            exitButton.setBounds(screenSize.width/2+210, screenSize.height/2+80, 320,80);
            startButton.setBounds(screenSize.width/2-50, screenSize.height/2-20, 400,80);
            optionButton.setBounds(screenSize.width/2-250, screenSize.height/2+80, 320,80);


            ImageIcon background = new ImageIcon("Images/mainMenu_bg.png");
            Image image = background.getImage();
            Image scaledimage = image.getScaledInstance(screenSize.width, screenSize.height, java.awt.Image.SCALE_SMOOTH);
            background = new ImageIcon(scaledimage);
            JLabel backgroundLabel = new JLabel(background);
            backgroundLabel.setBounds(0, 0, screenSize.width, screenSize.height);


            panel.add(exitButton);
            panel.add(startButton);
            panel.add(optionButton);
            panel.add(backgroundLabel);

            //frame.add(panel); //============================================== neturim

            //frame.setVisible(true);

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == exitButton) {
                System.exit(0);
            }

            if (e.getSource() == startButton) {
                //new GameStart();
            }
            if (e.getSource() == optionButton) {
                //new Options();
            }
    }

}