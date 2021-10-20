/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cb.repository;

import cb.interfaces.InterfaceReservaciones;
import cb.model.Reservaciones;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
*
* @author Edgar Ernesto M. 
* por buenas practicas se deja comentado el documento
* Se crea un repositorio para esta categoria 
*/
@Repository
public class RepositorioReservaciones {
    /**
    *
    * @author Edgar Ernesto M. 
    * por buenas practicas se deja comentado el documento
    * El crud comunica la interface 
    */
       @Autowired
    private InterfaceReservaciones crud4;
       

    public List<Reservaciones> getAll(){
        /**
        *
        * @author Edgar Ernesto M. 
        * por buenas practicas se deja comentado el documento
        * Se maneja el retorno del crud una lista
        */
        return (List<Reservaciones>) crud4.findAll();
    }
    /**
        *
        * @author Edgar Ernesto M. 
        * por buenas practicas se deja comentado el documento
        * Se maneja el retorno del crud una id
     * @param id
     * @return 
        */
    public Optional<Reservaciones> getReservation(int id){
        return crud4.findById(id);
    }
/**
*
* @author Edgar Ernesto M. 
* por buenas practicas se deja comentado el documento
* Se guarda o borra en los datos resultados
     * @param reservation
     * @return 
*/
    public Reservaciones save(Reservaciones reservation){
        return crud4.save(reservation);
    }
    public void delete(Reservaciones reservation){
        crud4.delete(reservation);
    }
}
