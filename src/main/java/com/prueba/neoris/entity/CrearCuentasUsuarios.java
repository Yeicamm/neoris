package com.prueba.neoris.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tabla_crearCuentasUsuarios")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrearCuentasUsuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long numeroCuenta;
    @Column(name = "tipocuenta")
    private String tipoCuenta;
    @Column(name = "saldoinicial")
    private Double saldoInicial;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "nombre")
    private String nombre;
}
