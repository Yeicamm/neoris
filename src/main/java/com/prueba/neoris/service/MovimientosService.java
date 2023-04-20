package com.prueba.neoris.service;



import com.prueba.neoris.entity.Movimiento;
import com.prueba.neoris.entity.Movimientos;

import java.util.List;
import java.util.Optional;

public interface MovimientosService {



    /**
     * Método para obtener todos los movimientos
     *
     * @return Listado de todos los movimientos
     * @throws Exception Si ocurre algún error durante la ejecución del método
     */
    List<Movimientos> obtenerTodos() throws Exception;

    /**
     * Método para obtener un movimiento por ID
     *
     * @param id Identificador del movimiento
     * @return Movimiento encontrado por ID
     * @throws Exception Si ocurre algún error durante la ejecución del método
     */
    Optional<Movimientos> obtenerPorId(Long id) throws Exception;

    /**
     * Método para crear un nuevo movimiento
     *
     * @param movimiento Objeto de tipo Movimientos que se desea crear
     * @return Movimiento creado
     * @throws Exception Si ocurre algún error durante la ejecución del método
     */
    Movimientos crearMovimiento(Movimientos movimiento) throws Exception;

    /**
     * Método para actualizar un movimiento existente
     *
     * @param id         Identificador del movimiento que se desea actualizar
     * @param movimiento Objeto de tipo Movimientos con los datos actualizados
     * @return Movimiento actualizado
     * @throws Exception Si ocurre algún error durante la ejecución del método
     */
    Optional<Movimientos> actualizarMovimiento(Long id, Movimientos movimiento) throws Exception;

    /**
     * Método para eliminar un movimiento por ID
     *
     * @param id Identificador del movimiento que se desea eliminar
     * @throws Exception Si ocurre algún error durante la ejecución del método
     */
    void eliminarMovimiento(Long id) throws Exception;

}
