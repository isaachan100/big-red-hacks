import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductTest {
    @Test
    void testConstructor() {
        Product apple = new Product("apple", 1829.0, "plane", 3.91, true, false);
        User u = new User("iyh7");
        assertEquals("apple", apple.getName());
        assertEquals(1829.0, apple.getDistance());
        assertEquals(0.5, apple.getShipping());
        assertEquals(3.91, apple.getPrice());
        assertFalse(apple.getCarbon());
        assertEquals("[1.22, 0.0, 4.71, 10.0]", apple.scores(3.80).toString());
        assertEquals(("apple traveled 1829.0 miles to get to the store and was shipped by plane. It"
        + " was produced organically and it's production was not carbon-intensive. It costs 3.91."),
                apple.toString());
    }

    void testCalculateScore() {
        Product apple = new Product("apple", 1829.0, "plane", 3.90, true, false);
        User u = new User("iyh7");
        assertEquals(3.31, apple.calculateScore(u, 3.80));
    }
}