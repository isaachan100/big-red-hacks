import java.lang.reflect.Array;
import java.nio.file.DirectoryIteratorException;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Grocery> storeList = new ArrayList<>();

    }

    public ArrayList<Grocery> bestStores(ArrayList<Grocery> storeList, User u){
        TreeMap<Double, Grocery> groceryTreeMap = closeStores(storeList, u);
        ArrayList<Grocery> fiveBest = new ArrayList<>();
        int i = 0;
        for(Grocery a : groceryTreeMap.values()){
            if(i>=5) break;
            fiveBest.add(a);
            i++;
        }
        return fiveBest;
    }

    public Grocery readStoreData(String name) {

        try(Reader r = new FileReader(name); BufferedReader br = new BufferedReader(r)) {
            String line = br.readLine();
            while (line != null) {

            }
        } catch (FileNotFoundException e) {
            System.err.println("File " + name + " not found");
        } catch (IOException e) {
            System.err.println("Error reading from file " + name);
        }
    }

    public TreeMap<Double, Grocery> closeStores(ArrayList<Grocery> storeList, User u){
        TreeMap<Double, Grocery> groceryTreeMap = new TreeMap<>();
        double x = u.getLoc().getLat();
        double y = u.getLoc().getLon();
        for(Grocery b : storeList){
            double dist = Math.pow(b.getLoc().getLat()-x,2)+Math.pow(b.getLoc().getLon()-y, 2);
            groceryTreeMap.put(Math.sqrt(dist), b);
        }
        return groceryTreeMap;
    }





    //gather closest stores -> ArrayList<Grocery>
    //gather relevant products (call to Grocery) -> ArrayList<Product> might not even need this one
    //come up with best store to go to -> Grocery
    // accept list of search and send to each grocer (for each loop) ->
    //adds confirmed purchase to each user class -> void
    // creates a tree map to sort products by score -> treemap



}
