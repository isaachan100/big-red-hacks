import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductTest {
    @Test
    void testConstructor() {
        Product apple = new Product("apple", 1829.0, "plane", 3.90, true, false);
        User u = new User("iyh7");
        assertEquals("apple", apple.getName());
        assertEquals(1829.0, apple.getDistance());
        assertEquals(0.5, apple.getShipping());
        assertEquals(3.90, apple.getPrice());
        assertTrue(apple.getOrganic());
        assertFalse(apple.getCarbon());
        assertEquals("[1.22, 0.0, 4.74, 10.0]", apple.scores(3.80).toString());

    }

    void testCalculateScore() {
        Product apple = new Product("apple", 1829.0, "plane", 3.90, true, false);
        User u = new User("iyh7");
        assertEquals(3.31, apple.calculateScore(u, 3.80));
    }
}