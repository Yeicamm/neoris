package com.prueba.neoris.service.impl;

import com.prueba.neoris.entity.Movimientos;
import com.prueba.neoris.repository.MovimientosRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovimientosServiceImplTest {

    @MockBean
    @Autowired
    private MovimientosRepository movimientosRepository;

    @Autowired
    private MovimientosServiceImpl service;

    Movimientos movimientos;

    @BeforeEach
    void setUp() {
        movimientos = Movimientos.builder()
                .numeroCuenta(1l)
                .tipoCuenta("Ahorros")
                .saldoInicial(120.0)
                .estado(true)
                .tipoMovimiento("Se Envio 120.0")
                .build();
    }

    @Test
    void actualizarMovimientoTest() throws Exception {
        Mockito.when(movimientosRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(movimientos));
        Mockito.when(movimientosRepository.save(movimientos)).thenReturn(movimientos);

        var servicio = service.actualizarMovimiento(1L, movimientos);

        Assertions.assertNotNull(servicio);
        Assertions.assertEquals(true, servicio.get().getEstado());
    }

}