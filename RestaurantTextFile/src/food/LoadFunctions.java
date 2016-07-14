/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import Types.Cuisines;
import Types.Drink;
import Types.Food;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Rubén Manzano
 */
public class LoadFunctions {
    private static File file = null;
    private static FileReader fr = null;
    private static BufferedReader br = null;
    private static ArrayList<Drink> drinks;
    private static ArrayList<Food> foods;
    private static ArrayList<Cuisines> cuisines;
    /************************************* LOAD FUNCTIONS ****************************************/
    
    /**
     * Load all cuisines from cuisin file
     * @return ArrayList with all cuisines
     */
    public static ArrayList<Cuisines> loadCuisin(){
        cuisines =new ArrayList<>();
        try{
            file = new File ("TextFiles/cuisine.txt");
            fr = new FileReader (file);
            br = new BufferedReader(fr);
            Cuisines c;
            
            String line;
            while((line=br.readLine())!=null){
                c=new Cuisines();
                c.setName(line);
                cuisines.add(c);
            }    
        }catch (IOException e){
            System.err.println("Error: The cuisin file could not been read");
        }finally{
            try{                    
                if( null != fr ){   
                   fr.close();     
                }                  
            }catch (IOException e){ 
            }
        } 
        return cuisines;
    }
    
    /**
     * Load all drinks from drink file
     * @return ArrayList with all drinks
     */
    public static ArrayList<Drink> loadDrink(){
        drinks =new ArrayList<>();
        try{
            file = new File ("TextFiles/drink.txt");
            fr = new FileReader (file);
            br = new BufferedReader(fr);
            Drink d;
            
            String line;
            while((line=br.readLine())!=null){
                d=new Drink();
                String[]parts = line.split("-");
                d.setName(parts[0]);
                d.setPrice(Float.parseFloat(parts[1]));
                drinks.add(d);
            }    
        }catch (IOException e){
            System.err.println("Error: The drink file could not been read");
        }finally{
            try{                    
                if( null != fr ){   
                   fr.close();     
                }                  
            }catch (IOException e){ 
            }
        } 
        return drinks;
    }
    
    /**
     * Load all foods from food file
     * @return ArrayList with all foods
     */
    public static ArrayList<Food> loadFood(){
        foods =new ArrayList<>();
        try{
            file = new File ("TextFiles/food.txt");
            fr = new FileReader (file);
            br = new BufferedReader(fr);
            Food f;
            
            String line;
            while((line=br.readLine())!=null){
                f=new Food();
                String[]parts = line.split("-");
                f.setName(parts[0]);
                f.setCousin(parts[1]);
                f.setDescription(parts[2]);
                f.setType(parts[3]);
                f.setPrice(Float.parseFloat(parts[4]));
                foods.add(f);
            }    
        }catch (IOException e){
            System.err.println("Error: The food file could not been read");
        }finally{
            try{                    
                if( null != fr ){   
                   fr.close();     
                }                  
            }catch (IOException e){ 
            }
        } 
        return foods;
    }
}
