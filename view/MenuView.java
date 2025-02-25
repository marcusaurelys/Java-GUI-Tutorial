package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class MenuView extends JPanel {

    private JButton orderButton, closeButton;
    
    public MenuView(){
        setBackground(Color.decode("#006400"));
        setLayout(new GridBagLayout());
        setSize(AppFrame.FULL_WIDTH, AppFrame.FULL_HEIGHT);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
    
        //Add title 
        JLabel title = new JLabel("Welcome to Subway!");
        title.setFont(new Font("Arial Unicode MS", Font.BOLD, 32));
        title.setForeground(Color.YELLOW);
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(title, gbc);


        //Add button to go to order view
        orderButton = new JButton("Make an order");
        orderButton.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
        gbc.gridy = 1;
        add(orderButton, gbc);

        closeButton = new JButton("Close Program");
        closeButton.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
        gbc.gridy = 2;
        add(closeButton, gbc);
    }

    public void setOrderButtonAction(ActionListener a){
        orderButton.addActionListener(a);
    }

    public void setCloseButtonAction(ActionListener a){
        closeButton.addActionListener(a);
    }
}

