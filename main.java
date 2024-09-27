package Main;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Employee{
	
	private String name;
	
	private int id;
	
	public Employee(String name,int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public abstract double calculateSalary();

	@Override
	public String toString() {
		
		return "Employee [name=" + name + ", id=" + id + " , salary= "+ calculateSalary()+"]";
		
	}
	
}


class FullTimeEmployee extends Employee{
	
	private double monthlySalary;
	
	public FullTimeEmployee(String name, int id, double monthlySalary) {
	
		super(name, id);
		
		this.monthlySalary=monthlySalary;
		
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	public double calculateSalary() {
	
		// TODO Auto-generated method stub
		
		return monthlySalary;
	}

	
}

class PartatimeEmployee extends Employee{

	private int hoursWorked;
	private double hourlyRate;
	
	public PartatimeEmployee(String name, int id,int hoursWorked,int hourlyRate) {
		super(name, id);
		
		this.hoursWorked=hoursWorked;
		this.hourlyRate=hourlyRate;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateSalary() {
		// TODO Auto-generated method stub
		return hoursWorked * hourlyRate;
	}
}

class PayRollSystem {
	
	private ArrayList<Employee> employeeList;
	
	public PayRollSystem() {
		employeeList = new ArrayList<>();
	}
	
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}
	
	public void removeEmployee(int id) {
		Employee employeeToRemove = null;
		
		for(Employee employee : employeeList) {
			if(employee.getId()==id) {
				employeeToRemove = employee;
				break;
			}
		}
		if(employeeToRemove != null) {
			employeeList.remove(employeeToRemove);
		}
		
		
	}
	
	public void displayEmployees() {
		for(Employee employee: employeeList) {
			System.out.println(employee);
		}
	}
}

public class main {
	public static void main(String args[]) {
//		PayRollSystem payrollSystem = new PayRollSystem();
//		
//		FullTimeEmployee emp1 = new FullTimeEmployee("Ram",1,70000.0);
//		
//		PartatimeEmployee emp2= new PartatimeEmployee("Kanha",2,40,100);
//		
//		payrollSystem.addEmployee(emp1);
//		payrollSystem.addEmployee(emp2);
//		
//	   System.out.println("Initial Employee Details: ");
//	   payrollSystem.displayEmployees();
//	   
//	   System.out.println("Removing Employees");
//	   payrollSystem.removeEmployee(2);
//	   
//	   System.out.println("Remaining Employees Details");
//	   payrollSystem.displayEmployees();
		
        Scanner scanner = new Scanner(System.in);
        PayRollSystem payrollSystem = new PayRollSystem();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Payroll System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee by ID");
            System.out.println("3. Display All Employees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter employee type (1 for Full-Time, 2 for Part-Time): ");
                    int empType = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();

                    if (empType == 1) {
                        System.out.print("Enter Monthly Salary: ");
                        double monthlySalary = scanner.nextDouble();
                        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(name, id, monthlySalary);
                        payrollSystem.addEmployee(fullTimeEmployee);
                    } else if (empType == 2) {
                        System.out.print("Enter Hours Worked: ");
                        int hoursWorked = scanner.nextInt();
                        System.out.print("Enter Hourly Rate: ");
                        double hourlyRate = scanner.nextDouble();
                        PartatimeEmployee partTimeEmployee = new PartatimeEmployee(name, id, hoursWorked, (int) hourlyRate);
                        payrollSystem.addEmployee(partTimeEmployee);
                    } else {
                        System.out.println("Invalid employee type.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Employee ID to remove: ");
                    int removeId = scanner.nextInt();
                    payrollSystem.removeEmployee(removeId);
                    break;

                case 3:
                    System.out.println("Employee Details:");
                    payrollSystem.displayEmployees();
                    break;

                case 4:
                    exit = true;
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
		
	}
}
