package geometries;

import java.util.List;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class Cylinder  extends Tube {
	
	public Cylinder(Ray axisRay, double radius) {
		super(axisRay, radius);
		// TODO Auto-generated constructor stub
	}

	private double height;
	
	@Override
	public List<Point> findIntsersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}

	 @Override
	    public Vector getNormal(Point point) {
		    double t = axisRay.getDir().dotProduct(point.subtract(axisRay.getP0()));
		    Point O = axisRay.getP0().add(axisRay.getDir().scale(t));
		    return point.subtract(O).normalize();
	 }

}
