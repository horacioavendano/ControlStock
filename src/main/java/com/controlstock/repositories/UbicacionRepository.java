package com.controlstock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controlstock.model.Ubicacion;

@Repository
public  interface UbicacionRepository extends JpaRepository<Ubicacion,Long> {

}
