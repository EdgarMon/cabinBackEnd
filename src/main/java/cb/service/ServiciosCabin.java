/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cb.service;

import cb.repository.RepositorioCabin;
import cb.model.Cabin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *Se documenta por buenas practicas
 * @author Edgar Ernesto M.
 */

@Service
public class ServiciosCabin {
    /**
    *Se emplea el servicio de cada categoria
    * @author Edgar Ernesto M.
    */
     @Autowired
    private RepositorioCabin metodosCrud;
     /**
    *Se llama el listado
    * @author Edgar Ernesto M.
     * @return una lista de la catagoria
    */

    public List<Cabin> getAll(){
        return metodosCrud.getAll();
    }
/**
    *Se llama el listado
    * @author Edgar Ernesto M.
     * @param cabinId parametriza una id de la categoria
     * @return una lista de la catagoria
    */
    public Optional<Cabin> getCabin(int cabinId) {
        return metodosCrud.getCabin(cabinId);
    }
/**
    *Se guarda en la base
    * @author Edgar Ernesto M.
     * @param cabin 
     * @return una lista de la catagoria
    */
    public Cabin save(Cabin cabin){
        if(cabin.getId()==null){
            return metodosCrud.save(cabin);
        }else{
            Optional<Cabin> e=metodosCrud.getCabin(cabin.getId());
            if(e.isEmpty()){
                return metodosCrud.save(cabin);
            }else{
                return cabin;
            }
        }
    }
/**
    *Se sube a la base
    * @author Edgar Ernesto M.
     * @param cabin 
     * @return una lista de la catagoria
    */
    public Cabin update(Cabin cabin){
        if(cabin.getId()!=null){
            Optional<Cabin> e=metodosCrud.getCabin(cabin.getId());
            if(!e.isEmpty()){
                if(cabin.getName()!=null){
                    e.get().setName(cabin.getName());
                }
                if(cabin.getBrand()!=null){
                    e.get().setBrand(cabin.getBrand());
                }
                if(cabin.getRooms()!=null){
                    e.get().setRooms(cabin.getRooms());
                }
                if(cabin.getDescription()!=null){
                    e.get().setDescription(cabin.getDescription());
                }
                if(cabin.getCategory()!=null){
                    e.get().setCategory(cabin.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return cabin;
            }
        }else{
            return cabin;
        }
    }

/**
    *Se borra en la base
    * @author Edgar Ernesto M.
     * @param cabinId 
     * @return una lista de la catagoria
    */
    public boolean deleteCabin(int cabinId) {
        Boolean aBoolean = getCabin(cabinId).map(cabin -> {
            metodosCrud.delete(cabin);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}