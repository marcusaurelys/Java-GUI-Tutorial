package model;
abstract class Ingridient {
    private String name;
    private double price;

    Ingridient(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }



}








