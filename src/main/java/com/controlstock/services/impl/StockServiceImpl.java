package com.controlstock.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.controlstock.dto.DepositoDTO;
import com.controlstock.dto.ProductoDTO;
import com.controlstock.dto.StockDTO;
import com.controlstock.dto.UbicacionDTO;
import com.controlstock.model.Deposito;
import com.controlstock.model.Producto;
import com.controlstock.model.Stock;
import com.controlstock.model.StockKey;
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
		stock.setProducto(producto);

		DepositoDTO depositoDTO = stockDTO.getDeposito();
		deposito.setId(depositoDTO.getId());
		stock.setDeposito(deposito);

		UbicacionDTO ubicacionDTO = stockDTO.getUbicacion();
		ubicacion.setId(ubicacionDTO.getId());
		stock.setUbicacion(ubicacion);

		StockKey key = new StockKey();
		key.setDepositoId(depositoDTO.getId());
		key.setUbicacionId(ubicacionDTO.getId());
		key.setProductoId(productoDTO.getId());

		Stock stockABuscar = new Stock();
		stockABuscar.setId(key);

		List<Stock> stockList = stockRepository.findAll(Example.of(stockABuscar));
		if (!stockList.isEmpty()) {
			//Update
			Stock stockDb = stockList.get(0);
			Long cantStock = stockDb.getCantidad() + stockDTO.getCantidad();
			stockDb.setCantidad(cantStock);
			stockRepository.save(stockDb);
		} else {
			stock.setCantidad(stockDTO.getCantidad());
			stockRepository.save(stock);
		}
		
		return stockDTO;
	}

//	@Override
//	public List<StockDTO> listarStockProductos(DepositoDTO deposito, UbicacionDTO ubicacion) {
//		// TODO Auto-generated method stub
//		stockRepository.findAll(Example.of(deposito));
//		return null;
//	}

}
