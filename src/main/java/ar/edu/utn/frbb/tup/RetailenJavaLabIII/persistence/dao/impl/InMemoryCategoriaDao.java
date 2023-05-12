package ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao.impl;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Categoria;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao.CategoriaDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public class InMemoryCategoriaDao implements CategoriaDao {

    private ArrayList<Categoria> categorias = new ArrayList<>();

    @Override
    public Categoria guardar(Categoria categoria) {
        // Genera una cadena unica de 36 caracteres
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        categoria.setId(id);

        categorias.add(categoria);
        System.out.println("Se guardo correctamente");
        return categoria;

    }

    @Override
    public Categoria editar(Categoria categoria) {
        if (categoria != null) {
            int index = categorias.indexOf(categoria);
            categorias.add(index, categoria);
            System.out.println("Se editó correctamente");
        }

        return categoria;
    }

    @Override
    public boolean eliminar(Categoria categoria) {

        if (categoria != null){
            categorias.remove(categoria);
            System.out.println("La categoria fue eliminada con exito");
            return true;
        }
        else{
            System.out.println("La categoria no existe");
            return false;
        }

    }

    @Override
    public Categoria buscarCategoria(String id) {

        Categoria categoriaEncontrada = null;

        if (!categorias.isEmpty()){
            for (Categoria categoria : categorias){
                if (categoria.getId().equals(id)){
                    categoriaEncontrada = categoria;
                    break;
                }
            }
        }
        else {
            System.out.println("La lista de categorias esta vacia");
        }

        return categoriaEncontrada;
    }
}
