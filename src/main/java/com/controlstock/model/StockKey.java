package com.controlstock.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
@Data
@Embeddable
public class StockKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long depositoId;
	private Long ubicacionId;
	private Long productoId;

}
