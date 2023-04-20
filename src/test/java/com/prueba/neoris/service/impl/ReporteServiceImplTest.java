package com.prueba.neoris.service.impl;

import com.prueba.neoris.entity.Reporte;
import com.prueba.neoris.repository.ReporteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
public class ReporteServiceImplTest {

    @MockBean
    @Autowired
    private ReporteRepository reporteRepository;

    @Autowired
    private ReporteServiceImpl service;

    Reporte reporte;

    @BeforeEach
    void setUp(){
        reporte = Reporte.builder()
                .numeroCuenta(1l)
                .fecha(new Date())
                .nombre("Yeison")
                .tipoCuenta("Ahorros")
                .saldoInicial(1000.0)
                .estado(true)
                .valor(2000.0)
                .saldo(5000.0)
                .build();
    }
    @Test
    void actualizarReporteTest() throws Exception {
        Mockito.when(reporteRepository.save(reporte)).thenReturn(reporte);
        Mockito.when(reporteRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(reporte));

        var servicio = service.actualizarReporte(1L, reporte);

        Assertions.assertNotNull(servicio);
        Assertions.assertEquals(true, servicio.get().getEstado());

    }

}
