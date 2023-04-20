package com.prueba.neoris.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Table(name = "movimientos")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "tipomovimiento")
    private String tipoMovimiento;
    @Column(name = "valor")
    private Double valor;
    @Column(name = "saldo")
    private Double saldo;

}
