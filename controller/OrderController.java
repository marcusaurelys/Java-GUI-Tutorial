package controller;

import model.*;
import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrderController {
    private ShopModel model = new ShopModel();
    private Sandwich sandwich;
    private AppFrame frame;
    private OrderView view;

    public OrderController(AppFrame frame){

        //instantiate the view and change frame.
        this.frame = frame;
        this.view = new OrderView(
            model.getBreadNames(), 
            model.getMeatNames(), 
            model.getVeggieNames(), 
            model.getSauceNames()
            );
        frame.setContentPane(view);
        frame.setVisible(true);

        //Instantiate a sandwich
        sandwich = model.createSandwich();


        //TODO: SET Action Listener
        view.setBackButtonAction(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

            }        
        });

        //TODO: SET ActionListener
        view.setNameInputAction(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

            }
        });
        
        setMeatActions();
        setVeggieActions();
        setSauceActions();

        view.setConfirmButtonAction(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                sandwich.addBread(model.getBread(view.getBreadName()));
                new ReceiptView(sandwich);
                goToMenu();
            }
        });


    }
   
    private void goToMenu(){
        new MenuController(frame);
    }

    private void setMeatActions(){
        ArrayList<ActionListener> meatActions = new ArrayList<>();
        for(String meat: model.getMeatNames()){
            meatActions.add(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    sandwich.addMeat(model.getMeat(meat));
                    view.setMeatChoice(meat);
                    
                }
            });
        }
        view.setMeatActions(meatActions);
    }


    //TODO: Complete the function
    private void setVeggieActions(){

    }

    //TODO: Complete the Function.
    private void setSauceActions(){

    }


}
