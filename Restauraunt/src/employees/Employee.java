package employees;

//import java.util.Scanner;

public abstract class Employee {

	private String name;

	private String lastName;

	private int sin;

	public Employee(String name, String lastName, int sin) {
		this.name = name;
		this.lastName = lastName;
		this.sin = sin;

	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getFullName() {
		
		return name + " " + lastName;
		
	}

	public int getSin() {
		return sin;
	}

	@Override
	public String toString() {
		return "Employee\nName:  " + name + ", Last name: " + lastName + ", SIN =  " + sin;
	}
	
	public abstract double paySalary();
	
	//Jess for punchIn punchOut??

//	public void punchIn() {
//
//		Scanner input = new Scanner(System.in);
//		
//		//Store the var inside the scope of the method because I don't want to do anything with them for now
//		System.out.print("Enter time (hour): ");
//		int hourStart = input.nextInt();
//		System.out.print("Enter time (minutes): ");
//		int minStart = input.nextInt();
//		System.out.println("Have a good shift!");
//
//	}
//
//	public void punchOut() {
//
//		Scanner input = new Scanner(System.in);
//
//		System.out.print("Enter time: ");
//		
//		int hourEnd = input.nextInt();
//		System.out.print("Enter time: ");
//		int minEnd = input.nextInt();
//		System.out.println("Thank you for your service, see you soon!");
//
//	} 

}
