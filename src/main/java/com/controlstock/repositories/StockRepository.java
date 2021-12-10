package com.controlstock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.controlstock.model.Stock;
import com.controlstock.model.StockKey;

@Repository
public interface StockRepository extends JpaRepository<Stock, StockKey> {

//	@Query("SELECT s FROM STOCK s WHERE s.DEPOSITO_ID = ?1 AND s.UBICACION_ID = ?2 AND s.PRODUCTO_ID = ?3")
//	Stock buscarStock(Long depositoId, Long ubicacionId, Long productoId);
}
