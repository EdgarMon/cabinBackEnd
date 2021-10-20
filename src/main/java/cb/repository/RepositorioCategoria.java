/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cb.repository;

import cb.interfaces.InterfaceCategoria;
import cb.model.Categoria;
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
public class RepositorioCategoria {
    @Autowired
    private InterfaceCategoria crud;
    /**
    *
    * @author Edgar Ernesto M. 
    * por buenas practicas se deja comentado el documento
    * El crud comunica la interface 
    */
    public List<Categoria> getAll(){
        /**
        *
        * @author Edgar Ernesto M. 
        * por buenas practicas se deja comentado el documento
        * Se maneja el retorno del crud una lista
        */
        return (List<Categoria>) crud.findAll();
    }
    public Optional<Categoria> getCategoria(int id){
        /**
        *
        * @author Edgar Ernesto M. 
        * por buenas practicas se deja comentado el documento
        * Se maneja el retorno del crud una id
        */
        return crud.findById(id);
    }
/**
*
* @author Edgar Ernesto M. 
* por buenas practicas se deja comentado el documento
* Se guarda o borra en los datos resultados
*/
    public Categoria save(Categoria Categoria){
        return crud.save(Categoria);
    }
    public void delete(Categoria Categoria){
       crud.delete(Categoria);
    }
}
