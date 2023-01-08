package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    public void testGetArea() {
        Triangle triangle = new Triangle(3, 4, 5);
        double expectedArea = 6;
        double actualArea = triangle.getArea();
        assertEquals(expectedArea, actualArea, 0.1);
    }

    @Test
    public void testGetPerimeter() {
        Triangle triangle = new Triangle(3, 4, 5);
        double expectedPerimeter = 12;
        double actualPerimeter = triangle.getPerimeter();
        assertEquals(expectedPerimeter, actualPerimeter, 0.1);
    }
}