package com.te.ems.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.te.ems.entity.Address;
import com.te.ems.entity.Employee;
import com.te.ems.entity.Technology;

public class EmployeeRepository {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MySQL01");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	// TODO : to create a method that inserts employee data in the database
	public int insertEmployee(Employee employee) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee.getEmployeeId();
	}

	// TODO : create a method to get employee data from database
	public Employee getEmployeeByID(int employeeID) {
		return entityManager.getReference(Employee.class, employeeID);
	}

	public Employee getEmployeeByID_(int employeeID) {
		return entityManager.find(Employee.class, employeeID);
	}

//	public int addTechnology(int employeeId, String technologyName) {
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		Employee employeeFromDb = entityManager.getReference(Employee.class, employeeId);
//		employeeFromDb.getTechnologies().add(Technology.builder().technologyName(technologyName).build());
//		entityManager.persist(employeeFromDb);
//		entityTransaction.commit();
//		return employeeFromDb.getEmployeeId();
//	}

	// TODO : update Technology
	public int updateEmployeeEmail(int employeeId, String employeeEmailId) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Employee employeeDb = entityManager.getReference(Employee.class, employeeId);
		employeeDb.setEmployeeEmailId(employeeEmailId);
		entityManager.persist(employeeDb);
		entityTransaction.commit();
		return employeeDb.getEmployeeId();

	}
	
	public String updateTechnology(int employeeId, String technologyName, String newTechnology) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Employee employeeDb = entityManager.getReference(Employee.class, employeeId);
		List<Technology> technologies = employeeDb.getTechnologies();
		for (Technology technology : technologies) {
            if (technologyName.contains(technology.getTechnologyName())) {
            	technology.setTechnologyName(newTechnology);
            }
        }
		entityManager.persist(employeeDb);
		entityTransaction.commit();
		return "update the technology sucessfully";
	}

	public String updateCity(int employeeId, String addressCity, String newCity) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Employee employeeDb = entityManager.getReference(Employee.class, employeeId);
		List<Address> addresses = employeeDb.getAddresses();
        for (Address address : addresses) {
            if (addressCity.contains(address.getAddressCity())) {
                address.setAddressCity(newCity);
            }
        }
		entityManager.persist(employeeDb);
		entityTransaction.commit();
		return "update the data sucessfully";
	}

	// fetech the list of employee working in java
	public List<Employee> getDetailsOfEmployee(String technologyName) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Technology technology = entityManager.getReference(Technology.class, technologyName);
		if (technology.getTechnologyName().equalsIgnoreCase("java")) {
			List<Employee> employees = technology.getEmployees();
			entityTransaction.commit();
			return employees;
		} else {
			return null;
		}

	}

	// TODO : delete Technology
}
