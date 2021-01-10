package br.com.woody.webflux.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {

	@Bean
	public RouterFunction<ServerResponse> rotasDepartamentos(DepartmentsHandler handler) {
		return route(GET("/departments"), handler::listarTodos);
	}
	
	@Bean
	public RouterFunction<ServerResponse> rotasEmpregados(EmployeeHandler handler) {
		return route(GET("/employee"), handler::listarTodos);
	}

}
