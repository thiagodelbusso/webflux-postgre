package br.com.woody.webflux.mapping;

import java.util.function.BiFunction;

import br.com.woody.webflux.model.Department;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;

public final class DepartmentMapping {

	public static final BiFunction<Row, RowMetadata, Department> MAPPING_FUNCTION = 
			(row, rowMetaData) -> Department.builder()
    									    .id(row.get("dept_no", String.class))
    									    .descricao(row.get("dept_name", String.class))
    								        .build();
	
}
