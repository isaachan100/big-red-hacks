import java.util.*;

public class Product {
    private String name;
    // product origin distance from store
    private double distance;
    // converts shipping method to a score 1-10 based on environmental impact
    private double shipping;
    private double price;

    // true if organic, false if not
    private boolean organic;

    // carbon-intensive growth methods, true if carbon-intensive false if not
    private boolean carbon;
    public Product(String n, double d, String s, double p, boolean o, boolean c) {
        name = n;
        distance = d;
        if(s.equals("plane")) shipping = 1.0;
        else if(s.equals("ship")) shipping = 3.0;
        else if(s.equals("truck")) shipping = 5.0;
        else shipping = 8.0; //train
        price = p;
        organic = o;
        carbon = c;
    }
    private double shippingScore() {
        double trans = (shipping * distance) / 1500;
        if (trans > 10.0) {
            trans = 10.0;
        }
        return Math.round(trans * 100.0) / 100.0;
    }
    public String getName() {
        return name;
    }
    public double getDistance() {
        return distance;
    }
    public double getShipping() {
        return shipping;
    }
    public double getPrice() {
        return price;
    }
    public boolean getOrganic() {
        return organic;
    }
    public boolean getCarbon() {
        return carbon;
    }

    private double relativeCost(double averageCost) {
        double percentError = Math.abs((price - averageCost)/averageCost);
        if (price > averageCost) {
            return 5.0 - Math.round((percentError * 10)*100.0)/100.0;
        }
        else {
            return 10.0 - Math.round((percentError * 10)*100.0)/100.0;
        }
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
