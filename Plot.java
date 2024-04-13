package assignment4;

public class Plot {
	private int x;
	private int y;
	private int width;
	private int depth;
	
	//creates a plot using a no-arg constructor, which sets depth and width to 1 as default
	public Plot()
	{
		depth = 1;
		width = 1;
	}
	
	//creates a plot using parameterized constructor
	public Plot(int x, int y, int width, int depth)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	//creates a plot by coping from another constructor
	public Plot(Plot copyPlot)
	{
		this(copyPlot.x, copyPlot.y, copyPlot.depth, copyPlot.width);
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getDepth()
	{
		return depth;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public void setX(int newX)
	{
		x = newX;
	}
	
	public void setY(int newY)
	{
		y = newY;
	}
	
	public void setDepth(int newDepth)
	{
		depth = newDepth;
	}
	
	public void setWidth(int newWidth)
	{
		width = newWidth;
	}
	
	public boolean overlaps(Plot otherPlot)
	{
		
		
		//Coordinate point on lower-right
		int x2 = x+width;
		int y2 = y;
		int x2Other = otherPlot.x + otherPlot.width;
		int y2Other  = otherPlot.y;
		
		//coordinate point on upper-left
		int x3 = x;
		int y3 = y+depth;
		int x3Other = otherPlot.x;
		int y3Other = otherPlot.y + otherPlot.depth;
		
		//coordinate point on upper-right
		int x4 = x+width;
		int y4 = y+depth;
		int x4Other = otherPlot.x + otherPlot.width;
		int y4Other = otherPlot.y + otherPlot.depth;
		
		//when the x-value of the point is between 2 points
		if(x > otherPlot.x && x< x2Other)
		{
			// if the y-value is in the middle of the plot
			if(y < y3Other && y > otherPlot.y)
			{
				return true;
			}
		}
		
		// when the x-value is between 2 points but its y-value is the same as the instance plot
		else if(x > otherPlot.x && x< x2Other)
		{
			if(y == otherPlot.y)
			{
				if(y3 > otherPlot.y && y3 < y3Other)
				{
					return true;
				}
			}
		}
		
		//when the y-value from the bottom has an upper-left point that overlaps the instance plot
		else if(y < otherPlot.y)
		{
			if(y3 > otherPlot.y)
			{
				return true;
			}
		}
		
		//when the x-value is outside but its lowerRight overlaps the instance plot
		else if(x < otherPlot.x)
		{
			if(x2 > x2Other)
			{
				if(y2 > otherPlot.y && y2 < y3Other)
				{
					return true;
				}
			}
		}
		return false;
		
	}
	
	public boolean encompasses(Plot otherPlot)
	{
		// if the given plot is between the y-value one the vertical axis or givenPlot's y-value is equal to that of the current plot
		if((otherPlot.y < (y+width) && otherPlot.y > y) || otherPlot.y == y)
		{
			// if the given plot's lower-right x-value is less than or equal to that of the current plot,
			//then the given plot is contained
			if((otherPlot.x + otherPlot.width) <= (x+width))
			{
				return true;
			}
		}
		
		return false;
		
	}
	
	public String toString()
	{
		return x+","+y+","+width+","+depth;
	}
	
	
	

}
