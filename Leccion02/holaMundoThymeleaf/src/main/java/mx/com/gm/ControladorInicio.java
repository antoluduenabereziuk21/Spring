package mx.com.gm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        persona.setEmail("juan@mail.com");
        persona.setTelefono("35124546");
        
        var persona2 = new Persona();
        persona2.setNombre("karla");
        persona2.setApellido("gomez");
        persona2.setEmail("kgomez@mail.com");
        persona2.setTelefono("3512657812");
        
        //List<Persona> personas = new ArrayList();
        //personas.add(persona);
        //personas.add(persona2);
        
        //podemos utilzar var para la inferencia de tipos
        //var personas = new ArrayList();
        //personas.add(persona);
        //personas.add(persona2);
        
        //tambien podemos utilizar esta anotacion tambien
        var personas = Arrays.asList(persona,persona2);
        //var personas = Arrays.asList();
        
        
        
        log.info("ejecutando el controlador Spring MVC");
        
        model.addAttribute("mensaje",mensaje);
        model.addAttribute("saludo", saludo);
        //model.addAttribute("persona", persona); compartiremos el array
        model.addAttribute("personas", personas);
        return "index";/*por defualt thymeleaf crea archivos html*/
    }
}
