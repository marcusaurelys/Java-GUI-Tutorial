package model;

import java.util.ArrayList;
import java.util.Arrays;

public class ShopModel {
    private ArrayList<Bread> breadOptions;
    private ArrayList<Meat> meatOptions;
    private ArrayList<Veggie> veggieOptions;
    private ArrayList<Sauce> sauceOptions;

    public ShopModel(){

        //TODO: Instantiate breadOptions, meatOptions, veggieOptions, sauceOptions
        breadOptions = new ArrayList<Bread>(Arrays.asList(

        ));

        meatOptions = new ArrayList<Meat>(Arrays.asList(

        ));

        veggieOptions = new ArrayList<Veggie>(Arrays.asList(

            
        ));

        sauceOptions = new ArrayList<Sauce>(Arrays.asList(

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
