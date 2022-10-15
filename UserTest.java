import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.*;

class UserTest {
    @Test
    void testConstructor() {
        User Isaac = new User("iyh7");
        List<Double> expectedPreferences = new ArrayList<>();
        expectedPreferences.add(0.3);
        expectedPreferences.add(0.3);
        expectedPreferences.add(0.2);
        expectedPreferences.add(0.2);


        assertEquals("iyh7", Isaac.username());
        assertEquals(expectedPreferences, Isaac.preferences());
    }
}