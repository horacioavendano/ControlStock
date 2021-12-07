package com.controlstock.model;

import javax.persistence.CascadeType;
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
@Table(name = "Stock")
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn
	private Deposito deposito;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn
	private Ubicacion ubicacion;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn
	private Producto producto;

	@Column
	private Long cantidad;

}
