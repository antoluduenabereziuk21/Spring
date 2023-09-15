package mx.com.gm.web;


import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    /*agregamos un nvo path para rederizar la ruta*/
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaService.guardar(persona);
        return "redirect:/";
    }
    //dentro esta path luego de /editar/ debe ir tal cual esta definido el atributo en La Clase
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
            persona = personaService.encontrarPersona(persona);
            model.addAttribute("persona", persona);
            return "modificar";
    }
    /* Por detras spring pasa el idPersona. al metodo editar, para luego por el servicio encontrar la persona.
    luego se lo campartimos al model(contenedor de spring) a esta persona recuperada , para luego incluir estos datos en el form y luego porder 
    modificar los datos*/
    
    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona persona, Model model){
            personaService.eliminar(persona);
            return "redirect:/";
    }
    /* pasando por query params solamente tenemos que indicar el path, 
    no es necesario pasar el id como parametro
    
    @GetMapping("/eliminar")
    public String eliminar(Persona persona, Model model){
            personaService.eliminar(persona);
            return "redirect:/";
    }
    */
}
