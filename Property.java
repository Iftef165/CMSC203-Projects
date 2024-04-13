package assignment4;

public class Property {
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	
	//creates a new property using no-arg constructor, which creates a default plot
	public Property()
	{
		plot = new Plot();
	}
	
	//create a property using parameterized constructor and creates a default plot
	public Property(String propertyName, String city, double rentalAmount,
			String owner)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentalAmount;
		this.owner = owner;
		plot = new Plot();		
	}
	
	//creates a property using parametrzed constructor and creates a plot object
	public Property(String propertyName, String city, double rentalAmount,
			String owner, int x, int y, int width, int depth)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentalAmount;
		this.owner = owner;
		plot = new Plot(x,y,width,depth);
		
	}
	
	//creates a new property object by comparing from an another constructor
	public Property(Property otherProperty)
	{
		this(otherProperty.propertyName, otherProperty.city, otherProperty.rentAmount,
				otherProperty.owner);
		this.plot = new Plot(otherProperty.plot);
	}
	
	public Plot getPlot()
	{
		return plot;
	}
	
	public String getPropertyName()
	{
		return propertyName;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public double getRentAmount()
	{
		return rentAmount;
	}
	
	public String getOwner()
	{
		return owner;
	}
	
	public String toString()
	{
		return propertyName +","+city +","+ owner + ","+rentAmount;
	}
	
	
	

}
