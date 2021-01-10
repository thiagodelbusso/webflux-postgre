package br.com.woody.webflux.service;

import static br.com.woody.webflux.query.Employee.SELECT_ALL_JOIN_DEPARTMENT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;

import br.com.woody.webflux.mapping.EmployeeMapping;
import br.com.woody.webflux.model.Employee;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;

@Log4j2
@Service
public class EmployeeService {
	
	@Autowired
    private DatabaseClient databaseClient;
	
	public Flux<Employee> listarTodos() {
		log.info("Montando fluxo de Employe...");
		return this.databaseClient
				   .sql(SELECT_ALL_JOIN_DEPARTMENT)
				   .map(EmployeeMapping.MAPPING_FUNCTION)
				   .all();
	}
	
}
