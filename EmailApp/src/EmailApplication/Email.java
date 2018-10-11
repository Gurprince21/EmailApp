package EmailApplication;
import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailBoxCapacity = 6000;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "company.com";
	
	//constructor receives first and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Your email has been created, thank you " + firstName + " " + lastName);
		
		//call method to ask for department
		this.department = setDepartment();
		System.out.println("You have chosen: " + department);
		
		//call method to return random password
		password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + password);
		
		//combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + companySuffix;
		System.out.println("Your email is " + email);
	}
	
	
	private String setDepartment() {
		
		System.out.println("Enter department code:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None");
		Scanner input = new Scanner(System.in);
		int deptChoice = input.nextInt();
		System.out.println("CODE ENTERED:" + deptChoice);
		if(deptChoice == 1) {return "Sales"; }
		else if(deptChoice == 2) { return "Development"; }
		else if(deptChoice == 3) { return "Accounting"; }
		else if (deptChoice == 0) { return "None"; }
		return null;
			
	}
	
	private String randomPassword(int length) {
		String passwordSet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	// set mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailBoxCapacity = capacity;	
	}
	
	// alternate Email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;	
	}
	
	//Change password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() { return mailBoxCapacity; }
	public String getAlternateEmail() { return alternateEmail; }
	public String getPassword() { return password; }
	
	//print out all relevant info
	public String showInfo() {
		return "Display Name: " + firstName + " " + lastName + " " +
				"\nCOMPANY EMAIL: " + email + " " +
				"\nMAILBOX CAPACITY: " + mailBoxCapacity + " emails";
		
	}



}
