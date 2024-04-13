package assignment4;

public class ManagementCompany {
	private String managementCompanyName;
	private String taxID;
	private double managementFee;
	public static final int MAX_PROPERTY  =5;
	public static final int MGMT_WIDTH = 10;
	public static final int MGMT_DEPTH = 10;
	private Property[] properties;
	private Plot plot;
	private int numberOfProperties;
	
	//creates a management company using a no-arg constructor
	//doing so intializes the propety array and creates a defautl plot
	public ManagementCompany()
	{
		plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
	//creates a management company with the given information 
	public ManagementCompany(String name, String taxID, double mgmFee)
	{
		managementCompanyName = name;
		this.taxID = taxID;
		managementFee = mgmFee;
		
		plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		
		properties = new Property[MAX_PROPERTY];
	}
	
	//creates a management company using a parameterized constructor
	// this also creates a plot with the given values 
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y,
			int width, int depth)
	{
		managementCompanyName = name;
		this.taxID = taxID;
		managementFee = mgmFee;
		plot = new Plot(x,y,width,depth);
		properties = new Property[MAX_PROPERTY];
	}
	
	//creates a management company by copying from another constructor 
	public ManagementCompany(ManagementCompany otherCompany)
	{
		this(otherCompany.managementCompanyName, otherCompany.taxID, otherCompany.managementFee);
		properties = new Property[MAX_PROPERTY];
		plot = new Plot(otherCompany.plot);
		numberOfProperties = otherCompany.numberOfProperties;
	}
	
	//adds a property to the field and returns an integer depending on if it's successfully placed 
	public int addProperty(String name, String city, double rent, String owner)
	{
		// retrieves the index of the property inserted into the property array
		int targetIndex =0;
		
		//iterates through the properties array
		for(int i=0;i<MAX_PROPERTY;i++)
		{
			//if the index is empty, a new property object will get inserted and keep track of its index
			if(properties[i] == null)
			{
				properties[i] = new Property(name, city, rent, owner);
				targetIndex = i;
				break;
			}
			
			//returns -1 if the array is full
			if(i == properties.length - 1)
			{
				return -1;
			}
			
		}
		// returns -2 if the property object is null after inserted into the array
		if(properties[targetIndex].getPlot() == null)
		{
			return -2;
		}
		
		//adds the x and y-values by their width and depth to check if its greater than the boundaries
		if((properties[targetIndex].getPlot().getX() + properties[targetIndex].getPlot().getWidth() > 10) ||
				properties[targetIndex].getPlot().getY() + properties[targetIndex].getPlot().getDepth() > 10)
		{
			return -3;
		}
		
		//iterates through the array to compare the new inserted property with other properties to see if any of them overlaps eachother
		for(int i=0;i<MAX_PROPERTY;i++)
		{
			//skips the index of the new inserted property
			if(i== targetIndex)
			{
				continue;
			}
			
			//skips if the index of the other arrays are empty
			else if(properties[i] == null)
			{
				continue;
			}
			
			else
			{
				// returns -4 if any of them overlaps
				if(properties[i].getPlot().overlaps(properties[targetIndex].getPlot()) == true)
				{
					return -4;
				}
			}
		}
		
		// if the property was successfully inserted without any problems, return its index
		return targetIndex;
		
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width , int depth)
	{
		int targetIndex =0;
		for(int i=0;i<properties.length;i++)
		{
			if(properties[i] == null)
			{
				properties[i] = new Property(name, city, rent, owner,x,y,width,depth);
				targetIndex = i;
				break;
			}
			
			if(i == properties.length - 1)
			{
				return -1;
			}
			
		}
		
		if(properties[targetIndex].getPlot() == null)
		{
			return -2;
		}
		if((properties[targetIndex].getPlot().getX() + properties[targetIndex].getPlot().getWidth() > 10) ||
				properties[targetIndex].getPlot().getY() + properties[targetIndex].getPlot().getDepth() > 10)
		{
			return -3;
		}
		
		for(int i=0;i<properties.length;i++)
		{
			if(i== targetIndex)
			{
				continue;
			}
			
			else if(properties[i] == null)
			{
				continue;
			}
			
			else
			{
				if(properties[i].getPlot().overlaps(properties[targetIndex].getPlot()) == true)
				{
					return -4;
				}
			}
		}
		
		return targetIndex;
		
	}
	
	public int addProperty(Property otherProperty)
	
