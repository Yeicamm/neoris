package com.prueba.neoris.service.impl;


import com.prueba.neoris.entity.Movimientos;
import com.prueba.neoris.repository.MovimientosRepository;
import com.prueba.neoris.service.MovimientosService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientosServiceImpl implements MovimientosService {

    private final MovimientosRepository movimientosRepository;

    public MovimientosServiceImpl(MovimientosRepository movimientosRepository) {
        this.movimientosRepository = movimientosRepository;
    }

    @Override
    public List<Movimientos> obtenerTodos() throws Exception {
        return movimientosRepository.findAll();
    }

    @Override
    public Optional<Movimientos> obtenerPorId(Long id) throws Exception {
        Optional<Movimientos> movimiento = movimientosRepository.findById(id);
        if (movimiento.isPresent()) {
            Movimientos movimientoNew = movimiento.get();
            return Optional.of(movimientoNew);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Movimientos crearMovimiento(Movimientos movimiento) throws Exception {
        try {
            return movimientosRepository.save(movimiento);
        } catch (Exception e) {
            throw new Exception("Error al intentar crear un movimiento: " + e.getMessage());
        }
    }

    @Override
    public Optional<Movimientos> actualizarMovimiento(Long id, Movimientos movimiento) throws Exception {
        try {
            Optional<Movimientos> movimientoNew = movimientosRepository.findById(id);
            if (movimientoNew.isPresent()) {
                movimiento.setNumeroCuenta(movimiento.getNumeroCuenta());
                movimiento.setTipoCuenta(movimiento.getTipoCuenta());
                movimiento.setSaldoInicial(movimiento.getSaldoInicial());
                movimiento.setEstado(movimiento.getEstado());
                movimiento.setTipoMovimiento(movimiento.getTipoMovimiento());
                movimiento = movimientosRepository.save(movimiento);
                return Optional.of(movimiento);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new Exception("Error al actualizar el movimiento: " + e.getMessage());
        }
    }

    @Override
    public void eliminarMovimiento(Long id) throws Exception {
        try {
            Optional<Movimientos> movimiento = movimientosRepository.findById(id);
            if (movimiento.isPresent()) {
                movimientosRepository.delete(movimiento.get());
            } else {
                throw new Exception("No se ha encontrado el movimiento con id: " + id);
            }
        } catch (Exception e) {
            throw new Exception("Error al eliminar el movimiento con id " + id + ": " + e.getMessage());
        }
    }
}