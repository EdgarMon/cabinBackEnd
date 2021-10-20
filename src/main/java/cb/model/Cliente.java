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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
*
* @author Edgar Ernesto M. 
* por buenas practicas se deja comentado el documento
*/
@Entity
@Table(name = "client")
public class Cliente implements Serializable {
    /**
    * @author Edgar Ernesto M. 
    * A continuacion se crea una tabla en el que se puede llamar y en orden se obtiene informacion
    * la informacionestá parametrizada como lo exije la plataforma
    */
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
     /**
    *
    * id donde se identifica la tabla
    */
     @Column( nullable = false, length = 45)
    private String email;
     /**
    *
    * email se determina un texto de no más de 45 caracteres
    */
     @Column( nullable = false, length = 45)
    private String password;
     /**
    *
    * password se determina un texto de no más de 45 caracteres
    */
     @Column( nullable = false, length = 250)
    private String name;
     /**
    *
    * name se determina un texto de no más de 250 caracteres
    */

    private Integer age;
     /**
    *
    * Los valores de edad deben ser un número que represente los años.
    */
    
     @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties("client")
    public List<Mensaje>messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties("client")
    public List<Reservaciones>reservations;
/**
*
* @author Edgar Ernesto M. 
     * @return  se construllen get y set para la comunicacion de la tabla con las demas
*/
    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
