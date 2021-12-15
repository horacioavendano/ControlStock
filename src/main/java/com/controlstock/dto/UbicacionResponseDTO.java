package com.controlstock.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UbicacionResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4348289662329196138L;

	private Long id;

	private String codUbicacion;
	
	private Long cantidadStock;

}
