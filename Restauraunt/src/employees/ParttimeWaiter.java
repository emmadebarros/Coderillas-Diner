package employees;

public class ParttimeWaiter extends Employee{
	
	private double wage = 11.25;
	
	private double hoursWorked;

	public ParttimeWaiter(String name, String lastName, int sin, double hoursWorked) {
		super(name, lastName, sin);
		this.hoursWorked = hoursWorked;
	}

	@Override
	public double paySalary() {
		
		return (wage * hoursWorked);
		
	}

	@Override
	public String toString() {
		return super.toString() + " Title: Part-time Waiter\nWage =  " + wage + "\nHours Worked = " + hoursWorked + "\n\n";
	}

}
