public class Product {
    private String name;
    // product origin distance from store
    private int distance;
    // converts shipping method to a score 1-10 based on environmental impact
    private int shipping;
    private double price;
    // average of customer ratings of the product, 1-5 stars
    private double rating;
    // 1 if organic, 0 if not
    private boolean organic;
    // how the product was made, factoring in number of ingredients/growth method
    private int creation;
    public Product(String n, int d, String s, double p, double r, boolean o) {
        name = n;
        distance = d;
        if(s.equals("plane")) shipping = 1;
        if(s.equals("ship")) shipping = 3;
        if(s.equals("truck")) shipping = 5;
        if(s.equals("train")) shipping = 8;
        price = p;
        rating = r;
        organic = o;

    }
    public double score() {
        int trans = shipping * distance;


        return 0;
    }
    public String getName() {
        return name;
    }
}
