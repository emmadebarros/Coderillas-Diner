package employees;

public class Waiter extends Employee{
	
	private double wage = 11.50;
	
	final int hoursWorked = 8;

	public Waiter(String name, String lastName, int sin) {
		super(name, lastName, sin);
	}
	
	public double getWage() {
		return wage;
	}

	@Override
	public double paySalary() {
		
		return (hoursWorked * wage);
		
	}

	@Override
	public String toString() {
		return super.toString() + " Title: Waiter\nWage =  " + wage + "\nHours Worked = " + hoursWorked + "\n\n";
	}
	
}
