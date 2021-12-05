package com.controlstock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Stock")
public class Stock {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long  id;
	
	@ManyToOne
	@JoinColumn
	private Deposito deposito;
	
	@ManyToOne
	@JoinColumn
	private Ubicacion ubicacion;
	
	@ManyToOne
	@JoinColumn
	private Producto producto;
	
	@Column
	private Long cantidad;
	
}
