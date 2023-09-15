package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
Agregamos la anotacion de @Service para que spring la identifique como tal , para asi 
poder inyectarla en el 
 */

@Service
public class PersonaServiceImpl implements PersonaService {
    
    @Autowired
    private PersonaDao personaDao;
    /*
    Cuando estamos dentro de la capa DAO se maneja el tema de transacciones,Esto quiere decir que cualquier operacion
    con la base de datos en dado caso de error se va ser un roll back o en caso que todo sea exitoso un comite.
    Pero al estar Trabajando en la capa servicio podriamos estar utilizando varios objetos de tipo Dao, desde esta misma.
    Por lo tanto debemos hacer uso De las Transacciones, Poner la anotacion de @Transactional ya que caso de error tiene 
    que hacer un roll back y no guardar informacion en ninguna de las tablas .Y en dado caso de que sea exitoso debe hacer 
    un commit de toda la transaccion, guardando la informacion en las tablas afectadas
    Dependiendo del tipo de metodo es el tipo de transaccion que utilizaremos
    
        Si la transacion es solo de lectura @Transactional(readOnly = true)
        Si la transacion es de guardar,modificar,elinar @Transactional , para que haga commit ò roll back segun el caso
    */
    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        //*Se debe hacer un cateo porque findAll devuelve Un  Objeto
        return (List<Persona>)personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        //findById devuelve un tipo optional , por lo caul si no se encuentra devolveremos null
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }

}
