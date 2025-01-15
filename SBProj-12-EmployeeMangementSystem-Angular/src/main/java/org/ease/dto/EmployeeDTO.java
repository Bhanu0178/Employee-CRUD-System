package org.ease.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
	private Long id;
	private String  name;
	private String job;
	private Double salary;
	private String dept;
}
