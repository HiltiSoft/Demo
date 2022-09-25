package com.example.demo.form;

import lombok.Data;

@Data
public class UserDetailForm {
	private String userId;
	private String password;
	private String userName;
	private String birthday;
	private Integer age;
	private Integer gender;
}
