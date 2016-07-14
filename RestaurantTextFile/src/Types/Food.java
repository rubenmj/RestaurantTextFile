package Types;


/**
 *
 * @author Rubén Manzano
 */
public class Food {
    private String name, cousin, description, type;
    private float price;
    
    /*Setters*/
    public void setName (String name){
        this.name=name;
    }
    
    public void setCousin (String cousin){
        this.cousin=cousin;
    }
    
    public void setDescription (String description){
        this.description=description;
    }
    
    public void setType (String type){
        this.type=type;
    }
    
    public void setPrice (float price){
        this.price=price;
    }
    
    /*Getters*/
    public String getName(){
        return this.name;
    }
    
    public String getCousin(){
        return this.cousin;
    }
    
    public String getDescription (){
        return this.description;
    }
    
    public String getType (){
        return this.type;
    }
    
    public float getPrice(){
        return this.price;
    }
    
    @Override
    public String toString(){
        return this.getName()+"-"+this.getCousin().toLowerCase()+"-"+this.getDescription()
                +"-"+this.getType().toLowerCase()+"-"+this.getPrice();
    }
}
