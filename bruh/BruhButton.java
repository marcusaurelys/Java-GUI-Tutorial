import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.*;

public class BruhButton {
    public static void main(String[] args) {
        // Create the JFrame
        JFrame frame = new JFrame("Bruh Button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 750);
        frame.setLayout(new BorderLayout());


        
        // Create the button
        JLabel label = new JLabel("Bruh...");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        JButton button = new JButton();
        Image img = Toolkit.getDefaultToolkit().getImage("bruh-meme.gif").getScaledInstance(100, 100, 0);
        
        button.setIcon(new ImageIcon(img));
        frame.add(label, BorderLayout.NORTH);
        frame.add(button, BorderLayout.WEST);

        // Add action listener to play sound on button press
        button.addActionListener(e -> playSound("bruh.wav"));

        // Show the window
        
         
        frame.setVisible(true);
    }

    private static void playSound(String soundFile) {
        try {
            File file = new File(soundFile);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
