package primitives;

import java.util.List;

/**
 * Class Ray is the basic class representing a Ray of Euclidean primitives in Cartesian
 * Object is founded in geometry
 * @author noale
*/
public class Ray {
		Vector dir;
		Point p0;
		/**
		 * constructor that receives a vector and a point and creates a ray
		 * @param dir
		 * @param p0
		 */
		public Ray(Vector dir, Point p0) {
			this.dir =dir.normalize();
			this.p0 = p0;
		}
		public Ray(Point p0, Vector dir) {
			this.dir =dir.normalize();
			this.p0 = p0;
		}
		public Point getPoint(double t) {
			return  p0.add(dir.scale(t));
		}
		public Point getP0() {
			// TODO Auto-generated method stub
			return p0;
		}
		public Vector getDir() {
			// TODO Auto-generated method stub
			return dir;
		}
		/**
	     * A function that returns the point closest to the head of the ray
	     * If the list is empty or null the function returns null
	     *
	     * @param points the list of the points
	     * @return the closest point
	     */
	    public Point findClosestPoint(List<Point> points) {
	        if (points == null)
	            return null;
	        double minDistance = Double.MAX_VALUE;
	        Point minPoint = null;
	        for (Point point : points) {
	            if (p0.Distance(point) < minDistance) {
	                minDistance = p0.Distance(point);
	                minPoint = point;
	            }
	        }
	        return minPoint;
	    }
		

}
