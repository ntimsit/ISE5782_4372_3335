/**
 * 
 */
package unittests;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static primitives.Util.isZero;

import org.junit.jupiter.api.Test;

import primitives.Vector;

/**
 * @author noale
 *
 */
class VectorTests {

	/**
	 * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
	 */
	@Test
	void testDotProduct() {
//		if (!isZero(v1.dotProduct(v3)))
//			out.println("ERROR: dotProduct() for orthogonal vectors is not zero");
//		if (!isZero(v1.dotProduct(v2) + 28))
//			out.println("ERROR: dotProduct() wrong value");
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
	 */
	//@Test
	//void testCrossProduct1() {
		/**
	     * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
	     */
	    @Test
	    public void testCrossProduct() {
	        Vector v1 = new Vector(1, 2, 3);

	        // ============ Equivalence Partitions Tests ==============
	        Vector v2 = new Vector(0, 3, -2);
	        Vector vr = v1.crossProduct(v2);

	        // TC01: Test that length of cross-product is proper (orthogonal vectors taken
	        // for simplicity)
	        assertEquals("crossProduct() wrong result length", v1.length() * v2.length(), vr.length(), 0.00001);

	        // TC02: Test cross-product result orthogonality to its operands
	        assertTrue("crossProduct() result is not orthogonal to 1st operand", isZero(vr.dotProduct(v1)));
	        assertTrue("crossProduct() result is not orthogonal to 2nd operand", isZero(vr.dotProduct(v2)));

	        // =============== Boundary Values Tests ==================
	        // TC11: test zero vector from cross-productof co-lined vectors
	        Vector v3 = new Vector(-2, -4, -6);
	        assertThrows("crossProduct() for parallel vectors does not throw an exception",
	                IllegalArgumentException.class, () -> v1.crossProduct(v3));
	    }
	    
	    


	//}

	/**
	 * Test method for {@link primitives.Vector#lengthSquared()}.
	 */
	@Test
	void testLengthSquared() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link primitives.Vector#length()}.
	 */
	@Test
	void testLength() {
		Vector v1 = new Vector(1, 2, 3);
		assertTrue("lengthSquared() wrong value",isZero(v1.lengthSquared() - 14));
			
		if (!isZero(new Vector(0, 3, 4).length() - 5))
			out.println("ERROR: length() wrong value");
	}
	

    // ============ Equivalence Partitions Tests ==============
    Vector v2 = new Vector(0, 3, -2);
    Vector vr = v1.crossProduct(v2);

    // TC01: Test that length of cross-product is proper (orthogonal vectors taken
    // for simplicity)
    //assertEquals("crossProduct() wrong result length", v1.length() * v2.length(), vr.length(), 0.00001);

    // TC02: Test cross-product result orthogonality to its operands
    assertTrue("crossProduct() result is not orthogonal to 1st operand", isZero(vr.dotProduct(v1)));
    assertTrue("crossProduct() result is not orthogonal to 2nd operand", isZero(vr.dotProduct(v2)));

    // =============== Boundary Values Tests ==================
    // TC11: test zero vector from cross-productof co-lined vectors
    Vector v3 = new Vector(-2, -4, -6);
    assertThrows("crossProduct() for parallel vectors does not throw an exception",
            IllegalArgumentException.class, () -> v1.crossProduct(v3));

	/**
	 * Test method for {@link primitives.Vector#normalize()}.
	 */
	@Test
	void testNormalize() {
		fail("Not yet implemented");
	}

}
