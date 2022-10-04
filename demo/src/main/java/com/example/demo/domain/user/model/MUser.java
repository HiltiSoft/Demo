package com.example.demo.domain.user.model;

import java.util.Date;
import java.util.List;

import lombok.Data;
import com.example.demo.domain.user.model.Department;
import com.example.demo.domain.user.model.Salary;

@Data
public class MUser {
	private String userId;
	private String password;
	private String userName;
	/* private Date birthday;  */
	private String birthday;
	private Integer age;
	private Integer gender;
	private Integer departmentId;
	private String role;
	private Department department;
	private List<Salary> salaryList;
	
}
