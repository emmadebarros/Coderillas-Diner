package employees;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Payroll {
	
	//In progress...
	
	protected ArrayList<Employee> employeeList = new ArrayList<>();

	//test change it depending on the number of employees at the end
	public Payroll(Employee emp1, Employee emp2, Employee emp3, Employee emp4, Employee emp5, Employee emp6, Employee emp7, Employee emp8, Employee emp9, Employee emp10, Employee emp11, Employee emp12, Employee emp13, Employee emp14, Employee emp15, Employee emp16, Employee emp17, Employee emp18, Employee emp19, Employee emp20)
	{
		
		this.employeeList.add(emp1);		
		this.employeeList.add(emp2);		
		this.employeeList.add(emp3);		
		this.employeeList.add(emp4);		
		this.employeeList.add(emp5);		
		this.employeeList.add(emp6);		
		this.employeeList.add(emp7);		
		this.employeeList.add(emp8);		
		this.employeeList.add(emp9);		
		this.employeeList.add(emp10);		
		this.employeeList.add(emp11);		
		this.employeeList.add(emp12);		
		this.employeeList.add(emp13);		
		this.employeeList.add(emp14);		
		this.employeeList.add(emp15);		
		this.employeeList.add(emp16);		
		this.employeeList.add(emp17);		
		this.employeeList.add(emp18);		
		this.employeeList.add(emp19);		
		this.employeeList.add(emp20);
		
	}
	
	//Daily Salary
	public void getPayed() throws Exception {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		for(int i = 0; i < employeeList.size(); i++) {
			
			System.out.print(employeeList.get(i).getFullName() + ", how much tip did you make today? (Enter -1 to exit payroll) : ");
			
			try {
				double tip = input.nextDouble();			
				
				if(tip < -1) {		
					
					System.out.println("Sorry you typed a number less than -1 please try again");
					i--;
					continue;
				}
				
				if(tip == -1) {
					
					break;
					
				}
				if(tip > 100000) {
					System.out.println(":O You won the lottery!!!?");
				}
				
				System.out.printf("%s, your salary for the day is : %.2f$ (TIP included)\n", employeeList.get(i).getFullName(),(employeeList.get(i).paySalary() + tip));
				System.out.println();
			}
			
			catch (InputMismatchException y) {
                System.out.println("You entered a letter or symbol, please try again");
                input.nextLine();
                i--;
            }
			
		}

	}

	@Override
	public String toString() {
//		return "Payroll employeeList= " + employeeList ;
		 for(int i = 0 ;i < 20; i++) {
			  System.out.println(employeeList.get(i));
		}
		 return "";
	}
	
//  Comparators??
	

}
