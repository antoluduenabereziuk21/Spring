package mx.com.gm.web;


import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.dao.PersonaDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {
    /*Para poder inyectar cualkier depencia que puede ser administrado
    por el contenedor  debemos inculuir la anotacion @Autowired
    Similar al @inyect de javaEE*/
    
    @Autowired
    private PersonaDao personaDao;

    @GetMapping("/")
    /*sobre inicio recibiremos el objeto modelo*/
    public String inicio(Model model){
       
        var personas = personaDao.findAll();
        
        log.info("ejecutando el controlador Spring MVC");
        
        
        model.addAttribute("personas", personas);
        return "index";/*por defualt thymeleaf crea archivos html*/
    }
}
