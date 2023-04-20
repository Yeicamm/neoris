package com.prueba.neoris.service;


import com.prueba.neoris.entity.CrearCuentasUsuarios;

import java.util.List;
import java.util.Optional;


public interface CrearCuentaUsuarioService {

    /**

     Método para obtener todas las cuentas de usuarios
     @return Listado de todas las cuentas de usuarios
     @throws Exception Si ocurre algún error durante la ejecución del método
     */
    List<CrearCuentasUsuarios> obtenerTodos() throws Exception;
    /**

     Método para obtener una cuenta de usuario por ID
     @param id Identificador de la cuenta de usuario
     @return Cuenta de usuario encontrada por ID
     @throws Exception Si ocurre algún error durante la ejecución del método
     */
    Optional<CrearCuentasUsuarios> obtenerPorId(Long id) throws Exception;
    /**

     Método para crear una nueva cuenta de usuario
     @param crearCuentasUsuarios Objeto de tipo CrearCuentasUsuarios que se desea crear
     @return Cuenta de usuario creada
     @throws Exception Si ocurre algún error durante la ejecución del método
     */
    CrearCuentasUsuarios crearCuenta(CrearCuentasUsuarios crearCuentasUsuarios) throws Exception;
    /**

     Método para actualizar una cuenta de usuario existente
     @param id Identificador de la cuenta de usuario que se desea actualizar
     @param crearCuentasUsuarios Objeto de tipo CrearCuentasUsuarios con los datos actualizados
     @return Cuenta de usuario actualizada
     @throws Exception Si ocurre algún error durante la ejecución del método
     */
    Optional<CrearCuentasUsuarios> actualizarCuenta(Long id, CrearCuentasUsuarios crearCuentasUsuarios) throws Exception;
    /**

     Método para eliminar una cuenta de usuario por ID
     @param id Identificador de la cuenta de usuario que se desea eliminar
     @throws Exception Si ocurre algún error durante la ejecución del método
     */
    void eliminarCuenta(Long id) throws Exception;

}
