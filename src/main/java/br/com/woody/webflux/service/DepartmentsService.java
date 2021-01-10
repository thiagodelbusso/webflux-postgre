package br.com.woody.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.woody.webflux.dao.DepartmentRepository;
import br.com.woody.webflux.model.Department;
import reactor.core.publisher.Flux;

@Service
public class DepartmentsService {
	
	@Autowired
	private DepartmentRepository dao;
	
	public Flux<Department> listarTodos(){
		return dao.findAll();
	}

}
