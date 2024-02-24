package assignment2;


/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: build attributes of the medical procedure performed to the patient
 * Due: 2/23/2024
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ifte Maksud
*/
public class Procedure {
	private String procedure;
	private String procedureDate;
	private String practitioner;
	private double price;
	
	public Procedure()
	{
		
	}
	
	public Procedure(String procedure, String procedureDate)
	{
		this.procedure = procedure;
		this.procedureDate = procedureDate;
	}
	
	public Procedure(String procedure, String procedureDate, String practitioner
			, double price)
	{
		this.procedure = procedure;
		this.procedureDate = procedureDate;
		this.practitioner = practitioner;
		this.price = price;
	}
	
	public String getProcedure()
	{
		return procedure;
	}
	
	public String getProcedureDate()
	{
		return procedureDate;
	}
	
	public String getPractitioner()
	{
		return practitioner;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setProcedure(String procedure)
	{
		this.procedure = procedure;
	}
	
	public void setProcedureDate(String procedureDate)
	{
		this.procedureDate = procedureDate;
	}
	
	public void setPractitioner(String practitioner)
	{
		this.practitioner = practitioner;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public String toString()
	{
		return "\tProcedure: "+procedure + "\n\tProcedureDate: "+procedureDate + "\n\tPractioner: "
				+ practitioner + "\n\tCharge: " + price;
	}
}
