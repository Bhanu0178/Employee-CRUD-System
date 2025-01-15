package org.ease.service.impl;

import static org.ease.constants.AppConstants.EMPLOYEE_NOT_FOUND_WITH_ID;

import java.util.List;

import org.ease.dto.EmployeeDTO;
import org.ease.entity.Employee;
import org.ease.mapper.EmployeeMapper;
import org.ease.repository.IEmployeeRepository;
import org.ease.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepository repo;

	@Autowired
	private EmployeeMapper empMapper;

	@Override
	public EmployeeDTO addEmployee(EmployeeDTO dto) {
		Employee entity = empMapper.dtoToEntity(dto);
		EmployeeDTO empDTO = empMapper.entityToDto(repo.save(entity));
		return empDTO;
	}// addEmployee

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> entities = repo.findAll();
		return empMapper.entitysToDtos(entities);
	}// getAllEmployees

	@Override
	public EmployeeDTO getEmployeeById(Long id) {
		return empMapper.entityToDto(
				repo.findById(id).orElseThrow(() -> new IllegalArgumentException(EMPLOYEE_NOT_FOUND_WITH_ID + id)));
	}// getEmployeeById

	@Override
	public void deleteEmployeeById(Long id) {
		EmployeeDTO dto = this.getEmployeeById(id);
		repo.deleteById(dto.getId());
	}// deleteEmployeeById

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO dto) {
		getEmployeeById(dto.getId());
		Employee entity = empMapper.dtoToEntity(dto);
		EmployeeDTO empDTO = empMapper.entityToDto(repo.save(entity));
		return empDTO;
	}//updateEmployeeById
}
