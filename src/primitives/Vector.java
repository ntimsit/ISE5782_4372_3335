package primitives;

public class Vector extends Point {
	
	
	public Vector(double x, double y, double z) throws IllegalArgumentException
	{
		super(x,y,z);
		if(this.equals(Double3.ZERO))
			throw new IllegalArgumentException("vector cannot be zero");
	}
	
	public Vector (Double3 v) throws IllegalArgumentException
	{
		super(v);
		if(this.equals(Double3.ZERO))
			throw new IllegalArgumentException("vector cannot be zero");
	}
	
	public Vector add(Vector other)
	{
		return new Vector(this.xyz.add(other.xyz));
	}
	
	public Vector scale(double x)
	{
		return new Vector(this.xyz.scale(x));
	}
	
	public double dotProduct(Vector other)
	{
		Double3 x =this.xyz.product(other.xyz);
		return(x.d1+x.d2+x.d3);
	}
	
	public Vector crossProduct(Vector other)
	{
		try {
		Vector x=new Vector((this.xyz.d2*other.xyz.d3-this.xyz.d3*other.xyz.d2),
				-(this.xyz.d1*other.xyz.d3-this.xyz.d3*other.xyz.d1),
				(this.xyz.d1*other.xyz.d2-this.xyz.d2*other.xyz.d1));
		return x;}
		catch(Exception IllegalArgumentException)
		{
			return (Double3.ZERO);
		}
		
		
	}
	
	
	public double lengthSquared()
	{
		return (this.xyz.d1*this.xyz.d1+this.xyz.d2*this.xyz.d2+this.xyz.d3*this.xyz.d3);
	}
	
	public double length()
	{
		return Math.sqrt(this.lengthSquared());
	}
	
	public Vector normalize()
	{
		return new Vector(this.xyz.reduce(this.length()));
	}
	

}