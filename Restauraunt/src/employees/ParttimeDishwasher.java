package employees;

public class ParttimeDishwasher extends Employee{
	
	private double wage = 11;
	
	private double hoursWorked;

	public ParttimeDishwasher(String name, String lastName, int san, double hoursWorked) {
		super(name, lastName, san);
		this.hoursWorked = hoursWorked;
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
		return super.toString() + " Title: Part-time Dishwasher\nWage =  " + wage + "\nHours Worked = " + hoursWorked + "\n\n";
	}

}
