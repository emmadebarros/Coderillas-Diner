package employees;

public class ParttimeBusBoy extends Employee{
	
	private double wage = 11;
	
	private double hoursWorked;

	public ParttimeBusBoy(String name, String lastName, int sin, double hoursWorked) {
		super(name, lastName, sin);
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
		return super.toString() + " Title: Part-time Busboy\nWage =  " + wage + "\nHours Worked = " + hoursWorked + "\n\n";
	}

}
