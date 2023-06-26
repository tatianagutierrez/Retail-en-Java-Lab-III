package ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao;


import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;

import java.util.ArrayList;
import java.util.List;

public interface ProductoDao {
    Producto guardar(Producto producto);

    Producto editar(Producto producto);

    boolean eliminar(Producto producto);

    ArrayList<Producto> getListaDeProductos();

    Producto buscarProductoById(String id);

    List<Producto> buscarProductosByAtributos(String tipo, String marca, String categoria);
}
