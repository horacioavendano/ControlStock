package com.controlstock.dto;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Data
public class StockDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Valid
	@NotNull
	private DepositoDTO deposito;

	@Valid
	@NotNull
	private UbicacionDTO ubicacion;
	
	@Valid
	@NotNull
	private ProductoDTO producto;

	private Long cantidad;

}
