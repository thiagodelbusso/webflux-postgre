package br.com.woody.webflux.configuration;

import java.time.Duration;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import br.com.woody.webflux.model.Employee;
import br.com.woody.webflux.service.EmployeeService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Component
public class EmployeeHandler {
	
	@Autowired
	private EmployeeService service;
	
	public Mono<ServerResponse> listarTodos(ServerRequest req){
		Optional<String> millis = req.queryParam("millis");
		
		Flux<Long> interval = Flux.interval(Duration.ofMillis(Integer.parseInt(millis.orElse("0"))));
		Flux<Employee> findAll = service.listarTodos();
		 
		Flux<Tuple2<Long, Employee>> zip = Flux.zip(interval, findAll);
		    return ServerResponse
		            .ok()
		            .contentType(MediaType.TEXT_EVENT_STREAM)
		            .body(zip.map(Tuple2::getT2), Employee.class);
	}

}
