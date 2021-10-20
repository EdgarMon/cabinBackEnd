/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cb.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name ="calificacionReservas")
public class CalificacionReservas implements Serializable{
    
    //Los valores de calificación debe ser un número entero entre 0 y 5.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCalificationReservation;
    
    private Integer calification;
    /**
    *la descripcion se determina un texto de no más de 250 caracteres
    * @author Edgar Ernesto M. 
    */
    @Column( nullable = false, length =  250)
    private String calificationReservationMessage;
    private String reservation;

    public Integer getIdCalificationReservation() {
        return idCalificationReservation;
    }

    public void setIdCalificationReservation(Integer idCalificationReservation) {
        this.idCalificationReservation = idCalificationReservation;
    }

    public Integer getCalification() {
        return calification;
    }

    public void setCalification(Integer calification) {
        this.calification = calification;
    }

    public String getCalificationReservationMessage() {
        return calificationReservationMessage;
    }

    public void setCalificationReservationMessage(String calificationReservationMessage) {
        this.calificationReservationMessage = calificationReservationMessage;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }
    
    
}
