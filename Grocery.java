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

    public List<Product> search(String search){
        List<Product> matchingProducts = new ArrayList<>();
        for (Product p : products) {
            if (containsProduct(p, search)) matchingProducts.add(p);
        }
        return matchingProducts;
    }

    /** helper method that returns true if a product matches a search */
    private boolean containsProduct(Product p, String search) {
        String[] split = search.split(" ");
        List<String> keywords = new ArrayList<>();
        for (String s : split) {
            keywords.add(s.toLowerCase());
        }

        String[] productSplit = p.getName().split(" ");
        HashMap<String, Integer> productName = new HashMap<>();
        for (String s : productSplit) {
            productName.put(s.toLowerCase(), 0);
        }

        System.out.println(keywords);
        System.out.println(productName.keySet());
        for (String keyword : keywords) {
            if (!productName.containsKey(keyword)) return false;
        }
        return true;
    }

}