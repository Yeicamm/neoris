package com.prueba.neoris.service.impl;

import com.prueba.neoris.entity.Reporte;
import com.prueba.neoris.repository.ReporteRepository;
import com.prueba.neoris.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReporteServiceImpl implements ReporteService {

    private final ReporteRepository reporteRepository;

    @Autowired
    public ReporteServiceImpl(ReporteRepository reporteRepository) {
        this.reporteRepository = reporteRepository;
    }

    @Override
    public List<Reporte> obtenerTodos() throws Exception {
        try {
            return reporteRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Error al obtener todos los reportes: " + e.getMessage());
        }
    }

    @Override
    public Optional<Reporte> obtenerPorId(Long id) throws Exception {
        try {
            return reporteRepository.findById(id);
        } catch (Exception e) {
            throw new Exception("Error al obtener el reporte con id " + id + ": " + e.getMessage());
        }
    }

    @Override
    public Reporte crearReporte(Reporte reporte) throws Exception {
        try {
            return reporteRepository.save(reporte);
        } catch (Exception e) {
            throw new Exception("Error al intentar crear un reporte: " + e.getMessage());
        }
    }

    @Override
    public Optional<Reporte> actualizarReporte(Long id, Reporte reporteActualizado) throws Exception {
        try {
            Optional<Reporte> reporteExistente = reporteRepository.findById(id);
            if (reporteExistente.isPresent()) {
                Reporte reporte = reporteExistente.get();
                reporte.setNumeroCuenta(reporteActualizado.getNumeroCuenta());
                reporte.setFecha(reporteActualizado.getFecha());
                reporte.setNombre(reporteActualizado.getNombre());
                reporte.setTipoCuenta(reporteActualizado.getTipoCuenta());
                reporte.setSaldoInicial(reporteActualizado.getSaldoInicial());
                reporte.setEstado(reporteActualizado.getEstado());
                reporte.setValor(reporteActualizado.getValor());
                reporte.setSaldo(reporteActualizado.getSaldo());
                return Optional.of(reporteRepository.save(reporte));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new Exception("Error al actualizar el reporte con id " + id + ": " + e.getMessage());
        }
    }

    @Override
    public void eliminarReporte(Long id) throws Exception {
        try {
            Optional<Reporte> reporte = reporteRepository.findById(id);
            if (reporte.isPresent()) {
                reporteRepository.delete(reporte.get());
            } else {
                throw new Exception("No se ha encontrado el reporte con id: " + id);
            }
        } catch (Exception e) {
            throw new Exception("Error al eliminar el reporte con id " + id + ": " + e.getMessage());
        }
    }
}
