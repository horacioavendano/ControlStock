package com.controlstock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controlstock.model.Producto;

@Repository
public  interface ProductoRepository extends JpaRepository<Producto,Long> {

}
