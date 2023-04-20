package com.prueba.neoris.repository;

import com.prueba.neoris.entity.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientosRepository extends JpaRepository<Movimientos,Long> {
}
