package com.controlstock.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Stock")
public class Stock {
	@EmbeddedId
	private StockKey id = new StockKey();

	@MapsId("depositoId")
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private Deposito deposito;

	@MapsId("ubicacionId")
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private Ubicacion ubicacion;

	@MapsId("productoId")
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private Producto producto;

	@Column
	private Long cantidad;

}


