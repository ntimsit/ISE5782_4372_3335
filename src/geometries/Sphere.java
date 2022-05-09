package geometries;


import java.util.ArrayList;
import java.util.List;

//import primitives.*;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;



public class Sphere implements Geometry  {
	private Double radius;
	private Point center;

	public Sphere(Point p1, double radius) {
		 super();
	        this.center = center;
	        this.radius = radius;
	}

	/*
	@Override
	public List<Point> findIntsersections(Ray ray) {
		 Point p0 = ray.getP0();
	        Vector rayDir = ray.getDir();
	        Vector u = center.subtract(p0);
	        double tm = rayDir.dotProduct(u);
	        double d = Math.sqrt(Math.abs(u.dotProduct(u)) - tm * tm);
	        if (d > radius || alignZero(radius - d)== 0)
	            return null;
	        double th = Math.sqrt(radius * radius - d * d);
	        List<Point> intersections = null;
	        double t1 = alignZero(tm + th);
	        double t2 = alignZero(tm - th);
	        if (t1 > 0 || t2 > 0) {
	            intersections = new ArrayList<>();
	            if (t1 > 0)
	                intersections.add(ray.getPoint(t1));
	            if (t2 > 0 && !isZero(th))
	                intersections.add(ray.getPoint(t2));
	        }
	        return intersections;
	}
	*/
	@Override
	public List<Point> findIntsersections(Ray ray) {

	Point p0 = ray.getP0(); // ray's starting point
	Point O = this.center; //the sphere's center point
	Vector V = ray.getDir(); // "the v vector" from the presentation

	// if p0 on center, calculate with line parametric representation
	// the direction vector normalized.
	if (O.equals(p0)) {
	Point newPoint = p0.add(ray.getDir().scale(this.radius));
	return List.of(newPoint);
	}
	

	Vector U = O.subtract(p0);
	double tm = V.dotProduct(U);
	double d = Math.sqrt(U.lengthSquared() - tm * tm);
	if (d >= this.radius) {
	return null;
	}

	double th = Math.sqrt(this.radius * this.radius - d * d);
	double t1 = tm - th;
	double t2 = tm + th;

	if (t1 > 0 && t2 > 0) {
	Point p1 = ray.getPoint(t1);
	Point p2 = ray.getPoint(t2);
	return List.of(p1, p2);
	}

	if (t1 > 0) {
	Point p1 = ray.getPoint(t1);
	return List.of(p1);
	}

	if (t2 > 0) {
	Point p2 = ray.getPoint(t2);
	return List.of(p2);
	}
	return null;
	}




	@Override
	public Vector getNormal(Point p) {
		return p.subtract(center).normalize();
	}

}
