package com.prueba.neoris.repository;

import com.prueba.neoris.entity.CrearCuentasUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrearCuentasUsuariosRepository extends JpaRepository<CrearCuentasUsuarios,Long> {
}
