package com.controlstock.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlstock.dto.DepositoDTO;
import com.controlstock.dto.ProductoDTO;
import com.controlstock.dto.StockDTO;
import com.controlstock.dto.UbicacionDTO;
import com.controlstock.model.Deposito;
import com.controlstock.model.Producto;
import com.controlstock.model.Stock;
import com.controlstock.model.Ubicacion;
import com.controlstock.repositories.StockRepository;
import com.controlstock.services.StockService;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;

	@Override
	public StockDTO ingresarProductoDeposito(StockDTO stockDTO) {

		Stock stock = new Stock();
		Producto producto = new Producto();
		Deposito deposito = new Deposito();
		Ubicacion ubicacion = new Ubicacion();

		// TODO cambiar con ModelMapper
		ProductoDTO productoDTO = stockDTO.getProducto();
		producto.setId(productoDTO.getId());
		producto.setCodProducto(productoDTO.getCodProducto());

		stock.setProducto(producto);

		DepositoDTO depositoDTO = stockDTO.getDeposito();
		deposito.setId(depositoDTO.getId());
		deposito.setCodDeposito(depositoDTO.getCodDeposito());
		stock.setDeposito(deposito);

		UbicacionDTO ubicacionDTO = stockDTO.getUbicacion();
		ubicacion.setId(ubicacionDTO.getId());
		ubicacion.setCodUbicacion(ubicacionDTO.getCodUbicacion());
		stock.setUbicacion(ubicacion);

		stock.setCantidad(stockDTO.getCantidad());
		stockRepository.save(stock);
		return stockDTO;
	}

}
