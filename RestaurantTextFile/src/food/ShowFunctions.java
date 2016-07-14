/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;


import static food.Restaurant.order;
import static food.Restaurant.drinks;
import static food.Restaurant.foods;
import static food.Restaurant.cuisines;
import java.util.Scanner;

/**
 *
 * @author Rubén Manzano
 */
public class ShowFunctions {
        /************************************* MENU ****************************************/
    /**
     * Show principal menu
     */
    public static void printMenu(){
        try{
            Thread.sleep(100);
        }catch(Exception e){}
        System.out.println("Use numbers to choose a option:");
        System.out.println("1.- New Order.");
        System.out.println("2.- Add to exist Order.");
        System.out.println("3.- Show Order.");
        System.out.println("4.- Administration.");
        System.out.println("5.- Exit.");
        System.out.print("-> ");
    }
    
    /**
     * Show admin menu
     */
    public static void showAdminMenu(){
        System.out.println("\nUse numbers to choose a option:");
        System.out.println("1.- Add cuisin.");
        System.out.println("2.- Add drink.");
        System.out.println("3.- Add food.");
        System.out.println("4.- Back.");
        System.out.print("-> ");
    }
    
    /************************************* SHOW FUNCTIONS ****************************************/
    
    /**
     * Show all cuisines
     * @return 1 it it show some cuisine
     */
    public static int showCuisines(){
        int check=0;
        for(int i=0;i<cuisines.size();i++){
            System.out.println(i+".-"+cuisines.get(i).getName());
            check=1;
        }
        if(check==0)
            System.out.println("There are not food in this category");
        return check;
    }
    
    /**
     * Show all drinks
     * @return 1 it it show some drink
     */
    public static int showDrinks(){
        int check=0;
        for(int i=0;i<drinks.size();i++){
            System.out.println(i+".-"+drinks.get(i).getName()+" --> "+drinks.get(i).getPrice());
            check=1;
        }
        if(check==0)
            System.out.println("There are not food in this category");
        return check;
    }
    
    /**
     * Show all foods
     * @return 1 if this function show some register
     */
    public static int showFoods(){
        int check=0;
        for(int i=0;i<foods.size();i++){
            System.out.println(i+".-"+foods.get(i).getName()+" --> "+foods.get(i).getDescription()+" --> "+foods.get(i).getType()+" --> "+foods.get(i).getPrice());
            check=1;
        }
        if(check==0)
            System.out.println("There are not food in this category");
        return check;
    }
    
    /**
     * Show all foods from a cuisin
     * @param cuisin for show
     * @return 1 it it show some food
     */
    public static int showFoods(String cuisin){
        int check=0;
        for(int i=0;i<foods.size();i++){
            if(foods.get(i).getCousin().toLowerCase().equals(cuisin.toLowerCase())){
                System.out.println(i+".-"+foods.get(i).getName()+" --> "+foods.get(i).getDescription()+" --> "+foods.get(i).getType()+" --> "+foods.get(i).getPrice());
                check=1;
            }
        }
        if(check==0)
            System.out.println("There are not food in this category");
        return check;
    }
    
    /**
     * Show all foods from a cuisin and type (main or dessert)
     * @param cuisin for show
     * @param type for show
     * @return 1 it it show some food
     */
    public static int showFoods(String cuisin, String type){
        int check=0;
        for(int i=0;i<foods.size();i++){
            if(foods.get(i).getCousin().toLowerCase().equals(cuisin.toLowerCase())
                    && foods.get(i).getType().toLowerCase().equals(type)){
                System.out.println(i+".-"+foods.get(i).getName()+" --> "+foods.get(i).getDescription()+" --> "+foods.get(i).getPrice());
                check=1;
            }
        }
        if(check==0)
            System.out.println("There are not food in this category");
        return check;
    }
    
    /**
     * Show one order
     */
    public static void showOrder(){
        Scanner in=new Scanner(System.in);
        float total=0;
        System.out.println("Order number: ");
        System.out.print("-> ");
        int number=in.nextInt();
        if(Control.checkOrderExits(number)){
            System.out.println("\n****************************************** ");
            try{
                Thread.sleep(10);
            }catch(Exception e){}
            System.err.println("Drinks: ");
            for(int i=0;i<order.get(number).getDrinks().size();i++){
                System.out.println(order.get(number).getDrinks().get(i).getName()+" -> "+
                        order.get(number).getDrinks().get(i).getPrice());
                total=total+order.get(number).getDrinks().get(i).getPrice();
            }
            try{
                Thread.sleep(10);
            }catch(Exception e){}
            System.err.println("Foods: ");
            for(int i=0;i<order.get(number).getFoods().size();i++){
                System.out.println(order.get(number).getFoods().get(i).getName()+" -> "+
                        order.get(number).getFoods().get(i).getPrice());
                total=total+order.get(number).getFoods().get(i).getPrice();
            }
            try{
                Thread.sleep(10);
            }catch(Exception e){}
            System.out.println("------------------------------------------ ");
            System.err.println(" TOTAL:                        "+total);
            System.out.println("\n****************************************** ");
        }else{
            System.err.println("The order "+number+" doesn't exits.");
        }
    }
    

}
