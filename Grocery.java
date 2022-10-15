import java.util.*;
public class Grocery{

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

    public double storeScore(List<String> groceryList, User u, double averageCost) {
        double totalAverage = 0;
        for (String product : groceryList) {
            double weightedAverage = 0;
            List<Product> products = search(product);
            Map<Double, Product> sortedProducts = new TreeMap<>();
            for (Product p : products) {
                sortedProducts.put(p.calculateScore(u, averageCost), p);
            }
            int i = 1;
            double total = (1.0 + i)*(sortedProducts.size())/2;
            for (double k : sortedProducts.keySet()) {
                Product p = sortedProducts.get(k);
                weightedAverage += k * i / total;
            }
            totalAverage += weightedAverage;
        }
        return totalAverage;
    }
}