import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: represents many operations applied to a two dimensional array
 * Due: 05/01/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Ifte Maksud
*/

public class TwoDimRaggedArrayUtility {
	

	
	public TwoDimRaggedArrayUtility()
	{
		
	}
	
	public static double[][] readFile(File file) throws FileNotFoundException
	{
		Scanner reader = new Scanner(file);
		
		//determines the number of rows
		int numberOfRow = 0;
		
		//a place Holder to copy the elements and the number of rows and columns
		String[][] temporaryArray = new String [10][10] ;
		while(reader.hasNextLine())
		{
			//splits the elements into an array depending on where the spaces are located
			String[] fileRow = reader.nextLine().split(" ");
			
			//creates a new column length
			temporaryArray[numberOfRow] = new String[fileRow.length];
			
			//copy every element from that row to the place holder array
			for(int i=0;i<fileRow.length;i++)
			{
				temporaryArray[numberOfRow][i] = fileRow[i];
			}
			numberOfRow++;
		}
		
		double[][] realArray = new double[numberOfRow][];
		
		//the loops iterates depending on how many rows that the place Holder array had
		for(int i=0;i<numberOfRow;i++)
		{
			//creates the length for the column 
			realArray[i] = new double[temporaryArray[i].length];
			
			//convert the string value into a double and store it into the actual array
			for(int j=0;j<temporaryArray[i].length;j++)
			{
				realArray[i][j] = Double.parseDouble(temporaryArray[i][j]);
			}
		}
		
		reader.close();
		
		return realArray;
		
	}
	
	public static void writeToFile(double[][]data, File file) throws IOException
	{
		PrintWriter fileWriter = new PrintWriter(file);
		
		//goes through all the element of the array
		for(int i=0;i<data.length;i++)
		{
			for(int j=0;j<data[i].length;j++)
			{
				//writes the element while each separated by a space
				fileWriter.print(data[i][j]+" ");
			}
			fileWriter.println();
		}
		
		
		fileWriter.close();
	}
	
	public static double getTotal(double[][]data)
	{
		double total= 0;
		
		for(int row = 0;row<data.length;row++)
		{
			for(int col=0;col<data[row].length;col++)
			{
				total+= data[row][col];
			}
		}
		
		return total;
	}
	
	public static double getAverage(double[][] data)
	{
		//the average of the elements
		double average = 0;
		
		//tracks how many elements are there
		int elements = 0;
		for(int i=0;i<data.length;i++)
		{
			for(int j=0;j<data[i].length;j++)
			{
				average +=data[i][j];
				elements++;
			}
		}
		
		//divides average by the amount of elements tracked in the array
		average = average / elements;
		
		return average;
	}
	
	//returns the sum of elements in a specific row
	public static double getRowTotal(double[][] data, int row)
	{
		double rowSum = 0;
		
		// go through the column's of the specified row
		for(int col = 0;col<data[row].length;col++)
		{
			rowSum +=data[row][col];
		}
		
		return rowSum;
	}
	
	public static double getColumnTotal(double[][] data, int col)
	{
		//the total for specified column
		double columnTotal = 0;
		
		//iterates through the rows while on the same column
		for(int row = 0;row<data.length;row++)
		{
			//if the length at the row is greater than the index of column,
			//it's Guaranteed that there is an element 
			if(data[row].length>col)
			{
				columnTotal +=data[row][col];
			}
		}
		
		return columnTotal;
	}
	
	//returns the maximum element of the array
	public static double getHighestInArray(double[][] data)
	{
		// stores the first value in the two dimensional array as the maximum
		double maximum = data[0][0];
		
		for(int row=0;row<data.length;row++)
		{
			// if the other element in the array is greater than the current maximum
			// store the new maximum at that index
			for(int col = 0;col<data[row].length;col++)
			{
				if(data[row][col] > maximum)
				{
					maximum = data[row][col];
				}
			}
		}
		
		return maximum;
	}
	
