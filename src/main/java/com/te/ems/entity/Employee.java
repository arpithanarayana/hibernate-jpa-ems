package com.te.ems.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@ToString
@Builder
@Entity
@Table(name= "employee_tbl")
public class Employee {
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer employeeId;
	@Column(name = "employee_name")
	private String employeeName;
	@Column(name = "employee_emailId", unique = true)
	private String employeeEmailId;
	
	//Bidirectional
	@JoinColumn(name= "back_account_fk")
	@OneToOne(cascade = CascadeType.ALL)
	private BankAccount bankAccount;
	
	//Bidirectional
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Address> addresses;
	
	//Bidirectional
	@JoinTable(name="emp_tech_fk", 
			joinColumns = @JoinColumn(name = "emp_fk"),
			inverseJoinColumns = @JoinColumn(name = "tech_fk"))
	@ManyToMany(cascade = CascadeType.ALL)
	
	//@JoinColumns)
	private List<Technology> technologies = new ArrayList<>();
	

}
