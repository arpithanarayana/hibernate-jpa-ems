package com.te.ems.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name="bankaccount_tbl")
public class BankAccount {
	@Column(name="bank_account_number")
	@Id
	private String bankAccountNumber;
	@Column(name="bank_ifsc")
	private String bankIFSC;
	
	//Bidirectional
	@OneToOne(mappedBy = "bankAccount",cascade = CascadeType.ALL)
	private Employee employee;
	
	

}
