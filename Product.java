import java.util.*;

public class Product {
    private String name;
    // product origin distance from store
    private int distance;
    // converts shipping method to a score 1-10 based on environmental impact
    private double shipping;
    private double price;
    // average of customer ratings of the product, 1-5 stars
    private double rating;
    // true if organic, false if not
    private boolean organic;

    // carbon-intensive growth methods, true if carbon-intensive false if not
    private boolean carbon;
    public Product(String n, int d, String s, double p, double r, boolean o, boolean c) {
        name = n;
        distance = d;
        if(s.equals("plane")) shipping = 1.0;
        else if(s.equals("ship")) shipping = 3.0;
        else if(s.equals("truck")) shipping = 5.0;
        else shipping = 8.0; //train
        price = p;
        rating = r;
        organic = o;
        carbon = c;
    }
    private double shippingScore() {
        double trans = (shipping * distance) / 1500;
        if (trans > 10.0) {
            trans = 10.0;
        }
        return trans;
    }
    public String getName() {
        return name;
    }
    public int getDistance() {
        return distance;
    }
    public double getShipping() {
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
    public boolean carbon() {
        return carbon;
    }

    private double relativeCost(double averageCost) {
        double percentError = Math.abs((price - averageCost)/averageCost);
        return percentError * 10;
    }

    /**
     *
     * @return a list of scores, first index is transportation score, second index is carbon
     * score, third index is cost, fourth index is organic
     */
    public List<Double> scores(double averageCost) {
        List<Double> scores = new ArrayList<Double>();
        scores.add(this.shippingScore());

        if (carbon) scores.add(10.0);
        else scores.add(0.0);

        scores.add(this.relativeCost(averageCost));

        if (organic) scores.add(10.0);
        else scores.add(0.0);

        return scores;
    }
}
