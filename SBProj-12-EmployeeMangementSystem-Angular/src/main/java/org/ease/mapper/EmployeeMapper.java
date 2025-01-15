package org.ease.mapper;

import java.util.List;

import org.ease.dto.EmployeeDTO;
import org.ease.entity.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
	
	@Autowired
	private ModelMapper mapper;
	
	public Employee dtoToEntity(EmployeeDTO dto) {
		return mapper.map(dto, Employee.class);
	}//dtoToEntity
	
	public EmployeeDTO entityToDto(Employee entity) {
		return mapper.map(entity, EmployeeDTO.class);
	}//entityToDto
	
	public List<EmployeeDTO> entitysToDtos(List<Employee> list) {
		return list.stream()
						  .map(this::entityToDto)
						  .toList();
	}//entitysToDtos
}
