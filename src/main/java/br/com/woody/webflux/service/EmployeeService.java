package br.com.woody.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.woody.webflux.dao.DepartmentRepository;
import br.com.woody.webflux.dao.EmployeeRepository;
import br.com.woody.webflux.model.Employee;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@Service
public class EmployeeService {
	
	@Autowired
    private EmployeeRepository employeeDao;
	
	@Autowired
	private DepartmentRepository departmentDao;
	
	public Flux<Employee> listarTodos() {
		log.info("Montando fluxo de Employe...");
		
		int offset = 0;
		int limit = 100;
		return employeeDao.findAll(offset, limit)
						  .flatMap(emp -> Mono.just(emp)
								   .zipWith(departmentDao.findById(emp.getIdDepartment()))
								   .map(t -> {
									   emp.setDepartamento(t.getT2());
									   return emp;
								   }));
	}
	
}
