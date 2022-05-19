import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//public class Options implements ActionListener {
//    //TODO optionai kazkokie
//
//    JPanel panel;
//    JButton backButton;
//    Options() {
//
//        panel.setLayout(null);
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        panel.setBounds(0, 0, screenSize.width, screenSize.height);
//        backButton.setBounds(screenSize.width / 2 + 210, screenSize.height / 2 + 80, 320, 80);
//
//    ImageIcon background = new ImageIcon("Images/mainMenu_bg.png");
//    Image image = background.getImage();
//    Image scaledimage = image.getScaledInstance(screenSize.width, screenSize.height, java.awt.Image.SCALE_SMOOTH);
//    background = new ImageIcon(scaledimage);
//    JLabel backgroundLabel = new JLabel(background);
//    backgroundLabel.setBounds(0, 0, screenSize.width, screenSize.height);
//
//        panel.add(backButton);
//    panel.add(backgroundLabel);
//    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//        if (e.getSource() == backButton) {
//            new Frame();
//        }
//    }
//}
