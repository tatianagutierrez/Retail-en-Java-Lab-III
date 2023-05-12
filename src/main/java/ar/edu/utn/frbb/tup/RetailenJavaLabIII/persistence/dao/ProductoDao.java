package ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;

public interface ProductoDao {
    Producto guardar(Producto producto);

    Producto editar(Producto producto);

    boolean eliminar(Producto producto);

    Producto buscarProductoById(String id);

    //Producto buscarProductoByAtributo(String atributo);
}
