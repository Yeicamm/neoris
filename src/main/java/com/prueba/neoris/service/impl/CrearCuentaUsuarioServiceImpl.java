package com.prueba.neoris.service.impl;


import com.prueba.neoris.entity.CrearCuentasUsuarios;
import com.prueba.neoris.repository.CrearCuentasUsuariosRepository;
import com.prueba.neoris.service.CrearCuentaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrearCuentaUsuarioServiceImpl implements CrearCuentaUsuarioService {

    @Autowired
    private CrearCuentasUsuariosRepository crearCuentasUsuariosRepository;

    public CrearCuentaUsuarioServiceImpl(CrearCuentasUsuariosRepository crearCuentasUsuariosRepository) {
        this.crearCuentasUsuariosRepository = crearCuentasUsuariosRepository;
    }
    @Override
    public List<CrearCuentasUsuarios> obtenerTodos() throws Exception {
        return crearCuentasUsuariosRepository.findAll();

    }
    @Override
    public Optional<CrearCuentasUsuarios> obtenerPorId(Long id) throws Exception {
        Optional<CrearCuentasUsuarios> crearCuentasUsuarios = crearCuentasUsuariosRepository.findById(id);
        if (crearCuentasUsuarios.isPresent()) {
            CrearCuentasUsuarios crearCuentasUsuariosNew = crearCuentasUsuarios.get();
            return Optional.of(crearCuentasUsuariosNew);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public CrearCuentasUsuarios crearCuenta(CrearCuentasUsuarios crearCuentaUsuario) throws Exception{
        try {
            return crearCuentasUsuariosRepository.save(crearCuentaUsuario);
        } catch (Exception e) {
            throw new Exception("Error al intentar crear una cuenta: " + e.getMessage());
        }
    }


    @Override
    public Optional<CrearCuentasUsuarios> actualizarCuenta(Long id, CrearCuentasUsuarios crearCuentasUsuarios) throws Exception {
        try {
            Optional<CrearCuentasUsuarios> crearCuentasUsuariosNew = crearCuentasUsuariosRepository.findById(id);
            if (crearCuentasUsuariosNew.isPresent()) {
                crearCuentasUsuarios.setNumeroCuenta(crearCuentasUsuarios.getNumeroCuenta());
                crearCuentasUsuarios.setTipoCuenta(crearCuentasUsuarios.getTipoCuenta());
                crearCuentasUsuarios.setSaldoInicial(crearCuentasUsuarios.getSaldoInicial());
                crearCuentasUsuarios.setEstado(crearCuentasUsuarios.getEstado());
                crearCuentasUsuarios.setNombre(crearCuentasUsuarios.getNombre());
                crearCuentasUsuarios = crearCuentasUsuariosRepository.save(crearCuentasUsuarios);
                return Optional.of(crearCuentasUsuarios);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new Exception("Error al actualizar el usuario: " + e.getMessage());
        }
    }
    @Override
    public void eliminarCuenta(Long id) throws Exception {
        try {
            Optional<CrearCuentasUsuarios> CrearCuentasUsuarios = crearCuentasUsuariosRepository.findById(id);
            if (CrearCuentasUsuarios.isPresent()) {
                crearCuentasUsuariosRepository.delete(CrearCuentasUsuarios.get());
            } else {
                throw new Exception("No se ha encontrado la cuenta con id: " + id);
            }
        } catch (Exception e) {
            throw new Exception("Error al eliminar la cuenta de usuario con id " + id + ": " + e.getMessage());
        }
    }
}
