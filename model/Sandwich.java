package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Sandwich {

    private String customerName;
    private Bread bread;
    private Meat meat;
    private ArrayList<Veggie> veggies = new ArrayList<>();
    private ArrayList<Sauce> sauces = new ArrayList<>();

    public Sandwich(String customerName){
        this.customerName = customerName;
    }

    public void addBread(Bread bread) {
        this.bread = bread;
    }

    public void addMeat(Meat meat){
        this.meat = meat;
    }

    public void addVeggie(Veggie veggie){
        veggies.add(veggie);
    }

    public void addSauce(Sauce sauce){
        sauces.add(sauce);
    }
     
    public double getPrice(){
        double breadPrice = bread.getPrice();
        double meatPrice = meat.getPrice();
        double veggiePrice = 0;
        for(Veggie veggie : veggies){
            veggiePrice += veggie.getPrice();
        }
        double saucePrice = 0;
        for(Sauce sauce : sauces){
            saucePrice += sauce.getPrice();
        }
        return breadPrice + meatPrice + veggiePrice + saucePrice;
    }

    public static void delay(int milliseconds) {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < milliseconds) {
            // Busy-wait loop
        }
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Subway!\n\n");

        System.out.println("What is your name?");
        String name = sc.nextLine();

        Sandwich order = new Sandwich(name);

        System.out.println("Pick a bread! \n [1] Italian Bread \t\t P30.00 \n [2] Honey Oat \t\t\t P45.00 \n [3] Herbs and Cheese \t\t P50.00");
        int choice = sc.nextInt();
        switch(choice) {
            case 1 -> order.addBread(new Bread("Italian Bread", 30.00));
            case 2 -> order.addBread(new Bread("Honey Oat", 45.00));
            default -> order.addBread(new Bread("Herbs and Cheese", 50.00));
        }

        System.out.println("Pick a meat! \n [1] Tuna \t\t 30.00 \n [2] Meatball Marinara \t 40.00 \n [3] Chicken \t\t 50.00 \n [4] Steak \t\t 100.00");
        choice = sc.nextInt();
        switch(choice){
            case 1 -> order.addMeat(new Meat("Tuna", 30.00));
            case 2 -> order.addMeat(new Meat("Meatball Marinara", 40.00));
            case 3 -> order.addMeat(new Meat("Chicken", 50.00));
            default -> order.addMeat(new Meat("Steak", 100.00));
        }

        for(int i = 0; i < 3; i++){
            System.out.println("Add a veggie! \n [1] Lettuce \t 5.00 \n [2] Tomatoes \t 10.00 \n [3] Pickles \t 15.00 \n [4] Stop");
            choice = sc.nextInt();
            switch(choice){
                case 1 -> order.addVeggie(new Veggie("Lettuce", 5.00));
                case 2 -> order.addVeggie(new Veggie("Tomatoes", 10.00));
                case 3 -> order.addVeggie(new Veggie("Pickles", 15.00));
                default -> i = 5;
            }
        }

        for(int i = 0; i < 3; i++){
            System.out.println("Add a sauce! \n [1] Ranch \t 10.00 \n [2] Honey Mustard \t 15.00 \n [3] BBQ Sauce \t 20.00 \n [4] Stop");
            choice = sc.nextInt();
            switch(choice){
                case 1 -> order.addSauce(new Sauce("Mayo", 10.00));
                case 2 -> order.addSauce(new Sauce("Ketchup", 15.00));
                case 3 -> order.addSauce(new Sauce("BBQ Sauce", 20.00));
                default -> i = 5;
            }
        }

        clearConsole();

        System.out.println("Toasting bread...");
        delay(1000);
        System.out.println("Grilling meat...");
        delay(1000);
        System.out.println("Chopping veggies...");
        delay(1000);
        System.out.println("Drizzling sauces...");
        delay(1000);

        System.out.println("\n\nYour Subway Sandwich is ready! " + order.customerName);
        System.out.println("Bread: " + order.bread.getName() + ", \t\t\t\t" + order.bread.getPrice());
        System.out.println("Meat: " + order.meat.getName() + ", \t\t\t\t" + order.meat.getPrice());
        for(Veggie veggie : order.veggies){
            System.out.println("Veggie: " + veggie.getName() + ", \t\t\t\t" + veggie.getPrice());
        }
        for(Sauce sauce : order.sauces){
            System.out.println("Sauce: " + sauce.getName() + ", \t\t\t\t" + sauce.getPrice());
        }
        System.out.println("Total Price: \t\t\t\t" + order.getPrice());


        sc.close();

    }

}