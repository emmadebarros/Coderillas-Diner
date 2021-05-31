package employees;

public class Chef extends Employee{
	
	private double wage = 12;
	
	final int hoursWorked = 8;

	public Chef(String name, String lastName, int sin) {
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
		return super.toString() + " Title: Chef\nWage =  " + wage + "\nHours Worked = " + hoursWorked + "\n\n";
	}

}
