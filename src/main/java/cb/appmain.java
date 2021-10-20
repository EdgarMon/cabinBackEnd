// 1.Modelo o Entidad
// 2.Interface
// 3.Repositorio
// 4.Servicios
// 5.Controlador o Web


package cb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 *
 * @author Edgar Ernesto M.
 * por buenas practicas se deja comentado el documento
 */
//@EnableConfigurationProperties
//@EntityScan(basePackages = {"com.usa.rentcar.model"})  // scan JPA entities
@SpringBootApplication
public class appmain {
    /**
     * Clase principal y ejecutable del proyecto
     * 
     */
                    /**
                    *
                    * @author Edgar Ernesto M.
                    * @param args 
                    */
	public static void main(String[] args) {
                    /**
                    * Clase principal y ejecutable del proyecto
                    * 
                    */
		SpringApplication.run(appmain.class, args);
	}

}