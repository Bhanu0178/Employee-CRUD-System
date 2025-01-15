package org.ease.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.ease.constants.AppConstants.EMPLOYEE_DELETED_WITH_ID;
import org.ease.dto.EmployeeDTO;
import org.ease.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
@CrossOrigin(origins = {"http://localhost:4200"})
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	
	@PostMapping("/add/employee")
	ResponseEntity<?> addEmployee(@RequestBody EmployeeDTO dto) {
		EmployeeDTO empDTO = service.addEmployee(dto);
		return new ResponseEntity<>(empDTO, HttpStatus.CREATED);
	}//addEmployee
	
	@GetMapping("/get/employees")
	ResponseEntity<?> getAllEmployees() {
		List<EmployeeDTO> emps = service.getAllEmployees();
		return new ResponseEntity<>(emps, HttpStatus.OK);
	}//getAllEmployees

	@GetMapping("/get/employee/{id}")
	ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
		EmployeeDTO dto = service.getEmployeeById(id);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}//getEmployeeById
	
	@DeleteMapping("/delete/employee/{id}")
	ResponseEntity<?> deleteEmployeeById(@PathVariable Long id) {
		Map<String, Object> map = new  HashMap<>();
		service.deleteEmployeeById(id);
		map.put("message", EMPLOYEE_DELETED_WITH_ID + id);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}//deleteEmployeeById
	
	@PutMapping(value = "/update/employee")
	ResponseEntity<?> updateEmployee(@RequestBody EmployeeDTO dto) {
		EmployeeDTO empDTO = service.updateEmployee(dto);
		return new ResponseEntity<>(empDTO, HttpStatus.OK);
	}//updateEmployeeById
}
