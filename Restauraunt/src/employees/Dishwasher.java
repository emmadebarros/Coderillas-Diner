package employees;

public class Dishwasher extends Employee {

	private double wage = 15;
	
	final int hoursWorked = 8;
	
	public Dishwasher(String name, String lastName, int sin) {
		super(name, lastName, sin);
	}
	
	public double getWage() {
		return wage;
	}

	@Override
	public double paySalary() {
		
		return wage * hoursWorked;
		
	}

	@Override
	public String toString() {
		return super.toString() + " Title: Dishwasher\nWage =  " + wage + "\nHours Worked = " + hoursWorked + "\n\n";
	}

}
