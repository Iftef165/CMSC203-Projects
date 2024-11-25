
/*
 * Class: CMSC203 
 * Instructor: Professor Eivazi
 * Description: calculates the holiday bonus for each sale
 * Due: 11/24/24
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Ifte Maksud
*/

public class HolidayBonus {
	private static final double MAX_SALES = 5000;
	private static final double LOW_SALES = 1000;
	private static final double NORMAL_SALES = 2000;
	public HolidayBonus()
	{
		
	}
	
	public static double[] calculateHolidayBonus(double[][]data)
	{
		//represents the bonuses from each store
		double[] holidayBonuses = new double[data.length];
		
		for(int i=0;i<data.length;i++)
		{
			//represents the sum from each store, which will be added throughout the rows
			double sum = 0.0;
			for(int j=0; j< data[i].length;j++)
			{
				//is the element is a negative, the store doesn't qualify for bonuses
				if(data[i][j]<0)
				{
					continue;
				}
				
				//if the index of the highest sale in the current column is equal to the current row index
				//then add 5000 bonus
				else if(TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j) == i)
				{
					sum+=MAX_SALES;
				}
				
				//if the index of the lowest sale in the current column is equal to the current row index
				//then add the 1000 bonus
				else if(TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j) == i)
				{
					sum+=LOW_SALES;
				}
				//add 2000 when the sale is not the highest or the lowest 
				else
				{
					sum+=NORMAL_SALES;
				}
			}
			
			//adds the total sums from all the stores into the array
			holidayBonuses[i] = sum;
		}
		
		return holidayBonuses;
	}
	
	public static double calculateTotalHolidayBonus(double[][] data)
	{
		double totalHolidayBonus = 0.0;
		
		//retrieves the bonuses from each store
		double[] bonuses = calculateHolidayBonus(data);
		
		//adds the bonuses from each bonuses
		for(int i=0;i<bonuses.length;i++)
		{
			totalHolidayBonus+=bonuses[i];
		}
		
		return totalHolidayBonus;
		
		
	}
	
}
