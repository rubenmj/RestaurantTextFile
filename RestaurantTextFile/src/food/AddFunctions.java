/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import Types.Cuisines;
import Types.Drink;
import Types.Food;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Rubén Manzano
 */
public class AddFunctions {
    /************************************* AAD FUNCTIONS ****************************************/
    /**
     * Write in cuisin file a new cuisin
     * @param c --> cuisin object to add to file
     */
    public static void addCuisin(Cuisines c){
        FileWriter file = null;
        PrintWriter pw = null;
        try{
            file = new FileWriter("TextFiles/cuisine.txt",true);
            pw = new PrintWriter(file);
            pw.println(c.getName().toLowerCase());
        }catch(IOException e){
            System.err.println("Error: The cuisin file could not been read");
        }finally{
            try {
                if (null != file)
                    file.close();
           } catch (IOException e2) { }
        }
    }
    
    /**
     * Write in drink file a new drink
     * @param d --> drink object to add to file
     */
    public static void addDrink(Drink d){
        FileWriter file = null;
        PrintWriter pw = null;
        try{
            file = new FileWriter("TextFiles/drink.txt",true);
            pw = new PrintWriter(file);
            pw.println(d.toString());
        }catch(IOException e){
            System.err.println("Error: The drink file could not been read");
        }finally{
            try {
                if (null != file)
                    file.close();
           } catch (IOException e2) { }
        }
    }
    
    /**
     * Write in food file a new food
     * @param f --> Food object to add to file
     */
    public static void addFood(Food f){
        FileWriter file = null;
        PrintWriter pw;
        try{
            file = new FileWriter("TextFiles/food.txt",true);
            pw = new PrintWriter(file);
            pw.println(f.toString());
        }catch(IOException e){
            System.err.println("Error: The food file could not been read");
        }finally{
            try {
                if (null != file)
                    file.close();
           } catch (IOException e2) { }
        }
    }
}
