/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cb.controller;

import cb.service.ServiciosCabin;
import cb.model.Cabin;
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

@RestController
@RequestMapping("/api/Cabin")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
public class ControladorCabin {
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
    private ServiciosCabin servicio;
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
    public List<Cabin> getCabin(){
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
     * @param cabinId este parametriza la id cabin
     * @return  se maneja la lista y se obtiene los datos de cabin
*/
    @GetMapping("/{id}")
    public Optional<Cabin> getCabin(@PathVariable("id") int cabinId) {
        /**
        *
        * Clase pública del servicio
        * 
        */
        return servicio.getCabin(cabinId);
    }
/**
 *
 * @author Edgar Ernesto M.
 * el save funciona para postear comando de entrada que se pueden obtener en respuesta en el all
     * @param cabin
     * @return 
 */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin save(@RequestBody Cabin cabin) {
        /**
        *
        * Clase publica importante para entrar en los datos de este controlador
        * 
        */
        return servicio.save(cabin);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin update(@RequestBody Cabin cabin) {
        return servicio.update(cabin);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int cabinId) {
        return servicio.deleteCabin(cabinId);
    } 
}
