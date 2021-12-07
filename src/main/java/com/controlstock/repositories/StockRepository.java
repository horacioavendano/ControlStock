package com.controlstock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controlstock.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
