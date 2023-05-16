package ar.edu.utn.frbb.tup.RetailenJavaLabIII.business;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto.ProductoDto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;

import java.util.List;

public interface ProductoBusiness {

    Producto altaProducto(ProductoDto dto);

    Producto modificacionProducto(ProductoDto dto);

    boolean bajaProducto(ProductoDto dto);

    Producto consultarProductoById(String id);

    List<Producto> consultarProductosByAtributos(String tipo, String marca, String categoria);
}
