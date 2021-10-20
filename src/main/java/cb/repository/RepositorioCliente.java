/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cb.repository;

import cb.interfaces.InterfaceCliente;
import cb.model.Cliente;
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
public class RepositorioCliente {
    
      @Autowired
    private InterfaceCliente crud1;
      /**
    *
    * @author Edgar Ernesto M. 
    * por buenas practicas se deja comentado el documento
    * El crud comunica la interface 
    */

    public List<Cliente> getAll(){
        return (List<Cliente>) crud1.findAll();
    }
    public Optional<Cliente> getCliente(int id){
        /**
        *
        * @author Edgar Ernesto M. 
        * por buenas practicas se deja comentado el documento
        * Se maneja el retorno del crud una id
        */
        return crud1.findById(id);
    }
 /**
*
* @author Edgar Ernesto M. 
* por buenas practicas se deja comentado el documento
* Se guarda o borra en los datos resultados
     * @param cliente
     * @return 
*/
    public Cliente save(Cliente cliente){
        return crud1.save(cliente);
    }
    public void delete(Cliente cliente){
        crud1.delete(cliente);
    }
}
