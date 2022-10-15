import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GroceryTest {
    @Test
    void testGrocerySearch() {
        Point p = new Point(10, 10);
        Grocery Walmart = new Grocery("Walmart", p);
        Product apple = new Product("apple", 1829.0, "plane", 3.90, true, false);
        Product banana = new Product("banana", 1569.0, "train", .25, true, true);
        Product fijiApple = new Product("fiji apple", 1281.0, "ship", 4.30, false, false);
        Walmart.addProduct(apple);
        Walmart.addProduct(banana);
        Walmart.addProduct(fijiApple);

        assertEquals("Walmart", Walmart.getName());
        assertEquals(2, Walmart.search("apple").size());
        assertEquals(1, Walmart.search("banana").size());
        assertEquals(1, Walmart.search("fiji apple").size());
    }
}