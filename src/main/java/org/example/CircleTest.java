package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CircleTest {
    @Test
    public void testGetArea() {
        Circle circle = new Circle(5, "blue");
        double expectedArea = 78.53982;
        double actualArea = circle.getArea();
        assertEquals(expectedArea, actualArea, 0.1);
    }

    @Test
    public void testGetPerimeter() {
        Circle circle = new Circle(5, "blue");
        double expectedPerimeter = 31.4159;
        double actualPerimeter = circle.getPerimeter();
        assertEquals(expectedPerimeter, actualPerimeter, 0.1);
    }
}