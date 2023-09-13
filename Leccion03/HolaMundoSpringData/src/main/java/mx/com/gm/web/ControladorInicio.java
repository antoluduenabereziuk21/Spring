package mx.com.gm.web;


import java.util.List;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @GetMapping("/")
    /*sobre inicio recibiremos el objeto modelo*/
    public String inicio(Model model){
       
        //var personas = Arrays.asList(persona,persona2);
        
        log.info("ejecutando el controlador Spring MVC");
        
        
        //model.addAttribute("personas", personas);
        return "index";/*por defualt thymeleaf crea archivos html*/
    }
}
