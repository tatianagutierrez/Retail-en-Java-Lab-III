package ar.edu.utn.frbb.tup.RetailenJavaLabIII.business;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto.CategoriaDto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Categoria;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;
import java.util.List;

public interface CategoriaBusiness {

    Categoria altaCategoria(CategoriaDto dto);

    Categoria modificarCategoria(CategoriaDto dto);

    boolean bajaCategoria(CategoriaDto dto);

    List<Producto> getProductosOrdenadosByPrecioAsc(CategoriaDto dto);

    List<Producto> getProductosOrdenadosByPrecioDesc(CategoriaDto dto);

    List<Producto> getProductosByMarca(CategoriaDto dto, String marca);

    List<Producto> getProductosFiltradosByPrecios(CategoriaDto dto, Double precioMin, Double precioMax);
}
