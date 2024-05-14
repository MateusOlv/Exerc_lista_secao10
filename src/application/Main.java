package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
				
		System.out.print("How many employees do you want to register? ");
		int n = sc.nextInt();
		
		List<Employee> list = new ArrayList<>();
		
		for(int i = 0 ; i < n ; i++) {
			System.out.printf("\nEmployee #%d\n", i+1);
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			Employee employee = new Employee(id, name, salary);
			list.add(employee);
		}
		
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int idSal = sc.nextInt();
		Integer pos = position(list, idSal);
		if(pos == null) {
			System.out.println("This id doesn't exist!");
		} else {
			System.out.print("Enter the percentage: ");
			Double perc = sc.nextDouble();
			list.get(pos).salaryIncrease(perc);
		}
				
		System.out.println();
		System.out.println("List of employees:");
		for(Employee emp : list) {
			System.out.println(emp);
		}
		
		sc.close();
	}
	
	//Auxiliar function to check if the id exists
	public static Integer position(List <Employee> list, int id) {
		for(int i = 0 ; i < list.size() ; i++) {
			if(list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}

}
