package com.prueba.neoris.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;

@Table(name = "tabla_reporte")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long numeroCuenta;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tipocuenta")
    private String tipoCuenta;
    @Column(name = "saldoinicial")
    private Double saldoInicial;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "valor")
    private Double valor;
    @Column(name = "saldo")
    private Double saldo;
}
