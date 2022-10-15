public class Product {
    private String name;
    private int distance;
    //converts shipping method to a score based on carbon emissions
    private int shipping;
    private double price;
    private int quality;
    private boolean organic;
    public Product(String n, int d, String s, double p, int q, boolean o) {
        name = n;
        distance = d;
        shipping = s;
        price = p;
        quality = q;
        organic = o;

    }
    public double score() {

    }
    public String getName() {
        return name;
    }
}
