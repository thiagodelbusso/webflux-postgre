package br.com.woody.webflux.dao;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import br.com.woody.webflux.model.Employee;

@Repository
public interface EmployeeRepository extends R2dbcRepository<Employee, Integer> {

}
