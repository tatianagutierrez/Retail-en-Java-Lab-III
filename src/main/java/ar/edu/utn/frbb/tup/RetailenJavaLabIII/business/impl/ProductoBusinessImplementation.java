package ar.edu.utn.frbb.tup.RetailenJavaLabIII.business.impl;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.business.ProductoBusiness;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto.ProductoDto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao.ProductoDao;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductoBusinessImplementation implements ProductoBusiness {

    @Autowired
    ProductoDao dao;

    @Override
    public Producto altaProducto(ProductoDto dto) {
        Producto producto = new Producto();
        settearAtributos(producto, dto);

        dao.guardar(producto);

        return producto;
    }

    @Override
    public Producto modificacionProducto(ProductoDto dto) {
        Producto producto = dao.buscarProductoById(dto.getId());
        settearAtributos(producto, dto);

        dao.editar(producto);

        return producto;
    }

    @Override
    public boolean bajaProducto(ProductoDto dto) {
        Producto producto = dao.buscarProductoById(dto.getId());
        return dao.eliminar(producto);
    }

    private void settearAtributos(Producto producto, ProductoDto dto){
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setCategoria(dto.getCategoria());
        producto.setMarca(dto.getMarca());
        producto.setPrecioLista(dto.getPrecioLista());
        producto.setEspecificaciones(dto.getEspecificaciones());
    }
}
