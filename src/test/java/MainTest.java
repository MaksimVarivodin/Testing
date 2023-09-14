package test.java;

import main.java.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    public void functionTest() {
        // Test that the function returns 0
        assertEquals(0, new Main().function());
    }
}
