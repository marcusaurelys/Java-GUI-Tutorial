package model;

import java.util.ArrayList;
import java.util.Arrays;

public class ShopModel {
    private ArrayList<Bread> breadOptions;
    private ArrayList<Meat> meatOptions;
    private ArrayList<Veggie> veggieOptions;
    private ArrayList<Sauce> sauceOptions;

    public ShopModel(){
        breadOptions = new ArrayList<Bread>(Arrays.asList(
            new Bread("Italian Bread", 30.00),
            new Bread("Wheat", 30.00),
            new Bread("Honey Oat", 45.00),
            new Bread("Parmesan Oregano", 50.00)
        ));

        meatOptions = new ArrayList<Meat>(Arrays.asList(
            new Meat("Tuna", 30.00),
            new Meat("Meatball Marinara", 40.00),
            new Meat("Chicken", 50.00),
            new Meat("Steak", 100.00)
        ));

        veggieOptions = new ArrayList<Veggie>(Arrays.asList(
            new Veggie("Lettuce", 5.00),
            new Veggie("Onions", 5.00),
            new Veggie("Tomatoes", 10.00),
            new Veggie("Pickles", 15.00),
            new Veggie("Jalapeno", 15.00),
            new Veggie("Cucumbers", 15.00)
            
        ));

        sauceOptions = new ArrayList<Sauce>(Arrays.asList(
            new Sauce("Mayo", 10.00),
            new Sauce("Ketchup", 15.00),
            new Sauce("BBQ Sauce", 20.00),
            new Sauce("Thousand Islands", 20.00),
            new Sauce("Honey Mustard", 20.00)
        ));
    }

    public ArrayList<Bread> getBreadOptions(){
        return breadOptions;
    }


    public ArrayList<Meat> getMeatOptions(){
        return meatOptions;
    }

    public ArrayList<Veggie> getVeggieOptions(){
        return veggieOptions;
    }

    public ArrayList<Sauce> getSauceOptions(){
        return sauceOptions;
    }

    public Sandwich createSandwich(){
        return new Sandwich();
    }

    public ArrayList<String> getBreadNames(){
        ArrayList<String> nameList = new ArrayList<>();
        for (Bread bread : breadOptions){
            nameList.add(bread.getName());
        }
        return nameList;
    }

    public ArrayList<String> getMeatNames(){
        ArrayList<String> nameList = new ArrayList<>();
        for (Meat meat : meatOptions){
            nameList.add(meat.getName());
        }
        return nameList;
    }

    public ArrayList<String> getVeggieNames(){
        ArrayList<String> nameList = new ArrayList<>();
        for (Veggie veggie : veggieOptions){
            nameList.add(veggie.getName());
        }
        return nameList;
    }

    public ArrayList<String> getSauceNames(){
        ArrayList<String> nameList = new ArrayList<>();
        for (Sauce sauce : sauceOptions){
            nameList.add(sauce.getName());
        }
        return nameList;
    }

    //returns Bread Object given bread Name
    public Bread getBread(String breadName){
        for(Bread bread : breadOptions){
            if(bread.getName().equals(breadName)){
                return bread;
            }
        }
        return null;
    }

    public Meat getMeat(String meatName){
        for(Meat meat : meatOptions){
            if(meat.getName().equals(meatName)){
                return meat;
            }
        }
        return null;
    }

    public Veggie getVeggie(String veggieName){
        for(Veggie veggie : veggieOptions){
            if(veggie.getName().equals(veggieName)){
                return veggie;
            }
        }
        return null;
    }

    public Sauce getSauce(String sauceName){
        for(Sauce sauce : sauceOptions){
            if(sauce.getName().equals(sauceName)){
                return sauce;
            }
        }
        return null;
    }
}
