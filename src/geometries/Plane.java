package geometries;

import primitives.Point;
import primitives.Vector;

public class Plane implements Geometry {
	Point q0;
	Vector normal;
	
	
	public Plane(Point p1, Point p2, Point p3)
	{
		super();
		this.q0=p1;
		normal=null;
	}
	
	public Plane(Point p1, Vector n)
	{
		super();
		this.q0=p1;
		this.normal=n.normalize();
	}

	//Getters
	public Point getQ0() {
		return q0;
	}

	public Vector getNormal() {
		return normal;
	}

	@Override
	public String toString() {
		return "Plane [q0=" + q0 + ", normal=" + normal + "]";
	}
	
	@Override
	public Vector getNormal(Point p)
	{
		return ((Vector)(p)).normalize();
	}
	

	
	
	
}