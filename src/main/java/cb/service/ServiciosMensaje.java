/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cb.service;

import cb.repository.RepositorioMensaje;
import cb.model.Mensaje;
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
public class ServiciosMensaje {
    @Autowired
    private RepositorioMensaje metodosCrud;
/**
    *Se llama el listado
    * @author Edgar Ernesto M.
     * @return una lista de la catagoria
    */
    public List<Mensaje> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Mensaje> getMessage(int messageId) {
        return metodosCrud.getMessage(messageId);
    }
/**
    *Se guarda en la base
    * @author Edgar Ernesto M.
     * @param message 
     * @return una lista de la catagoria
    */
    public Mensaje save(Mensaje message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            Optional<Mensaje> e= metodosCrud.getMessage(message.getIdMessage());
            if(e.isEmpty()){
                return metodosCrud.save(message);
            }else{
                return message;
            }
        }
    }
/**
    *Se sube a la base
    * @author Edgar Ernesto M.
     * @param message 
     * @return una lista de la catagoria
    */
    public Mensaje update(Mensaje message){
        if(message.getIdMessage()!=null){
            Optional<Mensaje> e= metodosCrud.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
/**
    *Se borra en la base
    * @author Edgar Ernesto M.
     * @param messageId 
     * @return una lista de la catagoria
    */
    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
