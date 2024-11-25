import java.io.*;
import java.util.Scanner;

/*
 * Class: CMSC203 
 * Instructor: Professor Eivazi
 * Description: different operations which can be useful on calculating the holiday bonus
 * Due: 11/24/24
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Ifte Maksud
*/
public class TwoDimRaggedArrayUtility {

	public TwoDimRaggedArrayUtility() {

	}
	
	public static double[][] readFile(File file) throws FileNotFoundException
	{
		//scanner to read the file
		Scanner input = new Scanner(file);
		
		//creates a place holder to determine the number of rows and columns from the file
		String [][] temporaryArray = new String[10][10];
		
		int numOfRows = 0;
		while(input.hasNextLine())
		{
			//Converts the line of data into a String array 
			//for each line
			String [] row = input.nextLine().split(" ");
			
			//resizes the column length of the place holder array to the length of the array which was converted into a String array(row)
			temporaryArray[numOfRows] = new String[row.length];
			
			//copies the data of each element from the current line
			for(int i=0;i<row.length;i++)
			{
				temporaryArray[numOfRows][i] = row[i];
			}
			
			//increments the numOfRows after each line is finished(this will determine how many rows there are depending on the hasNextLine method)
			numOfRows++;
		}
		
		//represents the real array which will copy the data from the place holder array
		//Initializes the total rows from the  temporary array
		double [][] realArray = new double[numOfRows][];
		
		for(int i=0;i< numOfRows;i++)
		{
			//sets the column length from the placeholder array
			realArray[i]  = new double[temporaryArray[i].length];
			
			//each time an element is copied, it must be converted into a double
			//since the place holder array was of type String
			for(int j=0;j<temporaryArray[i].length;j++)
			{
				realArray[i][j] = Double.parseDouble(temporaryArray[i][j]);
			}
		}
		
		input.close();
		
		return realArray;
	}
	
	//writes the data from the file
	public static void writeToFile(double [][] data, File outputFile) throws FileNotFoundException
	{
		PrintWriter writer = new PrintWriter(outputFile);
		
		for(int i=0;i<data.length;i++)
		{
			for(int j=0;j<data[i].length;j++)
			{
				writer.print(data[i][j] + " ");;
			}
			
			System.out.println();
		}
		
		writer.close();
	}

