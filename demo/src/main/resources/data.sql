insert into employee
values('1', 'Tom', 30);

/*User master */
insert into m_user(
	user_id 
	,password
	,user_name
	,birthday
	,age
	,gender
	,department_id
	,role
) values
	( 'system@co.jp', 'password', 'System Administrator', '2000-01-01', 21 , 1 , 1 , 'ROLE_ADMIN')  
   ,( 'user@co.jp', 'password', 'User1', '2000-01-01', 21 , 2 , 2 , 'ROLE_GENERAL')
;

/*Department master */
insert into m_department(
	department_id
	,department_name
) values
	(1, 'System Management')
   ,(2, 'Sales')
;

/*Salary table */
insert into t_salary(
	user_id
	,year_month
	,salary
) values
	('user@co.jp', '11/2020', 2800)
   ,('user@co.jp', '12/2020', 2900)
   ,('user@co.jp', '01/2021', 3800)   
;