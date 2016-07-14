/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Types;

import java.util.ArrayList;

/**
 *
 * @author Rubén Manzano
 */
public class Order {
    private int id;
    private ArrayList<Drink>drinks=new ArrayList<>();
    private ArrayList<Food>food= new ArrayList<>();
    
    public void addDrink(Drink d){
        drinks.add(d);
    }
    
    public void addFood(Food f){
        food.add(f);
    }
    
    public ArrayList<Drink> getDrinks(){
        return this.drinks;
    }
    
    public ArrayList<Food> getFoods(){
        return this.food;
    }
}
