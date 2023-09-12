package mx.com.gm.domain;

import lombok.Data;
/*Data viene de lombok y nos auto generara el jabaBins(Constructores,geters y seters ,etc)*/
@Data
public class Persona {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
}
