package com.prueba.neoris.service;

import com.prueba.neoris.entity.Movimientos;
import com.prueba.neoris.entity.Reporte;

import java.util.List;
import java.util.Optional;

public interface ReporteService {
    /**
     * Método para obtener todos los reportes
     * @return una lista de todos los reportes
     * @throws Exception si ocurre un error al obtener los reportes
     */
    List<Reporte> obtenerTodos() throws Exception;

    /**
     * Método para obtener un reporte por ID
     * @param id el ID del reporte que se quiere obtener
     * @return un objeto Optional que puede contener un Reporte si existe un reporte con el ID dado, o un objeto vacío si no existe
     * @throws Exception si ocurre un error al obtener el reporte
     */
    Optional<Reporte> obtenerPorId(Long id) throws Exception;

    /**
     * Método para crear un nuevo reporte
     * @param reporte el objeto Reporte que se quiere crear
     * @return el Reporte creado
     * @throws Exception si ocurre un error al crear el reporte
     */
    Reporte crearReporte(Reporte reporte) throws Exception;

    /**
     * Método para actualizar un reporte existente
     * @param id el ID del reporte que se quiere actualizar
     * @param reporte el objeto Reporte con los datos actualizados
     * @return un objeto Optional que puede contener el Reporte actualizado si existe un reporte con el ID dado, o un objeto vacío si no existe
     * @throws Exception si ocurre un error al actualizar el reporte
     */
    Optional<Reporte> actualizarReporte(Long id, Reporte reporte) throws Exception;

    /**
     * Método para eliminar un reporte por ID
     * @param id el ID del reporte que se quiere eliminar
     * @throws Exception si ocurre un error al eliminar el reporte
     */
    void eliminarReporte(Long id) throws Exception;
}
