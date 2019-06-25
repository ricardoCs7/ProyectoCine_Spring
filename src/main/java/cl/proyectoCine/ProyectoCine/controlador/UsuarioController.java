/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.proyectoCine.ProyectoCine.controlador;

import cl.proyectoCine.ProyectoCine.dao.UsuarioDAO;
import cl.proyectoCine.ProyectoCine.modelo.Usuario;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Ricardo
 */
@Controller
public class UsuarioController {

    @Autowired
    UsuarioDAO uDAO;

    @GetMapping("/registroUser")
    public String registroUserPage(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registroUser";

    }

    @GetMapping("/getUsuarios")
    @ResponseBody
    public Iterable<Usuario> getUsers() {

        return uDAO.findAll();

    }

    @DeleteMapping("/deleteUsuario/{user_name}")
    @ResponseBody
    public String borrarUsuario(@PathVariable("user_name") String user_name) {

        if (!uDAO.findById(user_name).isPresent()) {
            return "Usuario " + user_name + " no existe";
        }
        uDAO.deleteById(user_name);
        return "Usuario " + user_name + " eliminado";

    }
    
    @GetMapping("/usuario/{user_name}")
	@ResponseBody
	public Optional<Usuario> getUsuarioPorId(@PathVariable("user_name") String user_name){
		if(!uDAO.findById(user_name).isPresent()) {
		return null;
	}else
		
		return uDAO.findById(user_name);
		
	}
    

    @PostMapping("/registroForm")
    @ResponseBody
    public String createUsaurios(@ModelAttribute Usuario usuario) {

        if (uDAO.findById(usuario.getUserName()).isPresent()) {
            return null;
        }

        System.out.println(usuario.getUserName());
        System.out.println(usuario.getPassword());
        System.out.println(usuario.getTipo());
        System.out.println(usuario.getNombre());
        System.out.println(usuario.getApellido());
        System.out.println(usuario.getEmail());

        uDAO.save(usuario);

        return "index";
    }

   
}
