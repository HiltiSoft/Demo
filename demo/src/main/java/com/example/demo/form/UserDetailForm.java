package com.example.demo.form;

import lombok.Data;

import java.util.List;

import com.example.demo.domain.user.model.Department;
import com.example.demo.domain.user.model.Salary;

@Data
public class UserDetailForm {
	private String userId;
	private String password;
	private String userName;
	private String birthday;
	private Integer age;
	private Integer gender;
	private Department department;
	private List<Salary> salaryList;
}
