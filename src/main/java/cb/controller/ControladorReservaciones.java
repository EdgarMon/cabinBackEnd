/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cb.controller;

import cb.service.ServiciosReservaciones;
import cb.model.Reservaciones;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorReservaciones {
    /**
     * Clase publica donde se maneja el modelo de metodos CrudRepository
     * se maneja un modelo web usando el "save" y el "all"
     * de igual forma en la parte de controlador se maneja un get, post, y en reto 4 se maneja un put y delete en este momento ya implementados 
     */

 /**
 *
 * @author Edgar Ernesto M.
 */
      @Autowired
    private ServiciosReservaciones servicio;
      /**
    *
    * Clase privada del servicio el Autowired habla sobre que se trabaja en web
    * 
    */
    
/**
*
* @author Edgar Ernesto M.
     * @return  se maneja la lista y se obtiene los datos de cabin
*/
    @GetMapping("/all")
    public List<Reservaciones> getReservations(){
         /**
        *
        * Clase pública del servicio, se obtiene un get que muestra los datos obtenidos en respuesta al post
        * 
        */
        return servicio.getAll();
    }
/**
*
* @author Edgar Ernesto M.
     * @param reservationId id de reservacion
     * @return  se maneja la lista y se obtiene los datos de cabin
*/
    @GetMapping("/{id}")
    public Optional<Reservaciones> getReservation(@PathVariable("id") int reservationId) {
        /**
        *
        * Clase pública del servicio
        * 
        */
        return servicio.getReservation(reservationId);
    }
    /**
 *
 * @author Edgar Ernesto M.
 * el save funciona para postear comando de entrada que se pueden obtener en respuesta en el all
     * @param reservation
     * @return 
 */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones save(@RequestBody Reservaciones reservation) {
        /**
        *
        * Clase publica importante para entrar en los datos de este controlador
        * 
        */
        return servicio.save(reservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones update(@RequestBody Reservaciones reservation) {
        return servicio.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return servicio.deleteReservation(reservationId);
    }
}
