package org.ease.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "EMPLOYEE_07")
@ToString
public class Employee {
	
	@Id
	@SequenceGenerator(name = "emp_id", sequenceName = "emp_id_oracle_seq", initialValue = 1000001, allocationSize = 1)
	@GeneratedValue(generator = "emp_id", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 50)
	private String  name;
	
	@Column(length = 50)
	private String job;
	
	private Double salary;
	
	@Column(length = 50)
	private String dept;
	
}
