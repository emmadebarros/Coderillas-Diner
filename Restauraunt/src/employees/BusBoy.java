package employees;

public class BusBoy extends Employee{

	private double wage = 11.25;
	
	final int hoursWorked = 8;

	public BusBoy(String name, String lastName, int sin) {
		super(name, lastName, sin);
	}

	public double getWage() {
		return wage;
	}

	@Override
	public double paySalary() {
		
		return (wage * hoursWorked);
		
	}
	
	@Override
	public String toString() {
		return super.toString() + " Title: Busboy\nWage =  " + wage + "\nHours Worked = " + hoursWorked+ "\n\n";
	}

}
