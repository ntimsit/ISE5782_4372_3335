package unittests;

import org.junit.jupiter.api.Test;

import primitives.*;
import geometries.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static primitives.Util.isZero;

/**
 * Unit tests for geometries.Sphare class
 * @author Noa and naaama
 */
class SphareTest {

    /**
     * Test method for {@link geometries.Sphere#getNormal(primitives.Point)}.
     */
    @Test
    public void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        Point p= new Point(1, 1, 6);
        Point p1=new Point(1,1,1);
        Sphere s = new Sphere(p1,5);
        Vector v= p1.subtract(p).normalize();

        assertEquals(v, s.getNormal(p), "Bad normal to sphere");//regular case
    }
    
    /**
	 * Test method for {@link Sphere#findIntersections(Ray)}
	 */
	@Test
	public void testFindIntersections (){
		Sphere sphere = new Sphere(new Point(1, 0, 0) , 4);
		List<Point> intsersections;
		Ray ray;

		// ============ Equivalence Partitions Tests ==============

		// TC01: Ray is going through the sphere (2 points).
		ray = new Ray(new Vector(-1, 0, 0), new Point(6, 0, 0));
		intsersections = sphere.findIntsersections(ray);
		assertNotNull(intsersections);
		assertEquals(2, intsersections.size(), "wrong number of points");
		assertEquals(new Point(-3, 0, 0), intsersections.get(0), "Wrong point");
		assertEquals(new Point(5, 0, 0), intsersections.get(1), "Wrong point");

		// TC02: Ray is going outside the sphere (0 points).
		ray = new Ray(new Vector(0, 1, 0), new Point(1, 0, 5));
		intsersections = sphere.findIntsersections(ray);
		assertNull(intsersections);

		// TC03: Ray is starting outside the sphere and it's direction is opposite to sphere (0 points).
		ray = new Ray(new Vector(-1, -1, -1), new Point(-5, -5, -5));
		intsersections = sphere.findIntsersections(ray);
		assertNull(intsersections);

		// TC04: Ray is starting inside the sphere (1 points).
		ray = new Ray(new Vector(-1, 4, 0), new Point(2, 0, 0));
		intsersections = sphere.findIntsersections(ray);
		assertNotNull(intsersections);
		assertEquals(1, intsersections.size(), "wrong number of points");
		assertEquals(new Point(1, 4, 0), intsersections.get(0), "Wrong point");


		// =============== Boundary Values Tests ==================

		// TC05: Ray begin on the perimeter and it's direction opposite to sphere (0 points).
		ray = new Ray(new Vector(1, 1, 1), new Point(1, 0, 4));
		intsersections = sphere.findIntsersections(ray);
		assertNull(intsersections);

		// TC06: Ray begin on the perimeter and it's direction to sphere (1 points).
		ray = new Ray(new Vector(-4, 0, 4), new Point(5, 0, 0));
		intsersections = sphere.findIntsersections(ray);
		assertNotNull(intsersections);
		assertEquals(1, intsersections.size(), "wrong number of points");
		assertEquals(new Point(1, 0, 4), intsersections.get(0), "Wrong point");

		// TC07: Ray begin outside the sphere and tangent to sphere (0 points).
		ray = new Ray( new Vector(1, 0, 0), new Point(0, 0, 4));
		intsersections = sphere.findIntsersections(ray);
		assertNull(intsersections);

		// TC08: Ray begin on the perimeter of the sphere and tangent to sphere (0 points).
		ray = new Ray(new Vector(1, 0, 0), new Point(1, 0, 4));
		intsersections = sphere.findIntsersections(ray);
		assertNull(intsersections);

		// TC09: Ray begin outside the sphere on the tangent's continuation of the sphere (0 points).
		ray = new Ray(new Vector(1, 0, 0), new Point(2, 0, 4));
		intsersections = sphere.findIntsersections(ray);
		assertNull(intsersections);

		// TC10: Ray begin outside the sphere and its direction is vertically to the Radius vector continuation (0 points).
		ray = new Ray(new Vector(0, 0, 1), new Point(6, 0, 0));
		intsersections = sphere.findIntsersections(ray);
		assertNull(intsersections);

		// TC11: Ray begin on sphere perimeter and its direction is the continuation of the Radius vector outside sphere (0 points).
		ray = new Ray(new Vector(1, 0, 0), new Point(5, 0, 0));
		intsersections = sphere.findIntsersections(ray);
		assertNull(intsersections);

		// TC12: Ray begin outside the sphere and it's direction is on Radius vector opposite to sphere (0 points).
		ray = new Ray( new Vector(1, 0, 0), new Point(6, 0, 0));
		intsersections = sphere.findIntsersections(ray);
		assertNull(intsersections);

		// TC13: Ray begin inside the sphere going outside the sphere on the Radius vector (1 points).
		ray = new Ray(new Vector(1, 0, 0), new Point(4, 0, 0));
		intsersections = sphere.findIntsersections(ray);
		assertNotNull(intsersections);
		assertEquals(1, intsersections.size(), "wrong number of points");
		assertEquals(new Point(5, 0, 0), intsersections.get(0), "Wrong point");

		// TC14: Ray begin on sphere perimeter and going through the center of the sphere (1 points).
		ray = new Ray(new Vector(1, 0, 0), new Point(-3, 0, 0));
		intsersections = sphere.findIntsersections(ray);
		assertNotNull(intsersections);
		assertEquals(1, intsersections.size(), "wrong number of points");
		assertEquals(new Point(5, 0, 0), intsersections.get(0), "Wrong point");

		// TC15: Ray begin outside sphere and going through the center of the sphere (2 points).
		ray = new Ray(new Vector(1, 0, 0), new Point(-4, 0, 0));
		intsersections = sphere.findIntsersections(ray);
		assertNotNull(intsersections);
		assertEquals(2, intsersections.size(), "wrong number of points");
		assertEquals(new Point(5, 0, 0), intsersections.get(0), "Wrong point");
		assertEquals(new Point(-3, 0, 0), intsersections.get(1), "Wrong point");
	}
   
}

