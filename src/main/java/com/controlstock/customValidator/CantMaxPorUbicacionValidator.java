package com.controlstock.customValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.controlstock.dto.StockDTO;
import com.controlstock.repositories.StockRepository;

public class CantMaxPorUbicacionValidator implements ConstraintValidator<CantMaxPorUbicacion, StockDTO> {

	@Autowired
	private StockRepository stockRepository;

	Logger logger = LoggerFactory.getLogger(CantMaxPorUbicacionValidator.class);

	@Override
	public boolean isValid(StockDTO value, ConstraintValidatorContext context) {
		boolean rta = false;
		System.out.println("Verficacion de capacidad para DepositoId: " + value.getDeposito().getId() + " UbicacioId: "
				+ value.getUbicacion().getId());

		Long stockTotal = stockRepository.getMaxCantPorUbicacion(value.getDeposito().getId(),
				value.getUbicacion().getId());

		if (stockTotal == null)
			return true;

		Long disponible = 100L - stockTotal;
		if (disponible <= value.getCantidad()) {

			rta = false;
		} else {

			rta = true;
		}

		return rta;
	}
}
