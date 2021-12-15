package com.controlstock.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.controlstock.dto.DepositoDTO;
import com.controlstock.dto.ProductoDTO;
import com.controlstock.dto.ProductoResponseDTO;
import com.controlstock.dto.StockDTO;
import com.controlstock.dto.UbicacionDTO;
import com.controlstock.dto.UbicacionResponseDTO;
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

		stock.setCantidad(stockDTO.getCantidad());

		Optional<Stock> optionalStock = this.buscarProducto(stock);

		if (optionalStock.isPresent()) {
			// Update
			Stock stockDb = optionalStock.get();
			Long cantStock = stockDb.getCantidad() + stock.getCantidad();
			stockDb.setCantidad(cantStock);
			stockRepository.save(stockDb);
		} else {

			stockDTO = null;
		}

		return stockDTO;
	}

	@Override
	public StockDTO retirarProductos(StockDTO stockDTO) {

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

		stock.setCantidad(stockDTO.getCantidad());

		Optional<Stock> optionalStock = this.buscarProducto(stock);

		if (optionalStock.isPresent()) {
			// Update
			Stock stockDb = optionalStock.get();
			Long cantStock = stockDb.getCantidad() - stock.getCantidad();
			stockDb.setCantidad(cantStock);
			stockRepository.save(stockDb);
		} else {

			stockDTO = null;
		}

		return stockDTO;
	}

	private Optional<Stock> buscarProducto(Stock stock) {
		StockKey key = new StockKey();
		key.setDepositoId(stock.getDeposito().getId());
		key.setUbicacionId(stock.getUbicacion().getId());
		key.setProductoId(stock.getProducto().getId());

		Stock stockABuscar = new Stock();
		stockABuscar.setId(key);

		return stockRepository.findOne(Example.of(stockABuscar));
	}

	@Override
	public List<ProductoResponseDTO> listarProductosStock(Long depositoId, Long ubicacionId) {
		List<Stock> listStock = stockRepository.listarProductosStock(depositoId, ubicacionId);

		// TODO agregar automapper
		List<ProductoResponseDTO> listProductoDTO = new ArrayList<ProductoResponseDTO>();
		for (Stock stock : listStock) {
			ProductoResponseDTO productoDTO = new ProductoResponseDTO();
			productoDTO.setId(stock.getProducto().getId());
			productoDTO.setCodProducto(stock.getProducto().getCodProducto());
			productoDTO.setCantidadSock(stock.getCantidad());
			listProductoDTO.add(productoDTO);
		}

		return listProductoDTO;
	}
	
	@Override
	public List<UbicacionResponseDTO> listarUbicacionesStock(Long depositoId, Long productoId) {
		List<Stock> listStock = stockRepository.listarUbicacionesStock(depositoId, productoId);

		// TODO agregar automapper
		List<UbicacionResponseDTO> listUbicacionDTO = new ArrayList<UbicacionResponseDTO>();
		for (Stock stock : listStock) {
			UbicacionResponseDTO ubicacionResponseDTO = new UbicacionResponseDTO();
			ubicacionResponseDTO.setId(stock.getProducto().getId());
			ubicacionResponseDTO.setCodUbicacion(stock.getProducto().getCodProducto());
			ubicacionResponseDTO.setCantidadStock(stock.getCantidad());
			listUbicacionDTO.add(ubicacionResponseDTO);
		}

		return listUbicacionDTO;
	}

}
