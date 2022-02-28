package geometries;

import primitives.Point;
import primitives.Vector;

public class Sphere implements Geometry {
	
	Point center;
	double radius;
	
	public Sphere(Point center, double radius)
	{
		super();
		this.center=center;
		this.radius=radius;
	}

	public Point getCenter() {
		return center;
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public Vector getNormal(Point p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "Sphere [center=" + center + ", radius=" + radius + "]";
	}
	
	

	

}