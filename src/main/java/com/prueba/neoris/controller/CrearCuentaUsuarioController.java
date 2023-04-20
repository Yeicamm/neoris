package com.prueba.neoris.controller;

import com.prueba.neoris.entity.CrearCuentasUsuarios;
import com.prueba.neoris.service.CrearCuentaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuentas")
public class CrearCuentaUsuarioController {


    @Autowired
    private CrearCuentaUsuarioService crearCuentaUsuarioService;

    @GetMapping
    public ResponseEntity<List<CrearCuentasUsuarios>> obtenerTodasLasCuentas() throws Exception{
        try {
            List<CrearCuentasUsuarios> crearCuentasUsuarios = crearCuentaUsuarioService.obtenerTodos();
            return new ResponseEntity<>(crearCuentasUsuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<CrearCuentasUsuarios> obtenerCuentaPorId(@PathVariable Long id) {
        try {
            Optional<CrearCuentasUsuarios> crearCuentasUsuarios = crearCuentaUsuarioService.obtenerPorId(id);
            if (crearCuentasUsuarios.isPresent()) {
                return new ResponseEntity<>(crearCuentasUsuarios.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping
    public ResponseEntity<CrearCuentasUsuarios> crearCuenta(@RequestBody CrearCuentasUsuarios crearCuentasUsuarios) {
        try {
            CrearCuentasUsuarios crearCuentasUsuariosNew = crearCuentaUsuarioService.crearCuenta(crearCuentasUsuarios);
            return new ResponseEntity<>(crearCuentasUsuariosNew, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<CrearCuentasUsuarios> actualizarCuenta(@PathVariable Long id, @RequestBody CrearCuentasUsuarios crearCuentasUsuarios) {
        try {
            Optional<CrearCuentasUsuarios> crearCuentasUsuariosNew = crearCuentaUsuarioService.actualizarCuenta(id, crearCuentasUsuarios);
            if (crearCuentasUsuariosNew.isPresent()) {
                return new ResponseEntity<>(crearCuentasUsuariosNew.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarCuenta(@PathVariable Long id) {
        try {
            crearCuentaUsuarioService.eliminarCuenta(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}


