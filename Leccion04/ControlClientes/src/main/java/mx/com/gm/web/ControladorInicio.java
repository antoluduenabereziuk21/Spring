package mx.com.gm.web;


import lombok.extern.slf4j.Slf4j;
import mx.com.gm.servicio.PersonaService;
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
    private PersonaService personaService;

    @GetMapping("/")
    /*sobre inicio recibiremos el objeto modelo*/
    public String inicio(Model model){
       
        var personas = personaService.listarPersonas();
        
        log.info("ejecutando el controlador Spring MVC");
        
        
        model.addAttribute("personas", personas);
        return "index";/*por defualt thymeleaf crea archivos html*/
    }
}
