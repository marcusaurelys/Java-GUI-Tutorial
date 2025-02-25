package controller;

import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuController {
    private AppFrame frame;
    private MenuView view = new MenuView();

    public MenuController(AppFrame frame){
        this.frame = frame;
        frame.setContentPane(view);
        frame.repaint();
        frame.revalidate();

        view.setOrderButtonAction(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                goToOrder();
            }
        });

        view.setCloseButtonAction(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                System.exit(0);
            }
        });
    }

    public void goToOrder(){
        new OrderController(frame);
    }
}
