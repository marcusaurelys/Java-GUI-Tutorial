package model;
abstract class Ingridient {
    private String name;
    private double price;

    Ingridient(String name, double price){
        this.name = name;
        this.price = price;
    }

    String getName(){
        return name;
    }

    double getPrice(){
        return price;
    }



}

class Bread extends Ingridient {
    public Bread(String name, double price){
        super(name, price);
    }
}

class Meat extends Ingridient {
    public Meat(String name, double price){
        super(name, price);
    }
}

class Veggie extends Ingridient {
    public Veggie(String name, double price){
        super(name, price);
    }
}

class Sauce extends Ingridient {
    public Sauce(String name, double price){
        super(name, price);
    }
}