	//returns the highest element in the specified row 
	public static double getHighestInRow(double[][]data, int row)
	{
		//stores the first element in the specified row
	double maximum = data[row][0];
		
		
		//if the other elements in the specified row is greater than the current maximum
		//set the maximum to that new element
		for(int col=0;col<data[row].length;col++)
		{
			if(data[row][col] > maximum)
			{
				maximum = data[row][col];
			}
		}
		
		return maximum;
	}
	
	//returns the highest element's index in the specified row 
	public static int getHighestInRowIndex(double[][]data,int row)
	{
		//stores the first element in the specified row
		double maximum = data[row][0];
		
		int highestIndex = 0;
		
		//if the other elements in the specified row is greater than the current maximum
		//set the maximum to that new element and track the index
		for(int col=0;col<data[row].length;col++)
		{
			if(data[row][col] > maximum)
			{
				maximum = data[row][col];
				highestIndex = col;
			}
		}
		
		return highestIndex;
		
	}
	
	//returns the lowest element in the array
	public static double getLowestInRow(double[][]data, int row)
	{
		double lowest = data[row][0];
		
		//if an element is lower than the current lowest value, set the new lowest to that value
		for(int col=0;col<data[row].length;col++)
		{
			if(data[row][col] <lowest)
			{
				lowest = data[row][col];
			}
		}
		
		return lowest;
		
		
	}
	
	//returns the an element's lowest index of a specified row
	public static int getLowestInRowIndex(double[][]data,int row)
	{
		//stores the first element in the specified row
		double lowest = data[row][0];
		
		int lowestIndex = 0;
		
		//if an element is lowest than the current lowest value, set that to the new lowest value
		//and track its index
		for(int col=0;col<data[row].length;col++)
		{
			if(data[row][col] < lowest)
			{
				lowest = data[row][col];
				lowestIndex = col;
			}
		}
		
		return lowestIndex;
		
	}
	
	//returns the highest element in a specified column
	public static double getHighestInColumn(double[][]data,int col)
	{
		double maximum = data[0][col];
		
		for(int row = 0;row<data.length;row++)
		{
			//if the element in the column exist and its higher than the maximum
			//set the new maximum to this index
			if(data[row].length>col && data[row][col] > maximum)
			{
				maximum =data[row][col];
			}
		}
		
		return maximum;
	}
	
	//returns the highest element's index in a specified column
	public static int getHighestInColumnIndex(double[][]data,int col)
	{
		double maximum = data[0][col];
			
		int highestIndex = 0;
		for(int row = 0;row<data.length;row++)
		{
			//if the element in the column exist and its higher than the maximum
			//set the new maximum to this index and track its index
			if(data[row].length>col && data[row][col] > maximum)
			{
				maximum =data[row][col];
				highestIndex = row;
			}
		}
			
		return highestIndex;
	}
	
	//returns the lowest element in a specified column
	public static double getLowestInColumn(double[][]data,int col)
	{
		double lowest = data[0][col];
			
		for(int row = 0;row<data.length;row++)
		{
			//if the element in the column exist and its lower than the lowest value,
			//set the new lowest to this index
			if(data[row].length>col && data[row][col] < lowest)
			{
				lowest =data[row][col];
			}
		}
			
		return lowest;
	}
	
	//returns the lowest element's index in a specified column
	public static int getLowestInColumnIndex(double[][]data,int col)
	{
		double lowest = data[0][col];
				
		int lowestIndex = 0;
		for(int row = 0;row<data.length;row++)
		{
			//if the element in the column exist and its lower than the lowest value,
			//set the new lowest to this index and track its index
			if(data[row].length>col && data[row][col] < lowest)
			{
				lowest =data[row][col];
				lowestIndex = row;
			}
		}
				
		return lowestIndex;
	}
	
	//returns the lowest element of the array
	public static double getLowestInArray(double[][] data)
	{
	// stores the first value in the two dimensional array as the lowest value
		double lowest = data[0][0];
			
		for(int row=0;row<data.length;row++)
		{
			// if the an element in the array is lower than the current lowest value,
			// store the new lowest at that index
			for(int col = 0;col<data[row].length;col++)
			{
				if(data[row][col] < lowest)
				{
					lowest = data[row][col];
				}
			}
		}
			
		return lowest;
	}
	
	
		
		
	
	
	
	
}
