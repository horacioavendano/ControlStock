package com.controlstock.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlstock.dto.StockDTO;
import com.controlstock.services.StockService;

@RestController
@RequestMapping(path = "/api/stock")
public class StockController {

	@Autowired
	private StockService stockService;

	@PutMapping("/ingresar-productos")
	public ResponseEntity<StockDTO> ingresarProductoDeposito(@Valid @RequestBody StockDTO stock) {
		StockDTO stockDTO = stockService.ingresarProductoDeposito(stock);
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

}
