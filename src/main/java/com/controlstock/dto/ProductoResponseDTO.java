package com.controlstock.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductoResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8666358631634990164L;

	private Long id;

	private String codProducto;
	
	private Long cantidadSock; 

}
