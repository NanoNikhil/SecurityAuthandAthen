package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.employee.entity.Employee;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	public final static String DEFAULT_ROLE="ROLE_EMPLOYEE";

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Employee saveEmployee(com.employee.Dto.EmployeeDto employeeDto) {
		Employee employee=new Employee();
		employee.setEmp_name(employeeDto.getEmp_name());
		employee.setEmp_mobile(employeeDto.getEmp_mobile());
		employee.setEmp_email(employeeDto.getEmp_email());
		employee.setEmp_salary(employeeDto.getEmp_salary());
		employee.setUserName(employeeDto.getUsername());
		employee.setPassword(passwordEncoder.encode(employeeDto.getPassword()));
		employee.setRoles(DEFAULT_ROLE);

		return employeeRepository.save(employee);
	}
	
	public List<Employee> saveEmployees(List<Employee> employees) {
		return employeeRepository.saveAll(employees);
	}
	
	public Employee getEmployee(Long id) {
		 Employee emp=employeeRepository.findById(id)
				 .orElseThrow(()->new EmployeeNotFoundException ("Employee with id: " +id+" NOT FOUND"));
		 return emp;
	}
	
	public List<Employee> getAllEmp(){
		return employeeRepository.findAll();
	}
	
	public Employee upDateEmpNumber(Employee emp,Long id) {
		 Employee emp1=employeeRepository.findById(id)
				 .orElseThrow(()->new EmployeeNotFoundException("Employee with id: " +id+" NOT FOUND"));
		 emp1.setEmp_mobile(emp.getEmp_mobile());
		 return employeeRepository.save(emp1);
	}
	
	public String deleteEmp(Long id) {
		employeeRepository.deleteById(id);
		return "Deleted Successfully";
	}
	
	public Employee changeRoleOfEmployee(Employee employee) {
		Employee existingEmp=getEmployee(employee.getEmp_id());
		existingEmp.setRoles(employee.getRoles());
		return employeeRepository.save(existingEmp);
	}
}
