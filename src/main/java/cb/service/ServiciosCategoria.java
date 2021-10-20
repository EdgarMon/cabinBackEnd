/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cb.service;

import cb.repository.RepositorioCategoria;
import cb.model.Categoria;
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
public class ServiciosCategoria {
     @Autowired
    private RepositorioCategoria metodosCrud;
/**
    *Se llama el listado
    * @author Edgar Ernesto M.
     * @return una lista de la catagoria
    */
    public List<Categoria> getAll() {
        return metodosCrud.getAll();
    }
/**
    *Se llama el listado
    * @author Edgar Ernesto M.
     * @param CategoriaId parametriza una id de la categoria
     * @return una lista de la catagoria
    */
    public Optional<Categoria> getCategoria(int CategoriaId) {
        return metodosCrud.getCategoria(CategoriaId);
    }
/**
    *Se guarda en la base
    * @author Edgar Ernesto M.
     * @param categoria
     * @return una lista de la catagoria
    */
    public Categoria save(Categoria categoria) {
        if (categoria.getId()== null) {
            return metodosCrud.save(categoria);
        } else {
            Optional<Categoria> categoria1 = metodosCrud.getCategoria(categoria.getId());
            if (categoria1.isEmpty()) {
                return metodosCrud.save(categoria);
            } else {
                return categoria;
            }
        }
    }
/**
    *Se sube a la base
    * @author Edgar Ernesto M.
     * @param categoria 
     * @return una lista de la catagoria
    */
    public Categoria update(Categoria categoria){
        if(categoria.getId()!=null){
            Optional<Categoria>g=metodosCrud.getCategoria(categoria.getId());
            if(!g.isEmpty()){
                if(categoria.getDescription()!=null){
                    g.get().setDescription(categoria.getDescription());
                }
                if(categoria.getName()!=null){
                    g.get().setName(categoria.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return categoria;
    }
    /**
    *Se borra en la base
    * @author Edgar Ernesto M.
     * @param categoriaId 
     * @return una lista de la catagoria
    */
    public boolean deletecategoria(int categoriaId){
        Boolean d=getCategoria(categoriaId).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
    
}
