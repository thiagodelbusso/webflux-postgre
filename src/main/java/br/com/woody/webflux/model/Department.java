package br.com.woody.webflux.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("departments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Persistable<String> {

	@Id
	@Column("dept_no")
	private String id;

	@Column("dept_name")
	private String descricao;

	@JsonIgnore
	@Transient
	private boolean newDep;

	@JsonIgnore
	@Override
	public boolean isNew() {
		return newDep;
	}

}
