import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.*;
class GroceryTest {
    @Test
    void testGrocerySearch() {
        Point p = new Point(10, 10);
        Grocery Walmart = new Grocery("Walmart", p);
        Product apple = new Product("apple", 1829.0, "plane", 3.90, true, false);
        Product banana = new Product("banana", 1569.0, "train", .25, true, true);
        Product fijiApple = new Product("fiji apple", 1281.0, "ship", 4.30,
                false, false);
        Product greekYogurt = new Product("Chobani Greek Yogurt", 550.0, "ship",
                4.30, false, false);
        Walmart.addProduct(apple);
        Walmart.addProduct(banana);
        Walmart.addProduct(fijiApple);
        Walmart.addProduct(greekYogurt);

        assertEquals("Walmart", Walmart.getName());
        assertEquals(2, Walmart.search("apple").size());
        assertEquals(1, Walmart.search("banana").size());
        assertEquals(1, Walmart.search("fiji apple").size());
        assertEquals(1, Walmart.search("yogurt").size());
        assertEquals(1, Walmart.search("Greek yogurt").size());
        assertEquals(1, Walmart.search("GreEK yoguRT").size());
        assertEquals(1, Walmart.search("chobani greek yogurt").size());
        assertEquals(0, Walmart.search("blueberry yogurt").size());
    }

    @Test
    void testStoreScore() {
        Point p = new Point(10, 10);
        Grocery Walmart = new Grocery("Walmart", p);
        User u = new User("Isaac");
        Product apple = new Product("apple", 1829.0, "plane", 3.90, true, false);
        Product banana = new Product("banana", 1569.0, "train", .25, true, true);
        Product fijiApple = new Product("fiji apple", 1281.0, "ship", 4.30,
                false, false);
        Product honeyCrispApple = new Product("honey crisp apple", 89.0, "train", 2.95,
                true, true);
        Product greekYogurt = new Product("Chobani Greek Yogurt", 550.0, "ship",
                4.30, false, false);
        Product smoothYogurt = new Product("Yoplait Yogurt", 190.5, "train", 3.9,
                true,false);
        Walmart.addProduct(apple);
        Walmart.addProduct(banana);
        Walmart.addProduct(fijiApple);
        Walmart.addProduct(greekYogurt);
        Walmart.addProduct(smoothYogurt);
        Walmart.addProduct(honeyCrispApple);
        List<String> groceries = new ArrayList<>();
        groceries.add("apple");
        groceries.add("banana");
        groceries.add("yogurt");
        List<Double> costs = new ArrayList<>();
        costs.add(3.80);
        costs.add(1.25);
        costs.add(4.0);

        Walmart.storeScore(groceries, u, costs);
    }
}