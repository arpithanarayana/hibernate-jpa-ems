package com.te.ems;

import java.util.ArrayList;
import java.util.List;

import com.te.ems.entity.Address;
import com.te.ems.entity.BankAccount;
import com.te.ems.entity.Employee;
import com.te.ems.entity.Technology;
import com.te.ems.repository.EmployeeRepository;

public class Application {
	public static void main(String[] args) {
		EmployeeRepository employeeRepository = new EmployeeRepository();
		
//		Address address1 = Address.builder().addressCity("city3").addressState("state3").build();
//		Address address2 = Address.builder().addressCity("city4").addressState("state4").build();
//		
//		BankAccount bankAccount = BankAccount.builder().bankIFSC("efc123").bankAccountNumber("7894561231").build();
//		
//		List<Address> addresses = new ArrayList<Address>();
//		addresses.add(address1);
//		addresses.add(address2);
//		
//		
//		Technology tech1 = Technology.builder().technologyName("java").build();
//		Technology tech2 = Technology.builder().technologyName("python").build();
//		
//		List<Technology> technologies1 = new ArrayList<Technology>();
//		technologies1.add(tech1);
//		technologies1.add(tech2);
		
//		Employee employee = Employee.builder()
//		.employeeEmailId("abc@gmail.com")
//		.employeeName("john")
//		.bankAccount(bankAccount)
//		.addresses(addresses)
//		.technologies(technologies1)
//		.build();
		
//		Employee employee = new Employee();
//		employee.setEmployeeName("king");
//		employee.setEmployeeEmailId("king@gmail.com");
//		employee.setAddresses(addresses);
//		employee.setBankAccount(bankAccount);
//		employee.setTechnologies(technologies1);
//		
//		List<Employee> employees = new ArrayList<Employee>();
//		employees.add(employee);
//		
//		tech1.setEmployees(employees);
//		tech2.setEmployees(employees);
//		address1.setEmployee(employee);
//		address2.setEmployee(employee);
//		bankAccount.setEmployee(employee);
//		
//		int insertEmployee = employeeRepository.insertEmployee(employee);
//		System.out.println("Employeeid added number: " + insertEmployee);
		
//		employeeRepository.addTechnology(insertEmployee, "C#");
//		
//		employeeRepository.updateEmployeeEmail(1, "john@gmail.com");
//		
		employeeRepository.updateCity(1, "city2", "mysore");
		
		employeeRepository.updateTechnology(1, "java", "python");
		
//		Employee e2 = employeeRepository.getEmployeeByID_(1);
//		System.out.println(e2);
//		
//		System.out.println("=========================================");
//		Employee e1 = employeeRepository.getEmployeeByID(1);
//		System.out.println(e1);
		
		List<Employee> detailsOfEmployee = employeeRepository.getDetailsOfEmployee("java");
		for(Employee employee: detailsOfEmployee) {
			System.out.println(employee);
		}
		
	}

}
