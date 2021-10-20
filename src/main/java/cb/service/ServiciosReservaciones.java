/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cb.service;

import cb.repository.RepositorioReservaciones;
import cb.model.Reservaciones;
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
public class ServiciosReservaciones {
    /**
    *Se llama el listado
    * @author Edgar Ernesto M.
     * @return una lista de la catagoria
    */
     @Autowired
    private RepositorioReservaciones metodosCrud;
/**
    *Se llama el listado
    * @author Edgar Ernesto M.
     * @return una lista de la catagoria
    */
    public List<Reservaciones> getAll(){
        return metodosCrud.getAll();
    }
/**
    *Se llama el listado
    * @author Edgar Ernesto M.
     * @param reservationId parametriza una id de la categoria
     * @return una lista de la catagoria
    */
    public Optional<Reservaciones> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }
/**
    *Se guarda en la base
    * @author Edgar Ernesto M.
     * @param reservation 
     * @return una lista de la catagoria
    */
    public Reservaciones save(Reservaciones reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservaciones> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }
/**
    *Se sube a la base
    * @author Edgar Ernesto M.
     * @param reservation 
     * @return una lista de la catagoria
    */
    public Reservaciones update(Reservaciones reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservaciones> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
/**
    *Se borra en la base
    * @author Edgar Ernesto M.
     * @param reservationId 
     * @return una lista de la catagoria
    */
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
