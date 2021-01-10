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

@Table("employee")
@Data
@Builder
@AllArgsConstructor
public class Employee implements Persistable<Integer> {

	@Id
	@Column("emp_id")
	private Integer id;

	@Column("nome")
	private String nome;

	@Column("idade")
	private int idade;
	
	@Transient
	private Department departamento;
	
	@JsonIgnore
	@Transient
	private boolean newDep;
	
	public Employee() {
		this.departamento = new Department();
	}

	@JsonIgnore
	@Override
	public boolean isNew() {
		return newDep;
	}

}
