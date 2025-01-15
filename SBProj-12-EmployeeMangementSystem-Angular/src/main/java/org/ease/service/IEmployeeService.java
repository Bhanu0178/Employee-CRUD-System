package org.ease.service;

import java.util.List;

import org.ease.dto.EmployeeDTO;

public interface IEmployeeService {
	EmployeeDTO addEmployee(EmployeeDTO dto);
	List<EmployeeDTO> getAllEmployees();
	EmployeeDTO getEmployeeById(Long id);
	void deleteEmployeeById(Long id);
	EmployeeDTO updateEmployee(EmployeeDTO dto);
}
