package com.prueba.neoris.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "cuenta")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroCuenta;
    @Column(name = "tipocuenta")
    private String tipoCuenta;
    @Column(name = "saldoinicial")
    private Double saldoInicial;
    @Column(name = "estado")
    private Boolean estado;

}
