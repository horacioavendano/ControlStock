package com.controlstock.customValidator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.controlstock.dto.StockDTO;
import com.controlstock.repositories.StockRepository;



public class CantMaxProductosUbicacionValidator implements ConstraintValidator<CantMaxProductosUbicacion, StockDTO> {

	@Autowired
	private StockRepository stockRepository;

	Logger logger = LoggerFactory.getLogger(CantMaxProductosUbicacionValidator.class);

	@Override
	public boolean isValid(StockDTO value, ConstraintValidatorContext context) {
		boolean rta = false;
		System.out.println("Verificación de capacidad Prod. distintos para DepositoId: " + value.getDeposito().getId() + " UbicacioId: "
				+ value.getUbicacion().getId());

		List<Long> productoListId = stockRepository.getMaxCantProductosUbicacion(value.getDeposito().getId(),
				value.getUbicacion().getId());

		if (productoListId == null || productoListId.size() == 0)
			return true;

		if (productoListId.size() >= 3 && !(productoListId.contains(value.getProducto().getId()))) {

			rta = false;
		} else {

			rta = true;
		}

		return rta;
	}
}
