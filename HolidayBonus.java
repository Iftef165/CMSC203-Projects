
/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: calcualtes the total holiday bonus and creates the array
 * Due: 05/01/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Ifte Maksud
*/

public class HolidayBonus {
	public static final int maxBonus = 5000;
	public static final int lowestBonus = 1000;
	public static final int normalBonus = 2000;
	
	
	public HolidayBonus()
	{
		
	}
	
	public static double[] calculateHolidayBonus(double[][]data)
	{
		
		//create the bonus array depending on the number of rows
		double[] bonusList = new double[data.length];
		
		for(int i=0;i<bonusList.length;i++)
		{
			//calculates total holiday bonus from each stores
			int bonusSum = 0;
			for(int j=0;j<data[i].length;j++)
			{
				
				//if the highest index of the current column equals the index of current row
				//add 5000 to the bonus
				if(TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j) == i)
				{
					bonusSum +=5000;
				}
				//if the lowest index of the current column equals the index of current row
				//add 1000 to the bonus
				else if(TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j) == i)
				{
					bonusSum +=1000;
				}
				
				//checks to see if the number is 0 or negative
				else if(data[i][j] < 0 || data[i][j] ==0)
				{
					continue;
				}
	
				//add 2000 to bonus if all if statements above are false
				else
				{
					bonusSum +=2000;
				}
			}
			
			//adds the total bonus of the row to an index of the bonus array
			bonusList[i] = bonusSum;
		}
		
		return bonusList;
	}
	
	public static double calculateTotalHolidayBonus(double[][]data)
	{
		double totalBonus = 0;
		
		//copies the bonus array by reference
		double [] placeHolder = calculateHolidayBonus(data);
		
		//adds up all the bonus from the stores
		for(int i=0;i<placeHolder.length;i++)
		{
			totalBonus +=placeHolder[i];
		}
		
		return totalBonus;
	}
	
}