	// returns the sum of all the elements in the array
	public static double getTotal(double[][] data) {
		double total = 0.0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				total += data[i][j];
			}
		}

		return total;
	}

	public static double getAverage(double[][] data) {
		int count = 0;
		double sum = 0.0;

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				sum += data[i][j];
				count++;
			}
		}

		return sum / count;
	}

	// returns the total from the selected row
	public static double getRowTotal(double[][] data, int row) {
		double rowTotal = 0.0;
		for (int i = 0; i < data[row].length; i++) {
			rowTotal += data[row][i];
		}

		return rowTotal;
	}

	// returns the total from the selected column
	public static double getColumnTotal(double[][] data, int col) {
		double colTotal = 0.0;

		for (int i = 0; i < data.length; i++) {
			// if the length of the row is greater than the selected column, we can be sure
			// there is a number at that column
			if (data[i].length > col) {
				colTotal += data[i][col];
			}
		}

		return colTotal;
	}

	//returns the element that is the highest from all other elements in the selected row
	public static double getHighestInRow(double[][] data, int row) {
		double maximum = data[row][0];

		for (int i = 0; i < data[row].length; i++) {
			// if the selected element in the row is greater than the current maximum
			// set the new maximum to that index
			if (data[row][i] > maximum) {
				maximum = data[row][i];
			}
		}

		return maximum;
	}

	//returns the index of the highest element in the selected row
	public static int getHighestInRowIndex(double[][] data, int row) {
		double maximum = data[row][0];
		
		int highestRowIndex = 0;
		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] > maximum) {
				maximum = data[row][i];
				highestRowIndex = i;
			}
		}
		
		return highestRowIndex;	
	}
	
	//return the element that is the lowest from all other elements in the selected row
	public static double getLowestInRow(double[][] data, int row) {
		double minimum = data[row][0];

		for (int i = 0; i < data[row].length; i++) {
			// if the selected element in the row is lower than the current minimum
			// set the new minimum to that index
			if (data[row][i] < minimum) {
				minimum = data[row][i];
			}
		}

		return minimum;
	}
	
	//returns the index of the lowest element in the selected row
	public static int getLowestInRowIndex(double[][] data, int row) {
		double minimum = data[row][0];
		
		int lowestRowIndex = 0;
		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] < minimum) {
				minimum = data[row][i];
				lowestRowIndex = i;
			}
		}
		
		return lowestRowIndex;	
	}
	
	//returns the element that is the highest from all other elements in the selected column
	public static double getHighestInColumn(double[][] data, int col)
	{
		double maximum = 0.0;
		
		//for the purpose of getting a element
		for(int i=0;i<data.length;i++)
		{
			if(data[i].length > col)
			{
				maximum = data[i][col];
				
				//checks if i is at the last element.
				//if so, returns the maximum
				if(i == data.length-1)
				{
					return maximum;
				}
				break;
			}
		}
		
		//iterates through the column a second time, while knowing there is an existing maximum
		for(int i=0;i<data.length;i++)
		{
			if(data[i].length> col)
			{
				//once it's guaranteed there is an element at this column
				//it checks if the element is greater than the current maximum
				if(data[i][col] > maximum)
				{
					maximum = data[i][col];
				}
			}
		}
		
		return maximum;
	}
	
	public static int getHighestInColumnIndex(double[][] data, int col)
	{
		double maximum = 0.0;
		int highestColIndex = 0;
		//for the purpose of getting a element
		for(int i=0;i<data.length;i++)
		{
			if(data[i].length > col)
			{
				maximum = data[i][col];
				highestColIndex = i;
				
				//checks if i is at the last element.
				//if so, returns the maximum
				if(i == data.length-1)
				{
					return highestColIndex;
				}
				break;
			}
		}
		
		//iterates through the column a second time, while knowing there is an existing maximum
		for(int i=0;i<data.length;i++)
		{
			if(data[i].length> col)
			{
				//once it's guaranteed there is an element at this column
				//it checks if the element is greater than the current maximum
				if(data[i][col] > maximum)
				{
					maximum = data[i][col];
					highestColIndex = i;
				}
			}
		}
		
		return highestColIndex;
	}
	
	public static double getLowestInColumn(double[][] data, int col)
	{
		double minimum = 0.0;
		
		//for the purpose of getting a element
		for(int i=0;i<data.length;i++)
		{
			if(data[i].length > col)
			{
				minimum = data[i][col];
				
				//checks if i is at the last element.
				//if so, returns the minimum
				if(i == data.length-1)
				{
					return minimum;
				}
				break;
			}
		}
		
		//iterates through the column a second time, while knowing there is an existing minimum
		for(int i=0;i<data.length;i++)
		{
			if(data[i].length> col)
			{
				//once it's guaranteed there is an element at this column
				//it checks if the element is lower than the current minimum
				if(data[i][col] < minimum)
				{
					minimum = data[i][col];
				}
			}
		}
		
		return minimum;
	}
	
	public static int getLowestInColumnIndex(double[][] data, int col)
	{
		double minimum = 0.0;
		int lowestColIndex = 0;
		//for the purpose of getting a element
		for(int i=0;i<data.length;i++)
		{
			if(data[i].length > col)
			{
				minimum = data[i][col];
				lowestColIndex = i;
				//checks if i is at the last element.
				//if so, returns the minimum
				if(i == data.length-1)
				{
					return lowestColIndex;
				}
				break;
			}
		}
		
		//iterates through the column a second time, while knowing there is an existing minimum
		for(int i=0;i<data.length;i++)
		{
			if(data[i].length> col)
			{
				//once it's guaranteed there is an element at this column
				//it checks if the element is lower than the current minimum
				if(data[i][col] < minimum)
				{
					minimum = data[i][col];
					lowestColIndex = i;
				}
			}
		}
		
		return lowestColIndex;
	}
	
	//returns the highest element from the entire 2D array
	public static double getHighestInArray(double[][] data) {
		double maximum = data[0][0];

		for (int i = 0; i < data.length; i++) {
			for(int j=0; j< data[i].length;j++)
			{
				if(data[i][j] > maximum)
				{
					maximum  = data[i][j];
				}
			}
		}

		return maximum;
	}
	
	//returns the lowest element from the entire 2D array
	public static double getLowestInArray(double[][] data) {
		double minimum = data[0][0];

		for (int i = 0; i < data.length; i++) {
			for(int j=0; j< data[i].length;j++)
			{
				if(data[i][j] < minimum)
				{
					minimum  = data[i][j];
				}
			}
		}

		return minimum;
	}
	
}
