package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class RectangleTest {
    @Test
    public void testGetArea() {
        Rectangle rectangle = new Rectangle(10, 20, "red");
        double expectedArea = 200;
        double actualArea = rectangle.getArea();
        assertEquals(expectedArea, actualArea, 0.1);
    }

    @Test
    public void testGetPerimeter() {
        Rectangle rectangle = new Rectangle(10, 20, "red");
        double expectedPerimeter = 60;
        double actualPerimeter = rectangle.getPerimeter();
        assertEquals(expectedPerimeter, actualPerimeter, 0.1);
    }
}