/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cb.model;

import cb.model.Cliente;
import cb.model.Cabin;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
*
* @author Edgar Ernesto M. 
* por buenas practicas se deja comentado el documento
*/
@Entity
@Table(name = "reservation")
public class Reservaciones implements Serializable  {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    /**
    *
    * @author Edgar Ernesto M. 
    * Los valores de fecha de inicio y fecha entrega deben ser fechas en el formato YYYY-mm-dd
    * la fecha se garantiza usando el startDate cumpliendo con la plataforma
    */
    private Date devolutionDate;
     /**
    *
    * @author Edgar Ernesto M. 
    * La reserva creada debe tener status: 'Creado' y la fecha de creación, debe ser tomada del reloj del sistema. No son datos que el usuario ingrese.
    */
    private String status="created";
    
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("reservations")
    //
    private Cabin cabin;
    /**
    *
    * @author Edgar Ernesto M. 
    * por buenas practicas se deja comentado el documento
    * El valor de cabaña corresponde al id de cada cabaña y es un valor numérico.
    * El usuario debe seleccionar el cabaña por su nombre, puesto que el id debe ser invisible para el usuario.
    */

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"reservations","messages"})
    private Cliente client;
    /**
    *Los valores de cliente debe ser un numero entero correspondiente al id del cliente.
    * @author Edgar Ernesto M. 
    * 
    */

    private String score; 
/**
*
* @author Edgar Ernesto M. 
     * @return  se construllen get y set para la comunicacion
*/
    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cabin getCabin() {
        return cabin;
    }

    public void setCabin(Cabin cabin) {
        this.cabin = cabin;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public String getScore() {
       return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

}
