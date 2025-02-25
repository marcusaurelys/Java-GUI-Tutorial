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

        //create a sandwich
        sandwich = model.createSandwich();


        //instantiate actionListeners
        view.setBackButtonAction(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                goToMenu();
            }        
        });

        view.setNameInputAction(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                sandwich.setCustomerName(view.getCustomerName());
                view.setNameLabel(sandwich.getCustomerName());
            }
        });
        setMeatActions();
        setVeggieActions();
        setSauceActions();

        view.setConfirmButtonAction(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                sandwich.addBread(model.getBread(view.getBreadName()));
                view.setCurTotal(sandwich.getPrice());
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

    private void setVeggieActions(){
        ArrayList<ActionListener> veggieActions = new ArrayList<>();
        for(String veggie: model.getVeggieNames()){
            veggieActions.add(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    sandwich.addVeggie(model.getVeggie(veggie));
                    view.setVeggieChoice(sandwich.getVeggieNames());
                }
            });
        }
        view.setVeggieActions(veggieActions);
    }

    private void setSauceActions(){
        ArrayList<ActionListener> sauceActions = new ArrayList<>();
        for(String sauce: model.getSauceNames()){
            sauceActions.add(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    sandwich.addSauce(model.getSauce(sauce));
                    view.setSauceChoice(sandwich.getSauceNames());
                }
            });
        }
        view.setSauceActions(sauceActions);
    }


}
