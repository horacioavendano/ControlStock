package com.controlstock.dto;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class UbicacionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4348289662329196138L;

	private Long id;

	@Pattern(message = "Patrón ubicación incorrecto.{area}-{pasillo}-{Fila}-{cara}", regexp = "[A-Z]{2,2}\\-\\d{2,2}-\\d{2,2}\\-(IZ|DE)")
	private String codUbicacion;

}
