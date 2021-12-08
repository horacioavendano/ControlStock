package com.controlstock.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import lombok.Data;


@Data
public class DepositoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotEmpty
	private String codDeposito;

}
