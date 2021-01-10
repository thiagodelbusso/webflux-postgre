package br.com.woody.webflux.query;

public final class Employee {

	public static final String SELECT_ALL_JOIN_DEPARTMENT = "SELECT * FROM employee em INNER JOIN departments dp ON em.id_department = dp.dept_no";
	
}
