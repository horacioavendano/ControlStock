package com.controlstock.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping("/producto-ubicacion")
	public ResponseEntity<StockDTO> ingresarProductoDeposito(@Valid @RequestBody StockDTO stock) {
		
		return new ResponseEntity<StockDTO>(stockService.ingresarProductoDeposito(stock), HttpStatus.CREATED);
	}

}
