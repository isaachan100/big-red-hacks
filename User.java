import java.util.*;
public class User {

    /** list of integers for each user's preferences */
    private Map<String, Double> preferences;

    /** String containing the username of the user
     * requires: username cannot be empty
     */
    private String username;

    /** list of previous transaction data */
    private List<Product> transactions;

    /** creates a user with username name and default preferences (weighted toward green) */
    public User (String name) {
        username = name;
        preferences = new HashMap<>();
        preferences.put("Transportation", 0.3);
        preferences.put("Creation", 0.3);
        preferences.put("Cost", 0.2);
        preferences.put("Organic", 0.2);
        transactions = new ArrayList<Product>();
    }

    /** returns the username of the person */
    public String username() {
        return username;
    }

    /** returns a list of preferences, where the first index corresponds to transportation
     * score, second index corresponds to how it was made, third index corresponds to cost,
     * fourth index corresponds to organic
     */
    public List<Double> preferences() {
        List<Double> userPreferences = new ArrayList<>();

        userPreferences.add(preferences.get("Transportation"));
        userPreferences.add(preferences.get("Creation"));
        userPreferences.add(preferences.get("Cost"));
        userPreferences.add(preferences.get("Organic"));

        return userPreferences;
    }

    /** adds a transaction of purchases to the list of transactions and updates preferences
     * based on the new purchase
     */
    public void createTransaction(Product purchase) {
        transactions.add(purchase);

    }
}