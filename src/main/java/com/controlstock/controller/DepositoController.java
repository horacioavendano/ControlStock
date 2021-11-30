package com.controlstock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/Deposito")
public class DepositoController {
	@GetMapping
	public String IngresarProducto() {
		return "Ingreso Producto";
	}

}
