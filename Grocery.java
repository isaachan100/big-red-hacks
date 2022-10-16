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


        for (String keyword : keywords) {
            if (!productName.containsKey(keyword)) return false;
        }
        return true;
    }

    public Product bestProduct(String productName, User u, double averageCost) {
        List<Product> products = search(productName);
        Map<Double, Product> scores = new TreeMap<>();
        for (Product p: products) {
            scores.put(p.calculateScore(u, averageCost), p);
        }
        double bestScore = Collections.max(scores.keySet());
        return scores.get(bestScore);
    }

    public double storeScore(List<String> groceryList, User u, List<Double> costs) {
        double totalAverage = 0;
        for (int i = 0; i < groceryList.size(); i++) {
            String product = groceryList.get(i);
            double weightedAverage = 0;
            List<Product> products = search(product);
            List<Double> sortedProducts = new ArrayList<>();
            for (Product p : products) {
                sortedProducts.add(p.calculateScore(u, costs.get(i)));
            }
            Collections.sort(sortedProducts);
            double total = (sortedProducts.size() + 1) * (sortedProducts.size()) / 2.0;
            for (int j = 0; j < sortedProducts.size(); j++) {
                weightedAverage += sortedProducts.get(j) * (j + 1) / (total);
            }
            weightedAverage = Math.round(weightedAverage * 100.0)/100.0;
            totalAverage += weightedAverage;
        }
        return totalAverage / groceryList.size();
    }
}