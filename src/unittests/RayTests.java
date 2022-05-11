package unittests;

import org.junit.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RayTests {
    @Test
    public void testFindClosestPoint() {
        Ray ray = new Ray(new Point(1, 1, 1), new Vector(1, 1, 1));
        List<Point> list = new ArrayList<Point>();

        // ============ Equivalence Partitions Tests ==============

        // TC01: Point at the center of the list
        list.add(new Point(10, 1, 2));
        list.add(new Point(1, 1, 2));
        list.add(new Point(1, 1, 20));
        list.add(new Point(10, 1, 20));
        assertEquals("the point is not the central point", new Point(1, 1, 2), ray.findClosestPoint(list));


        // =============== Boundary Values Tests ==================

        // TC2: Empty list
        list = new ArrayList<>();
        assertNull("the list is not empty", ray.findClosestPoint(list));
        assertNull("the list is not empty", ray.findClosestPoint(null));

        // TC3:  Point at the begging of the list
        list = new ArrayList<>();
        list.add(new Point(1, 0, 2));
        list.add(new Point(10, 5, 2));
        list.add(new Point(0, 1, 32));
        list.add(new Point(15, 1, 20));
        assertEquals("the point is not the first point", new Point(1, 0, 2), ray.findClosestPoint(list));


        // TC4:  Point at the end of the list
        list = new ArrayList<>();
        list.add(new Point(0, 25, 5));
        list.add(new Point(0, 10, 2));
        list.add(new Point(0, 100, 0));
        list.add(new Point(-1, 1, 1));
        assertEquals("the point is not the last point", new Point(-1, 1, 1), ray.findClosestPoint(list));
    }
}