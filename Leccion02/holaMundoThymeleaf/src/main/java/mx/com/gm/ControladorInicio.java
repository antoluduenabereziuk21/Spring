package mx.com.gm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {
    /*por detras se ejecutando serverless*/
    @GetMapping("/")
    public String inicio(){
        log.info("ejecutando el controlador Spring MVC");
        return "index";/*por defualt thymeleaf crea archivos html*/
    }
}
