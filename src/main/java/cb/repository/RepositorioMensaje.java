/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cb.repository;

import cb.interfaces.InterfaceMensaje;
import cb.model.Mensaje;
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
public class RepositorioMensaje {
      @Autowired
    private InterfaceMensaje crud3;
       /**
    *
    * @author Edgar Ernesto M. 
    * por buenas practicas se deja comentado el documento
    * El crud comunica la interface 
     * @return  
    */
    public List<Mensaje> getAll(){
         /**
        *
        * @author Edgar Ernesto M. 
        * por buenas practicas se deja comentado el documento
        * Se maneja el retorno del crud una lista
        */
        return (List<Mensaje>) crud3.findAll();
    }
    public Optional<Mensaje> getMessage(int id){
        /**
        *
        * @author Edgar Ernesto M. 
        * por buenas practicas se deja comentado el documento
        * Se maneja el retorno del crud una id
        */
        return crud3.findById(id);
    }
/**
*
* @author Edgar Ernesto M. 
* por buenas practicas se deja comentado el documento
* Se guarda o borra en los datos resultados
     * @param message
     * @return 
*/
    public Mensaje save(Mensaje message){
        return crud3.save(message);
    }
    public void delete(Mensaje message){
        crud3.delete(message);
    }
}
