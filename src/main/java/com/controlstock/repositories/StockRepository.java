package com.controlstock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.controlstock.model.Stock;
import com.controlstock.model.StockKey;

@Repository
public interface StockRepository extends JpaRepository<Stock, StockKey> {

	@Query(" SELECT SUM(s.cantidad) AS CANTIDAD FROM Stock AS s WHERE s.deposito.id = ?1 AND s.ubicacion.id = ?2 ")
	Long getMaxCantPorUbicacion(Long depositoId, Long ubicacionId);
	
	@Query(" SELECT DISTINCT(s.producto.id) FROM Stock AS s WHERE s.deposito.id = ?1 AND s.ubicacion.id = ?2 ")
	List<Long> getMaxCantProductosUbicacion(Long depositoId, Long ubicacionId);

	@Query(" SELECT s FROM Stock AS s WHERE s.deposito.id = ?1 AND s.ubicacion.id = ?2 ")
	List<Stock> listarProductosStock(Long depositoId, Long ubicacionId);

	@Query(" SELECT s FROM Stock AS s WHERE s.deposito.id = ?1 AND s.producto.id = ?2 ")
	List<Stock> listarUbicacionesStock(Long depositoId, Long productoId);
}