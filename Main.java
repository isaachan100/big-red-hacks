import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Grocery> storeList = new ArrayList<>();
        storeList.add(readStoreData("Walmart Demo Data.csv"));
        storeList.add(readStoreData("Costco Demo Data.csv"));
        storeList.add(readStoreData("Target Demo Data.csv"));
        User u = new User("Ethan");
        ArrayList<Grocery> closestStores = bestStores(storeList, u);
        //command line input for array of products to search

        printSuggestions(closestStores, args, u);
    }

    public static ArrayList<Grocery> bestStores(ArrayList<Grocery> storeList, User u){
        TreeMap<Double, Grocery> groceryTreeMap = closeStores(storeList, u);
        ArrayList<Grocery> fiveBest = new ArrayList<>();
        int i = 0;
        for(Grocery a : groceryTreeMap.values()){
            if(i>=2) break;
            fiveBest.add(a);
            i++;
        }
        return fiveBest;
    }

    public static Grocery readStoreData(String name) {
        try(Reader r = new FileReader(name); BufferedReader br = new BufferedReader(r)) {
            String line = br.readLine();
            String[] a = line.split(",", Integer.MAX_VALUE);
            Point b = new Point(Double.parseDouble(a[1]), Double.parseDouble(a[2]));
            Grocery store = new Grocery(a[0], b);
            line = br.readLine();
            while (line != null) {
                a = line.split(",", Integer.MAX_VALUE);
                Product product = new Product(a[0], Double.parseDouble(a[1]), a[2], Double.parseDouble(a[3]),
                        Boolean.parseBoolean(a[4]), Boolean.parseBoolean(a[5]));
                store.addProduct(product);
                line = br.readLine();
            }
            return store;
        } catch (FileNotFoundException e) {
            System.err.println("File " + name + " not found");
        } catch (IOException e) {
            System.err.println("Error reading from file " + name);
        }
        return null;
    }

    public static TreeMap<Double, Grocery> closeStores(ArrayList<Grocery> storeList, User u){
        TreeMap<Double, Grocery> groceryTreeMap = new TreeMap<>();
        double x = u.getLoc().getLat();
        double y = u.getLoc().getLon();
        for(Grocery b : storeList){
            double dist = Math.pow(b.getLoc().getLat()-x,2)+Math.pow(b.getLoc().getLon()-y, 2);
            groceryTreeMap.put(Math.sqrt(dist), b);
        }
        return groceryTreeMap;
    }

    public static void printSuggestions(ArrayList<Grocery> storeList, String [] products, User u){
        for(Grocery store: storeList){
            for(String product: products){
                store.search(product);
            }
        }
        for (Map.Entry<K, V> entry : myMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
        }
    }

    //gather relevant products (call to Grocery) -> ArrayList<Product> might not even need this one
    // accept list of search and send to each grocer (for each loop) ->
    //adds confirmed purchase to each user class -> void
    // creates a tree map to sort products by score -> treemap



}
