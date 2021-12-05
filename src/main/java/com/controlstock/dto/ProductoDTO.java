package com.controlstock.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.controlstock.customValidator.EnDeposito;

import lombok.Data;

@Data
public class ProductoDTO {
	
	@NotEmpty
	private String codDeposito;
	
	@Pattern(message="Patrón ubicación incorrecto.{area}-{pasillo}-{Fila}-{cara}" , regexp="[A-Z]{2,2}\\-\\d{2,2}-\\d{2,2}\\-(IZ|DE)")
	private String codUbicacion;
	
	@EnDeposito
	private String codProducto;
	
	private Long cantidad;

}
