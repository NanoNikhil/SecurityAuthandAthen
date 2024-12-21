package com.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

public class EmployeeUserDetailService implements UserDetailsService{
	
	
	@Autowired
	private EmployeeRepository repository;

	
	
	//UserDetailService and This class will be responsible to load data from DATABASE
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Employee>	employee=repository.findByUsername(username);
		return employee.map(EmployeeUserDetails::new)
				.orElseThrow(()->new UsernameNotFoundException(username+" not found in System"));
	}

}
