package com.controlstock.dto;

import java.io.Serializable;

import com.controlstock.customValidator.EnDeposito;

import lombok.Data;

@Data
public class ProductoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	@EnDeposito
	private String codProducto;

}
