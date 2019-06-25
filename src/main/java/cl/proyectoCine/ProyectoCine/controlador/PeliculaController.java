/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.proyectoCine.ProyectoCine.controlador;

import cl.proyectoCine.ProyectoCine.dao.PeliculaDAO;
import cl.proyectoCine.ProyectoCine.modelo.Pelicula;
import javax.validation.constraints.AssertFalse.List;
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
public class PeliculaController {

    @Autowired
    private PeliculaDAO pDAO;

    @RequestMapping("/subirPelicula")
    public String subirPeliPage(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "subirPelicula";
    }
    
    @GetMapping("/peliculas")
    public String verCartelera(Model model) {
        
        Iterable<Pelicula> lista = pDAO.findAll();
        
        model.addAttribute("listaPeliculas", lista);
        return "cartelera";
    }

    @PostMapping("/peliculaForm")
    @ResponseBody
    public String subirPeli(@ModelAttribute Pelicula pelicula) {

        if (pDAO.findById(pelicula.getTitulo()).isPresent()) {
            return null;
        }
        System.out.println(pelicula.getTitulo());
        System.out.println(pelicula.getCategoriaid());
        System.out.println(pelicula.getIdiomaid());

        pDAO.save(pelicula);

        return "index";
    }

}
