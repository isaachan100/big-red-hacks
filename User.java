import java.util.*;
public class User {

    /** list of integers for each user's preferences */
    private List<Double> preferences;

    /** String containing the username of the user
     * requires: username cannot be empty
     */
    private String username;

    /** list of previous transaction data */
    private List<Product> transactions;

    /** creates a user with username name and default preferences (weighted toward green) */
    public User (String name) {
        username = name;
        preferences = new ArrayList<>();
        preferences.add(0.3);
        preferences.add(0.3);
        preferences.add(0.2);
        preferences.add(0.2);
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

        userPreferences.add(preferences.get(0));
        userPreferences.add(preferences.get(1));
        userPreferences.add(preferences.get(2));
        userPreferences.add(preferences.get(3));

        return userPreferences;
    }

    /** adds a transaction of purchases to the list of transactions and updates preferences
     * based on the new purchase
     */
    public void createTransaction(Product purchase, double averageCost) {
        transactions.add(purchase);
        List<Double> scores = purchase.scores(averageCost);
        for (int i = 0; i < 4; i++) {
            double currentPreference = preferences.get(i);
            double change = (scores.get(i) - currentPreference) * 0.1;
            currentPreference += change;
            preferences.set(i, currentPreference);
        }
    }
}