import javax.swing.SwingUtilities;

import controller.*;
import view.*;

public class Main {
    public static void main(String[] args){
        
        SwingUtilities.invokeLater(() -> {
            AppFrame frame = new AppFrame();
            new MenuController(frame);
            frame.setVisible(true);
        });

    }
}
