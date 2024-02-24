package assignment2;


/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: build personal information of the patient that is receiving medical procedure
 * Due: 2/23/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ifte Maksud
*/
public class Patient {
	private String firstName;
	private String middleName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private int zipCode;
	private String phoneNumber;
	private String emergencyName;
	private String emergencyPhoneNumber;
	
	public Patient()
	{
		
	}
	
	public Patient(String firstName, String middleName, String lastName)
	{
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		
	}
	
	public Patient(String firstName, String middleName, String lastName, String streetAddress
			, String city, String state, int zipCode, String phoneNumber, String emergencyName
			, String emergencyPhoneNumber)
	{
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state= state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.emergencyName = emergencyName;
		this.emergencyPhoneNumber = emergencyPhoneNumber;
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public String getlastName() {
		return lastName;
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public int getZipCode() {
		return zipCode;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getEmergencyName() {
		return emergencyName;
	}
	
	public String getEmergencyPhoneNumber()
	{
		return emergencyPhoneNumber;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setState(String state) {
		this.state= state;
	}
	
	public void setZipCode(int zipCode)
	{
		this.zipCode = zipCode;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public void setEmergencyContact(String emergencyName)
	{
		this.emergencyName = emergencyName;
	}
	
	public void setEmergencyPhoneNumber(String emergencyPhoneNumber)
	{
		this.emergencyPhoneNumber = emergencyPhoneNumber;
	}
	
	public String buildFullName()
	{
		return firstName +" "+middleName+" "+lastName;
	}
	
	public String buildAddress()
	{
		return streetAddress + " " + city + " " + state + " " + zipCode;
	}
	
	public String buildEmergencyContact()
	{
		return emergencyName + " " + emergencyPhoneNumber;
	}
	
	public String toString()
	{
		return "Patient info:\n Name: "+buildFullName() + "\n Address: " +buildAddress() + "\n EmergencyContact: " +
	buildEmergencyContact();
	}
	
}
