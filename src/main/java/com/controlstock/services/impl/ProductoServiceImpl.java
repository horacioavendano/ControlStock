package com.controlstock.services.impl;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlstock.dto.ProductoDTO;
import com.controlstock.model.Producto;
import com.controlstock.repositories.ProductoRepository;
import com.controlstock.repositories.StockRepository;
import com.controlstock.services.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private StockRepository stockRepository;

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public ProductoDTO ingresarProductoDeposito(ProductoDTO productoDto) {

		Boolean codProductoMalFormateado = Pattern.matches("[A-Z]{2,2}\\-\\d{2,2}-\\d{2,2}\\-(IZ|DE)", productoDto.getCodProducto());

		Producto producto = new Producto();
	
		//TODO cambiar con ModelMapper
		producto.setCodProducto(productoDto.getCodProducto());
		
		productoRepository.save(producto);
		
		return productoDto;
	}

}
