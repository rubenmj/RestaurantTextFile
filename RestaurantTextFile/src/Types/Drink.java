package Types;

import food.*;

/**
 *
 * @author Rubén Manzano
 */
public class Drink {
    private String name;
    private float price;
    
    /*Setters*/
    public void setName (String name){
        this.name=name;
    }
    
    public void setPrice (float price){
        this.price=price;
    }
    
    /*Getters*/
    public String getName(){
        return this.name;
    }
    
    public float getPrice(){
        return this.price;
    }
    
    @Override
    public String toString(){
        return this.getName()+"-"+this.getPrice();
    }
}