	{
		
		int targetIndex =0;
		
		for(int i=0;i<properties.length;i++)
		{
			if(properties[i] == null)
			{
				properties[i] = new Property(otherProperty);
				targetIndex = i;
				break;
			}
			
			if(i == properties.length - 1)
			{
				return -1;
			}
			
		}
		
		if(properties[targetIndex].getPlot() == null)
		{
			return -2;
		}
		if((properties[targetIndex].getPlot().getX() + properties[targetIndex].getPlot().getWidth() > 10) ||
				properties[targetIndex].getPlot().getY() + properties[targetIndex].getPlot().getDepth() > 10)
		{
			return -3;
		}
		
		for(int i=0;i<properties.length;i++)
		{
			if(i== targetIndex)
			{
				continue;
			}
			
			else if(properties[i] == null)
			{
				continue;
			}
			
			else
			{
				if(properties[i].getPlot().overlaps(properties[targetIndex].getPlot()) == true)
				{
					return -4;
				}
			}
		}
		
		return targetIndex;
	}
	
	public String getName()
	{
		return managementCompanyName;
	}
	
	public String getTaxID()
	{
		return taxID;
	}
	
	public double getMgmFeePer()
	{
		return managementFee;
	}
	
	public Property[] getProperties()
	{
		return properties;
	}
	
	public Plot getPlot()
	{
		return plot;
	}
	
	public int getNumberOfProperties()
	{
		return numberOfProperties;
	}
	
	
	public int getPropertiesCount()
	{
		int count = 0;
		
		//counts all the property in the array and return that number
		for(int i=0;i<MAX_PROPERTY;i++)
		{
			if(properties[i] != null)
			{
				count++;
			}
		}
		return count;
	}
	
	public double getTotalRent()
	{
		//sums up all the rent from the properties and return it
		double totalRent = 0;
		
		for(int i=0;i<MAX_PROPERTY;i++)
		{
			if(properties[i]!=null)
			{
				totalRent += properties[i].getRentAmount();
			}
		}
		
		return totalRent;
	}
	
	//returns the highest property with the highest rent
	public Property getHighestRentPropperty()
	{
		// stores the rent of the first property
		double maximumRent = properties[0].getRentAmount();
		
		//stores the property in the first index
		Property maximumProperty = properties[0];
		
		//iterates through the array to compare the rent with other properties
		for(int i=1;i<MAX_PROPERTY;i++)
		{
			if(properties[i]!=null)
			{
				//if the property's rent is greater than the current rent, change the maximum rent to the new maximum rent 
				if(properties[i].getRentAmount() > maximumRent)
				{
					maximumRent = properties[i].getRentAmount();
					maximumProperty = properties[i];
				}
			}
		}
		
		return maximumProperty;
	}
	
	// returns true or false, depending on if the management is between including 0 and 100
	public boolean isManagementFeeValid()
	{
		if((int)(managementFee) >=0 && (int)(managementFee) <= 100)
		{
			return true;
		}
		return false;
	}
	
//returns true or false depending on if the array is full of properties
	public boolean isPropertiesFull()
	{
		// calls the method to retrieve the current number of properties in the array
		int propertyCount = getPropertiesCount();
		
		if(propertyCount == MAX_PROPERTY)
		{
			return true;
		}
		
		return false;
	}
	
	//removes the last property of the array
	public void removeLastProperty() 
	{
		//creates a new array as a place holder
		Property [] newArray = new Property[MAX_PROPERTY];
		
		//Iterates through the original property array and copies the properties to the placeholder
		//all the way not including the last index of the array
		for(int i=0;i<MAX_PROPERTY-1;i++)
		{
			newArray[i]= properties[i];
		}
		
		//original property array copies the placeholder by reference copy
		properties = newArray;
	}
	
	public String toString()
	{
		String propertyInfo = "";
		
		//goes through the array and store each property info onto the empty string
		for(int i=0;i<MAX_PROPERTY;i++)
		{
			if(properties[i] !=null)
			{
				propertyInfo += properties[i] +"\n";
			}
			
		//returns the format of the management company and its plot
		}
		return "List of the properties for " + managementCompanyName + ", " + "taxID: " + taxID +"\n"
		+ "______________________________________________________\n"
		+ propertyInfo
		+ "______________________________________________________\n"
		+"\n"
		+ " total management Fee: " + (getTotalRent() * managementFee /100);


	}
	
	
	
	
	
}
