package cl.proyectoCine.ProyectoCine.controlador;

import cl.proyectoCine.ProyectoCine.dao.IdiomaDAO;
import cl.proyectoCine.ProyectoCine.modelo.Idioma;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Ricardo
 */
@Controller
public class IdiomaController {

    @Autowired
    IdiomaDAO iDAO;

    @ModelAttribute("/idiomas")
    public Iterable<Idioma> getIdiomas() {
        return iDAO.findAll();
    }
    
    
    

    @PostMapping("/crearIdioma")
    @ResponseBody
    public Idioma createIdioma(@ModelAttribute Idioma idioma) {
        ArrayList<Idioma> idiomas = (ArrayList<Idioma>) iDAO.findAll();

        if (idiomas.size() != 0) {
            idioma.setId(idiomas.get(idiomas.size() - 1).getId() + 1);
        } else {
            idioma.setId(1);
        }

        if (iDAO.findById(idioma.getId()).isPresent()) {
            return null;
        }
        return iDAO.save(idioma);
    }

    @DeleteMapping("/deleteIdioma/{id}")
    @ResponseBody
    public String deleteIdioma(@PathVariable("id") int id) {

        if (!iDAO.findById(id).isPresent()) {

            return "Idioma no existe";
        }
        Optional<Idioma> currentIdioma = iDAO.findById(id);

        iDAO.deleteById(id);
        return "Idioma " + currentIdioma.get().getDescripcion() + " eliminado";
    }

}
