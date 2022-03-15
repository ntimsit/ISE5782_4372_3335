package primitives;

import static primitives.Util.isZero;

public class Point {
	protected final Double3 xyz;
	
	//Constructor that gets 3 doubles
	public Point(double x, double y, double z)
	{
		this.xyz=new Double3(x,y,z);
		
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Point))
			return false;
		Point other = (Point) obj;
		return isZero(xyz.d1 - other.xyz.d1) && isZero(xyz.d2 - other.xyz.d2) && isZero(xyz.d3 - other.xyz.d3);
	}

	//constructor that gets a Double3 object
	public Point(Double3 xyz)
	{
		this.xyz=xyz;
	}
	
	//subtraction between two points, returns a vector
	public Vector subtract(Point other)
	{
		return new Vector(this.xyz.subtract(other.xyz));
	}
	
	public Point add(Vector other)
	{
		Point j =new Point(this.xyz.add(other.xyz));
		return j;
	}
	public double distanceSquared(Point other)
	{
		Vector d=this.subtract(other);
		return (d.xyz.d1*d.xyz.d1+d.xyz.d2*d.xyz.d2+d.xyz.d3*d.xyz.d3);
	}
	public double distance(Point other)
	{
		return Math.sqrt(this.distanceSquared(other));
	}
	
	@Override
	public String toString() {
		return "("+ this.xyz.d1+", "+this.xyz.d2+", "+this.xyz.d3+")";
	}	

}