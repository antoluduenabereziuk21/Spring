package mx.com.gm;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {
    @Value("${index.saludo}")
    private String saludo;
    /*por detras se ejecutando serverless*/
    @GetMapping("/")
    /*sobre inicio recibiremos el objeto modelo*/
    public String inicio(Model model){
        var mensaje = "Hola Mundo Con Thymeleaf,Adios";
        
        var persona = new Persona();
        persona.setNombre("juan");
        persona.setApellido("perez");
        persona.setEmail("juan@juan.com");
        persona.setTelefono("35124546");
        
        log.info("ejecutando el controlador Spring MVC");
        
        model.addAttribute("mensaje",mensaje);
        model.addAttribute("saludo", saludo);
        model.addAttribute("persona", persona);
        return "index";/*por defualt thymeleaf crea archivos html*/
    }
}
