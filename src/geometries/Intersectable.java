/**
 * 
 */
package geometries;

import primitives.Ray;

import java.util.List;

import primitives.Point;

/**
 * @author noale
 *
 */
public interface Intersectable {
	public List<Point> findIntsersections(Ray ray);
	

}
