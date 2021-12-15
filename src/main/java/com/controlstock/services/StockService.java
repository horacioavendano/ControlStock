package com.controlstock.services;

import java.util.List;

import com.controlstock.dto.ProductoResponseDTO;
import com.controlstock.dto.StockDTO;
import com.controlstock.dto.UbicacionResponseDTO;

public interface StockService {

	public StockDTO ingresarProductoDeposito(StockDTO stock);

	public StockDTO retirarProductos(StockDTO stock);
	
	public List<ProductoResponseDTO> listarProductosStock(Long depositoId, Long ubicacionId);

	public List<UbicacionResponseDTO> listarUbicacionesStock(Long depositoId, Long productoId);
	 
}
