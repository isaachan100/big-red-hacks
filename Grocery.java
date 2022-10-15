import java.util.*;
public class Grocery {

    private String name;
    private ArrayList<Product> products;
    private Point location;

    public Grocery(String name, Point location){
        this.name = name;
        this.location = location;
        products = new ArrayList<Product>();
    }

    public String getName(){
        return name;
    }

    public ArrayList<Product> getProducts(){
        return products;
    }

    public Point getLoc(){
        return location;
    }

    public void addProduct(Product a){
        products.add(a);
    }

    public ArrayList<Product> search(String a){
        return products;
    }

    /** helper method that returns true if a product matches a search */
    private boolean containsProduct(Product p, ) {

    }

}