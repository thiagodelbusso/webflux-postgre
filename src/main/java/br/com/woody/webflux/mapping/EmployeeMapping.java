package br.com.woody.webflux.mapping;

import java.util.function.BiFunction;

import br.com.woody.webflux.model.Employee;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;

public final class EmployeeMapping {

	public static final BiFunction<Row, RowMetadata, Employee> MAPPING_FUNCTION = 
			(row, rowMetaData) -> Employee.builder()
							              .id(row.get("emp_id", Integer.class))
							              .nome(row.get("nome", String.class))
							              .idade(row.get("idade", Integer.class))
							              .departamento(DepartmentMapping.MAPPING_FUNCTION.apply(row, rowMetaData))
							              .build();
	
}
