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
 * @author Edgar Ernesto M.
 */
@Entity
@Table(name ="usuariosAdministrativos")
public class UsuariosAdministrativos implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUserAdmin;
    /**
    *la descripcion se determina un texto de no más de 250 caracteres
    * @author Edgar Ernesto M. 
    */
    @Column( nullable = false, length =  250)
    private String nameUserAdmin;
    /**
    *la descripcion se determina un texto de no más de 45 caracteres
    * @author Edgar Ernesto M. 
    */
    @Column( nullable = false, length =  45)
    private String emailUserAdmin;
    private String passwordUserAdmin;

    public Integer getIdUserAdmin() {
        return idUserAdmin;
    }

    public void setIdUserAdmin(Integer idUserAdmin) {
        this.idUserAdmin = idUserAdmin;
    }

    public String getNameUserAdmin() {
        return nameUserAdmin;
    }

    public void setNameUserAdmin(String nameUserAdmin) {
        this.nameUserAdmin = nameUserAdmin;
    }

    public String getEmailUserAdmin() {
        return emailUserAdmin;
    }

    public void setEmailUserAdmin(String emailUserAdmin) {
        this.emailUserAdmin = emailUserAdmin;
    }

    public String getPasswordUserAdmin() {
        return passwordUserAdmin;
    }

    public void setPasswordUserAdmin(String passwordUserAdmin) {
        this.passwordUserAdmin = passwordUserAdmin;
    }
    
}
