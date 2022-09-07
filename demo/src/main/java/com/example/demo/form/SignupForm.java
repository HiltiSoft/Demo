package com.example.demo.form;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
public class SignupForm {
	private String userId;
	private String password;
	private String userName;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private String birthday;
	private Integer age;
	private Integer gender;	
}
