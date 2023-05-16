package ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Categoria;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;

import java.util.List;

public interface CategoriaDao {
    Categoria guardar(Categoria categoria);

    Categoria editar(Categoria categoria);

    boolean eliminar(Categoria categoria);

    Categoria buscarCategoria(String id);

    List<Producto> getProductosPorPrecioAsc(Categoria c);

    List<Producto> getProductosPorPrecioDesc(Categoria c);

    List<Producto> getProductosByMarca(Categoria categoria, String marca);

    List<Producto> getProductosFiltradosByPrecios(Categoria categoria, Double precioMin, Double precioMax);
}
