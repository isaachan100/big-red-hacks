public class Product {
    private String name;
    // product origin distance from store
    private int distance;
    // converts shipping method to a score 1-10 based on environmental impact
    private int shipping;
    private double price;
    // average of customer ratings of the product, 1-5 stars
    private double rating;
    // true if organic, false if not
    private boolean organic;
    // how the product was made, factoring in number of ingredient
    private int creation;
    // carbon-intensive growth methods, true if carbon-intensive false if not
    private boolean carbon;
    public Product(String n, int d, String s, double p, double r, boolean o, boolean c) {
        name = n;
        distance = d;
        if(s.equals("plane")) shipping = 1;
        else if(s.equals("ship")) shipping = 3;
        else if(s.equals("truck")) shipping = 5;
        else shipping = 8; //train
        price = p;
        rating = r;
        organic = o;
        carbon = c;
        creation = 0; //fix
    }
    public double score() {
        double trans = (double)shipping * distance /5;


        // return (price*100)-trans+rating+organic+creation;
        return 0;
    }
    public String getName() {
        return name;
    }
    public int getDistance() {
        return distance;
    }
    public int getShipping() {
        return shipping;
    }
    public double getPrice() {
        return price;
    }
    public double getRating() {
        return rating;
    }
    public boolean getOrganic() {
        return organic;
    }
    public int getCreation() {
        return creation;
    }
}
