
package cb.model;

import cb.model.Cabin;
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
@Table(name = "category")
public class Categoria implements Serializable {
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
    @Column( nullable = false, length = 250)
    private String description;
    /**
    *la descripcion se determina un texto de no más de 250 caracteres
    * @author Edgar Ernesto M. 
    */
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="category")
    @JsonIgnoreProperties("category")
    private List<Cabin> cabins;
/**
*
* @author Edgar Ernesto M. 
     * @return  se construllen get y set para la comunicacion de la tabla con las demás 
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public List<Cabin> getCabins() {
        return cabins;
    }

    public void setCabins(List<Cabin> cabins) {
        this.cabins = cabins;
    }
    
    
    
}
