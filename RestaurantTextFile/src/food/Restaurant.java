package food;

import exceptions.PersonalExceptions;
import Types.Food;
import Types.Order;
import Types.Drink;
import Types.Cuisines;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Rubén Manzano
 */
public class Restaurant {

    static ArrayList<Drink> drinks;
    static ArrayList<Food> foods;
    static ArrayList<Cuisines> cuisines;
    static ArrayList<Order> order=new ArrayList<>();
    
    
    /************************************* MAIN FUNCTION ****************************************/
    
    public static void main(String[] args) {
        int opt1;
        String opt;
        boolean exit=true;
        Scanner in=new Scanner(System.in);
        //load data
        drinks=LoadFunctions.loadDrink();
        cuisines=LoadFunctions.loadCuisin();
        foods=LoadFunctions.loadFood();
        //menu
        do{
            ShowFunctions.printMenu();
            opt=in.nextLine();
            try{
                opt1=Integer.parseInt(opt);
                switch(opt1){
                    case 1:
                        Order(true);
                        break;
                    case 2:
                        Order(false);
                        break;
                    case 3:
                        ShowFunctions.showOrder();
                        break;
                    case 4:
                        admin();
                        break;
                    case 5:
                        exit=false;
                        break;   
                    default:
                        System.err.println("Incorrect option.");
                }
            }catch (NumberFormatException nfe){
                System.err.println("Incorrect value.");
            }
        }while(exit);        
    }
    
    /************************************* ORDER ****************************************/
    
    /**
     * This fuction create a new order if add is true or add to a order if add is false
     * @param add check if the order is a new order or a existing order
     */

    private static void Order(boolean add){
        //save --> If there is any problem will be false and the order will not be saved
        //exit --> If there is a problem exits do while or if you choose to leave
        //first--> Show this if just one time, when I call this function from add to exist Order
        boolean exit=true,save=true,first=true;
        Order o=new Order();
        Scanner in=new Scanner(System.in);
        int number;
        do{
            number=0;
            if(!add&&first){
                System.out.println("Order number: ");
                System.out.print("-> ");
                number=in.nextInt();        
                first=false;
                if(Control.checkOrderExits(number)){
                    exit=true;
                }else{
                    System.err.println("The order "+number+" doesn't exits.");
                    exit=false;
                }
            }
            if(exit){
                System.out.println("\nUse numbers to choose a option:");
                System.out.println("1.- Order drink.");
                System.out.println("2.- Order lanch.");
                System.out.println("3.- Back.");
                System.out.print("-> ");
                int opt=in.nextInt();
                switch(opt){
                    case 1:
                        System.out.println("\nUse numbers to choose a option:");
                        if(ShowFunctions.showDrinks()==1){
                            System.out.print("-> ");
                            int optd=in.nextInt();
                            if(Control.checkDrinkNumber(optd)){
                                o.addDrink(drinks.get(optd));
                                save=true;
                            }else{
                                System.err.println("Incorrect option.");
                                save=false;
                            }   
                        }else{
                            save=false;
                        }
                        break;
                    case 2:
                        boolean check;
                        System.out.println("Use numbers to choose a option:");
                        if(ShowFunctions.showCuisines()==1){
                            System.out.print("-> ");
                            int optc=in.nextInt();
                            String cuisi=cuisines.get(optc).getName();
                            do{
                                check=false;
                                System.out.println("Main course:");
                                if(ShowFunctions.showFoods(cuisi,"main")==1){
                                    System.out.print("-> ");
                                    optc=in.nextInt();   
                                    if(!Control.checkOption(cuisi,optc,false)){
                                        check=true;
                                        System.err.println("Incorrect option.");
                                    }
                                }else{
                                    save=false;
                                }
                            }while(check);
                            o.addFood(foods.get(optc));
                            do{
                                check=false;
                                System.out.println("Dessert:");
                                if(ShowFunctions.showFoods(cuisi,"dessert")==1){
                                    System.out.print("-> ");
                                    optc=in.nextInt();
                                    if (!Control.checkOption(cuisi,optc,true)){
                                        check=true;
                                        System.err.println("Incorrect option.");
                                    }
                                }else{
                                    save=false;
                                }
                            }while(check);    
                            o.addFood(foods.get(optc));
                        }else{
                            save=false;
                        }
                        break;
                    case 3:
                        if(save){
                            if (add){
                                order.add(o);
                                System.err.println("Your order has been assigned the number: "+(order.size()-1));
                            }else {
                                Order tmp=new Order();
                                tmp=order.get(number);
                                for(int i=0;i<o.getDrinks().size();i++)
                                    tmp.addDrink(o.getDrinks().get(i));
                                for(int i=0;i<o.getFoods().size();i++)
                                    tmp.addFood(o.getFoods().get(i));
                                order.set(number, tmp);
                            }
                        }
                        exit=false;
                        break;
                    default:
                        System.err.println("Incorrect option.");
                }
            }
        }while(exit);
    }
    
    /************************************* ADMIN ****************************************/
    private static void admin(){
        Scanner in=new Scanner(System.in);
        boolean exit=true;
        do{
            ShowFunctions.showAdminMenu();
            int opt=in.nextInt();
            switch(opt){
                case 1:
                    Cuisines c=new Cuisines();
                    System.out.print("Name -> ");
                    c.setName(in.next());
                    AddFunctions.addCuisin(c);
                    cuisines=LoadFunctions.loadCuisin();
                    break;
                case 2:
                    Drink d=new Drink();
                    try{
                        in.skip("\n");
                        System.out.print("Name -> ");
                        d.setName(in.nextLine());
                        System.out.print("Price (use doc for decimals) -> ");
                        d.setPrice(Float.parseFloat(in.next()));
                        //d.setPrice(in.nextFloat()); 
                    }catch(Exception e){
                        System.err.println("Error: Incorrect format");
                        break;
                    }
                    AddFunctions.addDrink(d);
                    drinks=LoadFunctions.loadDrink();
                    break;
                case 3:
                    Food f=new Food();
                    try{
                        in.skip("\n");
                        System.out.print("Name -> ");
                        f.setName(in.nextLine());
                        System.out.print("Cousin -> ");
                        String aux=in.next().toLowerCase();
                        if(Control.checkCuisin(aux))
                            f.setCousin(aux);
                        else 
                            throw new PersonalExceptions.cuisinException();
                        System.out.print("Type (main/dessert) -> ");
                        String type=in.next().toLowerCase();
                        if(type.equals("main")||type.equals("dessert"))
                            f.setType(type);
                        else
                            throw new PersonalExceptions.typeException();
                        System.out.print("Price (use doc for decimals) -> ");
                        f.setPrice(Float.parseFloat(in.next()));
                        in.skip("\n");
                        System.out.print("Description -> ");
                        f.setDescription(in.nextLine());
                    }catch(PersonalExceptions.typeException e){
                        System.err.println("Error: Incorrect type");
                        break;
                    }catch(PersonalExceptions.cuisinException e){
                        System.err.println("Error: Incorrect cuisin");
                        break;
                    }
                    AddFunctions.addFood(f);
                    foods=LoadFunctions.loadFood();
                    break;
                case 4:
                    exit=false;
                    break;
            }
        }while(exit);
    }
}
