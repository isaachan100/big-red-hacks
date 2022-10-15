import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductTest {
    @Test
    void testConstructor() {
        Product apple = new Product("apple", 1829.0, "plane", 3.90, true, false);
        assertEquals("apple", apple.getName());
        assertEquals(1829.0, apple.getDistance());
        assertEquals(1.0, apple.getShipping());
        assertEquals(3.90, apple.getPrice());
        assertTrue(apple.getOrganic());
        assertFalse(apple.getCarbon());
        assertEquals("[1.22, 0.0, 4.74, 10.0]", apple.scores(3.80).toString());
    }
}