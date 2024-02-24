package assignment2;

/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Create objects of the Procedure and Patient class. Print their attributes afterwards
 * Due: 2/23/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ifte Maksud
*/


public class PatientDriverApp {

	public static void main(String[] args) {
		Patient patientTest = new Patient("Ifte","Muhammad","Maksud", "117 cat", "Gburg"
				,"MD",20756,"301-483-8102","helper", "911");
		
		
		Procedure firstMedicalProcedure = new Procedure();
		
		firstMedicalProcedure.setProcedure("x-ray");
		
		firstMedicalProcedure.setProcedureDate("1/01/2024");
		
		firstMedicalProcedure.setPractitioner("mary levy");
		
		firstMedicalProcedure.setPrice(1568.00);
		
		Procedure secondMedicalProcedure = new Procedure("physical check","2/23/2024");
		
		secondMedicalProcedure.setPractitioner("keny hill");
		
		secondMedicalProcedure.setPrice(805.12);
		
		Procedure thirdMedicalProcedure = new Procedure("covid test", "2/26/2024", "dr.lee",40.35);
		
		displayPatient(patientTest);
		
		System.out.println();
		
		displayProcedure(firstMedicalProcedure);
		
		System.out.println();
		
		displayProcedure(secondMedicalProcedure);
		
		System.out.println();
		
		displayProcedure(thirdMedicalProcedure);
		
		System.out.println();
		
		double totalPrice = calculateTotalCharges(firstMedicalProcedure, secondMedicalProcedure, thirdMedicalProcedure);
		
		System.out.printf("Total price: $%.2f",totalPrice);
		
		System.out.println();
		
		System.out.println();
		
		System.out.println("Student Name: this program was made by Ifte Maksud");
		
		System.out.println("MC#: M21165162");
		
		System.out.println("Due Date: 2/23/2024");
		
		
		

	}
	
	public static void displayPatient(Patient member)
	{
		System.out.println(member);
		
	}
	
	public static void displayProcedure(Procedure medicalOperation)
	{
		System.out.println(medicalOperation);
	}
	
	public static double calculateTotalCharges(Procedure first, Procedure second, Procedure third)
	{
		return first.getPrice() + second.getPrice() + third.getPrice();
	}

}
