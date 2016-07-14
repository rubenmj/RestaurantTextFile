/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import static food.Restaurant.cuisines;
import static food.Restaurant.order;
import static food.Restaurant.foods;
import static food.Restaurant.drinks;

/**
 *
 * @author Rubén Manzano
 */
public class Control {
        /************************************* CONTROL ****************************************/
    /**
     * This function check if the cuisin exits
     * @param cuis cuisin
     * @return true if it exists or false if it doesn't exits
     */
    public static boolean checkCuisin(String cuis){
        boolean check=false;
        for(int i=0;i<cuisines.size();i++){
            if(cuisines.get(i).getName().equalsIgnoreCase(cuis))
                check=true;
        } 
        return check;
    }
    /**
     * This function checks if the selected dish is correct according to the user selection
     * @param cuis selected cuisine
     * @param opt selected number
     * @param dess dessert(true) or main course(false)
     * @return 
     */
    public static boolean checkOption(String cuis,int opt, boolean dess){
        if(opt>foods.size())
            return false;
        else if(foods.get(opt).getType().equals("main")&&dess)
            return false;
        else if(foods.get(opt).getType().equals("dessert")&&!dess)
            return false;
        else return foods.get(opt).getCousin().equals(cuis);
    }
    
    /**
     * This function check a correct number order
     * @param o order number
     * @return true if it is correct
     */
    public static boolean checkOrderExits(int o){
        if(order.size() > o && o>=0)
            return true;
        return false;
    }
    
    public static boolean checkDrinkNumber(int d){
        if(drinks.size() > d&&d>=0)
            return true;
        return false;
    }
}
