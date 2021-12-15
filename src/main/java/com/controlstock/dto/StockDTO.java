package com.controlstock.dto;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.controlstock.customValidator.CantMaxPorUbicacion;
import com.controlstock.customValidator.CantMaxProductosUbicacion;

import lombok.Data;


@Data
@CantMaxProductosUbicacion
@CantMaxPorUbicacion
public class StockDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6740802832066495785L;

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
