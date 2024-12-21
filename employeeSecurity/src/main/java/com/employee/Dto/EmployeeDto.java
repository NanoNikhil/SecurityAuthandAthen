package com.employee.Dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmployeeDto {
	
	@NotBlank(message = "Name is required")
    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Only alphabets allowed")
	private String emp_name;
	@NotBlank(message = "Name is required")
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid mobile number format")//This pattern will match a 10-digit number starting with 6, 7, 8, or 9.
	private String emp_mobile;
	@NotBlank(message = "Name is required")
	@Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Invalid email format")
	private String emp_email;
	@Min(5000)
    @Max(1000000)
	private double emp_salary;
	private String username;
	private String password;
	private String roles;
	
	public EmployeeDto() {
		super();
	}
	public EmployeeDto( String emp_name, String emp_mobile, String emp_email, double emp_salary,String username,String password,String roles) {
		super();
		this.emp_name = emp_name;
		this.emp_mobile = emp_mobile;
		this.emp_email = emp_email;
		this.emp_salary = emp_salary;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_mobile() {
		return emp_mobile;
	}
	public void setEmp_mobile(String emp_mobile) {
		this.emp_mobile = emp_mobile;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public double getEmp_salary() {
		return emp_salary;
	}
	public void setEmp_salary(double emp_salary) {
		this.emp_salary = emp_salary;
	}
	public String getUsername() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
}
