package geometries;

import primitives.Ray;

public class Cylinder extends Tube {
	
	double height;
	
	public Cylinder(double height, Ray axisRay, double radius)
	{
		super(axisRay, radius);
		this.height=height;
	}

	public double getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "Cylinder [height=" + height + ", axisRay=" + axisRay + ", radius=" + radius + "]";
	}

	

}