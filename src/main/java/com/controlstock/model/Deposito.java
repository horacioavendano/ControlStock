package com.controlstock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Deposito")
public class Deposito {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long  id;
	
	@Column
	private String codDeposito;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
