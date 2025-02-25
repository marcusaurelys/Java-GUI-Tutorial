package view;

import javax.swing.*;



public class AppFrame extends JFrame {

    static int FULL_HEIGHT = 600;
    static int FULL_WIDTH = 800;

    public AppFrame(){
        setTitle("Subway Ordering System");
        setResizable(false);
        setSize(FULL_WIDTH, FULL_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
