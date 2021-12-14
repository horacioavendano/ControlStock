package com.controlstock.services;

import java.util.List;

import javax.validation.Valid;

import com.controlstock.dto.DepositoDTO;
import com.controlstock.dto.StockDTO;
import com.controlstock.dto.UbicacionDTO;

public interface StockService {

	public StockDTO ingresarProductoDeposito(StockDTO stock);

	public StockDTO retirarProductos(StockDTO stock);
	 
	 //public List<StockDTO> listarStockProductos(DepositoDTO deposito, UbicacionDTO ubicacion);
}
