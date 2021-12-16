package com.controlstock.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlstock.dto.ProductoResponseDTO;
import com.controlstock.dto.StockDTO;
import com.controlstock.dto.UbicacionResponseDTO;
import com.controlstock.services.StockService;

@RestController
@RequestMapping(path = "/api/stock")
public class StockController {

	@Autowired
	private StockService stockService;

	@PostMapping("/ingresar-productos")
	public ResponseEntity<StockDTO> ingresarProductoDeposito(@Valid @RequestBody StockDTO stock) {
		StockDTO stockDTO = stockService.ingresarProductoDeposito(stock);
		if (stockDTO != null) {

			return new ResponseEntity<StockDTO>(HttpStatus.CREATED);
		} else {

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping("/actualizar-stock-producto")
	public ResponseEntity<StockDTO> actualizarProductoDeposito(@Valid @RequestBody StockDTO stock) {
		StockDTO stockDTO = stockService.actualizarProductoDeposito(stock);
		if (stockDTO != null) {

			return new ResponseEntity<StockDTO>(HttpStatus.CREATED);
		} else {

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PutMapping("/retirar-productos")
	public ResponseEntity<StockDTO> retirarProducto(@Valid @RequestBody StockDTO stock) {

		StockDTO stockDTO = stockService.retirarProductos(stock);
		if (stockDTO != null) {

			return new ResponseEntity<StockDTO>(HttpStatus.CREATED);
		} else {

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping(path = "/lista-productos-stock/{depositoId}/{ubicacionId}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<ProductoResponseDTO>> listarProductosStock(@PathVariable Long depositoId,
			@PathVariable Long ubicacionId) {

		List<ProductoResponseDTO> productoResponseListDTO = stockService.listarProductosStock(depositoId, ubicacionId);

		if (productoResponseListDTO != null) {

			return new ResponseEntity<List<ProductoResponseDTO>>(productoResponseListDTO, HttpStatus.CREATED);
		} else {

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping(path = "/lista-ubicaciones-stock/{depositoId}/{productoId}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<UbicacionResponseDTO>> listarUbicacionesStock(@PathVariable Long depositoId,
			@PathVariable Long productoId) {

		List<UbicacionResponseDTO> ubicacionResponseListDTO = stockService.listarUbicacionesStock(depositoId,
				productoId);

		if (ubicacionResponseListDTO != null) {

			return new ResponseEntity<List<UbicacionResponseDTO>>(ubicacionResponseListDTO, HttpStatus.CREATED);
		} else {

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

}
