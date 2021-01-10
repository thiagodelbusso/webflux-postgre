package br.com.woody.webflux.dao;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import br.com.woody.webflux.model.Employee;
import reactor.core.publisher.Flux;

@Repository
public interface EmployeeRepository extends R2dbcRepository<Employee, Integer> { 
	
	@Query("SELECT * FROM employee OFFSET :offset LIMIT :limit")
	Flux<Employee> findAll(int offset, int limit);
	
}
