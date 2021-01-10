package br.com.woody.webflux.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.r2dbc.core.DatabaseClient;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;

@Configuration
public class PostgreeConfiguration {

	@Bean
	public ConnectionFactory connectionFactory() {
	    return new PostgresqlConnectionFactory(
	    		PostgresqlConnectionConfiguration.builder()
	    		.host("localhost")
	    		.port(5432)
	    		.username("postgres")
	    		.password("postgres")
	    		.database("employees")
	    		.build()
	    );
	}
	
	@Bean
	DatabaseClient databaseClient(ConnectionFactory connectionFactory) {
	    return DatabaseClient.builder()
	        .connectionFactory(connectionFactory)
	        .namedParameters(true)
	        .build();
	}
	
}
