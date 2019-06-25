/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.proyectoCine.ProyectoCine.dao;

import cl.proyectoCine.ProyectoCine.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;



/**
 *
 * @author Ricardo
 */

public interface UsuarioDAO extends CrudRepository<Usuario,String> {

    
    
    
}
