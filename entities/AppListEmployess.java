package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AppListEmployess {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
				
		System.out.println("How many employees will be registered?");
		int N = sc.nextInt();
		

		for(int i = 0; i<N; i++) {
			
			System.out.println();
			System.out.println("Employee #" + (i + 1) + ":");
			System.out.print("Id: ");
			int id = sc.nextInt();
			while (hasId(list,id)) {
				System.out.println("Id already taken! Try again: ");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			Employee emp = new Employee(id, name, salary);
			
			list.add(emp);
		}
		
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int idIncrease = sc.nextInt();
		Integer position = validId(list, idIncrease);
		if(position == null) {
			System.out.println("This id does not exist!");
		}else {
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();
			list.get(position).increaseSalary(percent);
		}
		
		System.out.println();
		System.out.println("List of employees: ");
		for(Employee emp : list) {
			System.out.println(emp);
		}
		
		sc.close();
	}
	
	public static Integer validId(List<Employee> list, int id) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
		
	}
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}
