/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
*
* @author Edgar Ernesto M. 
* por buenas practicas se deja comentado el documento
*/
@Entity
@Table(name ="cabin")
public class Cabin implements Serializable{
    /**
    * @author Edgar Ernesto M. 
    * A continuacion se crea una tabla en el que se puede llamar y en orden se obtiene informacion
    * la informacionestá parametrizada como lo exije la plataforma
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
    *
    * id donde se identifica la tabla
    */
    
    @Column( nullable = false, length = 45)
    private String name;
    /**
    *
    * name se determina un texto de no más de 45 caracteres
    */
    @Column( nullable = false, length =  45)
    private String brand;
    /**
    *
    * Los valores de cantidad de habitaciones deben ser un número que representa la cantidad de habitaciones.
    */
    private Integer rooms;
    
    /**
    *la descripcion se determina un texto de no más de 250 caracteres
    * @author Edgar Ernesto M. 
    */
    @Column( nullable = false, length = 250)
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("cabins")
    /**
    * El valor de categoría debe ser un número entero que representa el id de cada una de las categorías.
    * El usuario debe seleccionar la categoría viendo el nombre de la misma, no el número.
    * @author Edgar Ernesto M. 
    */
    private Categoria category;
    
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "cabin")
    @JsonIgnoreProperties({"cabin", "client"})
    private List<Mensaje> messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "cabin")
    @JsonIgnoreProperties({"cabin", "client"})
    private List<Reservaciones> reservations;
/**
*
* @author Edgar Ernesto M. 
     * @return  se construllen get y set para la comunicacion
*/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public List<Mensaje> getMessages() {
        return messages;
    }

    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    public List<Reservaciones> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservaciones> reservations) {
        this.reservations = reservations;
    }

    
}