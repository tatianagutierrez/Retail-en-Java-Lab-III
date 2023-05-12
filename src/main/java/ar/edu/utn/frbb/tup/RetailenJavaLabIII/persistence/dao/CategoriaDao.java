package ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Categoria;

public interface CategoriaDao {
    Categoria guardar(Categoria categoria);

    Categoria editar(Categoria categoria);

    boolean eliminar(Categoria categoria);

    Categoria buscarCategoria(String id);
}
