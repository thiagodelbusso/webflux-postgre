package br.com.woody.webflux.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import br.com.woody.webflux.model.Department;

@Repository
public interface DepartmentRepository extends ReactiveCrudRepository<Department, String> {
	
}
