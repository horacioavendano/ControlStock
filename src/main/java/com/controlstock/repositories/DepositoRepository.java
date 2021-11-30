package com.controlstock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controlstock.model.Deposito;

@Repository
public  interface DepositoRepository extends JpaRepository<Deposito,Integer> {

}
