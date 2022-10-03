package com.example.demo.form;

import lombok.Data;
import com.example.demo.domain.user.model.Department;

@Data
public class UserDetailForm {
	private String userId;
	private String password;
	private String userName;
	private String birthday;
	private Integer age;
	private Integer gender;
	private Department department;
}
