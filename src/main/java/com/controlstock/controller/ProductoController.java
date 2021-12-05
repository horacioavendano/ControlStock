package com.controlstock.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlstock.dto.ProductoDTO;
import com.controlstock.services.ProductoService;

@RestController
@RequestMapping(path = "/api/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@PostMapping("/producto-ubicacion")
	public ResponseEntity<ProductoDTO> ingresarProductoDeposito(@Valid @RequestBody ProductoDTO producto) {
		
		return new ResponseEntity<ProductoDTO>(productoService.ingresarProductoDeposito(producto), HttpStatus.CREATED);
	}

}
