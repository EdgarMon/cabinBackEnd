/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cb.service;

import cb.repository.RepositorioCliente;
import cb.model.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *Se documenta por buenas practicas
 * @author Edgar Ernesto M.
 */
/**
    *Se emplea el servicio de cada categoria
    * @author Edgar Ernesto M.
    */
@Service
public class ServiciosCliente {
       @Autowired
     private RepositorioCliente metodosCrud;
     /**
    *Se llama el listado
    * @author Edgar Ernesto M.
     * @return una lista de la catagoria
    */
     public List<Cliente> getAll(){
        return metodosCrud.getAll();
    }
     /**
    *Se llama el listado
    * @author Edgar Ernesto M.
     * @param clientId parametriza una id de la categoria
     * @return una lista de la catagoria
    */
      public Optional<Cliente> getClient(int clientId) {
        return metodosCrud.getCliente(clientId);
    }
/**
    *Se guarda en la base
    * @author Edgar Ernesto M.
     * @param client 
     * @return una lista de la catagoria
    */
    public Cliente save(Cliente client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }else{
            Optional<Cliente> e= metodosCrud.getCliente(client.getIdClient());
            if(e.isEmpty()){
                return metodosCrud.save(client);
            }else{
                return client;
            }
        }
    }
/**
    *Se sube a la base
    * @author Edgar Ernesto M.
     * @param client 
     * @return una lista de la catagoria
    */
    public Cliente update(Cliente client){
        if(client.getIdClient()!=null){
            Optional<Cliente> e= metodosCrud.getCliente(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
/**
    *Se borra en la base
    * @author Edgar Ernesto M.
     * @param clientId 
     * @return una lista de la catagoria
    */
    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
