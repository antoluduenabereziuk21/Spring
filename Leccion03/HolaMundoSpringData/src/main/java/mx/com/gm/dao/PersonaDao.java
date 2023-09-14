package mx.com.gm.dao;

import mx.com.gm.domain.Persona;
import org.springframework.data.repository.CrudRepository;
/*
esta interfance extiende de crudrepository(es las que tiene los metodos crud) que propia de spring.jpa
y como es una instancia generiac debemos indicarle que tipo de entedidad manejara
y cual es el tipo de lleve primaria que manejara
*/
public interface PersonaDao extends CrudRepository<Persona,Long> {
    
}
