/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.proyectoCine.ProyectoCine.controlador;

import cl.proyectoCine.ProyectoCine.dao.UsuarioDAO;
import cl.proyectoCine.ProyectoCine.modelo.LoginForm;
import cl.proyectoCine.ProyectoCine.modelo.Usuario;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Ricardo
 */
@Controller
public class LoginController {

    @Autowired
    private UsuarioDAO uDAO;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";

    }

    
    //--------
    //No retorna las paginas index, sino String 
    @GetMapping("/loginUser")
    @ResponseBody
    public String Loguearse(@ModelAttribute LoginForm loginForm) {

        String lfUser = loginForm.getUserName().toString();

        if (uDAO.findById(lfUser).isPresent()) {

            return "index";
        } else {
            return "index";
        }
    }

}
