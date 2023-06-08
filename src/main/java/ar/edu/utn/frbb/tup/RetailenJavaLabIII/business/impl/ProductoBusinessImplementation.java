package ar.edu.utn.frbb.tup.RetailenJavaLabIII.business.impl;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.business.ProductoBusiness;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto.ProductoDto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao.ProductoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ProductoBusinessImplementation implements ProductoBusiness {

    @Autowired
    ProductoDao dao;

    private Producto producto;

    @Override
    public Producto altaProducto(ProductoDto dto) {
        producto = new Producto();

        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        producto.setId(id);

        settearAtributos(producto, dto);
        return dao.guardar(producto);
    }

    @Override
    public Producto modificacionProducto(ProductoDto dto) {
        try{
            producto = dao.buscarProductoById(dto.getId());
            settearAtributos(producto, dto);

        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return dao.editar(producto);
    }

    @Override
    public boolean bajaProducto(ProductoDto dto) {
        try{
            producto = dao.buscarProductoById(dto.getId());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return dao.eliminar(producto);
    }

    @Override
    public Producto consultarProductoById(String id) {
        try{
            return dao.buscarProductoById(id);

        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Producto> consultarProductosByAtributos(String tipo, String marca, String categoriaId) {
        return dao.buscarProductosByAtributos(tipo, marca, categoriaId);
    }

    private void settearAtributos(Producto producto, ProductoDto dto){
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setCategoriaId(dto.getCategoriaId());
        producto.setMarca(dto.getMarca());
        producto.setPrecio(dto.getPrecio());
        producto.setTipo(dto.getTipo());
        producto.setEspecificaciones(dto.getEspecificaciones());
    }
}
