package com.prueba.neoris.controller;

import com.prueba.neoris.entity.Movimientos;
import com.prueba.neoris.service.MovimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
    @Autowired
    private MovimientosService movimientosService;

    // Método para obtener todos los movimientos
    @GetMapping("")
    public ResponseEntity<List<Movimientos>> obtenerTodos() {
        try {
            List<Movimientos> movimientos = movimientosService.obtenerTodos();
            return new ResponseEntity<>(movimientos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para obtener un movimiento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Movimientos> obtenerPorId(@PathVariable("id") Long id) {
        try {
            Optional<Movimientos> movimiento = movimientosService.obtenerPorId(id);
            if (movimiento.isPresent()) {
                return new ResponseEntity<>(movimiento.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para crear un nuevo movimiento
    @PostMapping("")
    public ResponseEntity<Movimientos> crearMovimiento(@RequestBody Movimientos movimiento) {
        try {
            Movimientos nuevoMovimiento = movimientosService.crearMovimiento(movimiento);
            return new ResponseEntity<>(nuevoMovimiento, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para actualizar un movimiento existente
    @PutMapping("/{id}")
    public ResponseEntity<Movimientos> actualizarMovimiento(@PathVariable("id") Long id, @RequestBody Movimientos movimiento) {
        try {
            Optional<Movimientos> movimientoActualizado = movimientosService.actualizarMovimiento(id, movimiento);
            if (movimientoActualizado.isPresent()) {
                return new ResponseEntity<>(movimientoActualizado.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para eliminar un movimiento por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarMovimiento(@PathVariable("id") Long id) {
        try {
            movimientosService.eliminarMovimiento(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
