package com.controlstock.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controlstock.dto.StockDTO;
import com.controlstock.model.Deposito;
import com.controlstock.model.Producto;
import com.controlstock.model.Stock;
import com.controlstock.model.Ubicacion;
import com.controlstock.repositories.ProductoRepository;
import com.controlstock.repositories.StockRepository;
import com.controlstock.services.StockService;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	@Transactional
	public StockDTO ingresarProductoDeposito(StockDTO stockDTO) {

		Stock stock = new Stock();
		Producto producto = new Producto();
		Deposito deposito = new Deposito();
		Ubicacion ubicacion = new Ubicacion();

		stock.setCantidad(stockDTO.getCantidad());

		// TODO cambiar con ModelMapper
		Stock stock1 = stockRepository.saveAndFlush(stock);
		
		producto.setCodProducto(stockDTO.getCodProducto());
		stock1.setProducto(producto);

		deposito.setCodDeposito(stockDTO.getCodDeposito());
		stock1.setDeposito(deposito);

		ubicacion.setCodUbicacion(stockDTO.getCodUbicacion());
		stock1.setUbicacion(ubicacion);
		
		stockRepository.saveAndFlush(stock1);
		return stockDTO;
	}

}
