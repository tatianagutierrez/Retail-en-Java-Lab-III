package ar.edu.utn.frbb.tup.RetailenJavaLabIII.business.impl;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto.CategoriaDto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Categoria;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao.CategoriaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class CategoriaBusinessImplementation implements CategoriaBusiness {

    @Autowired
    CategoriaDao dao;

    @Override
    public Categoria altaCategoria(CategoriaDto dto) {
        Categoria categoria = new Categoria();
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();

        categoria.setId(id);
        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());

        dao.guardar(categoria);

        return categoria;
    }

    @Override
    public Categoria modificarCategoria(CategoriaDto dto) {
        Categoria categoria = dao.buscarCategoria(dto.getId());
        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());

        dao.editar(categoria);

        return categoria;
    }

    @Override
    public boolean bajaCategoria(CategoriaDto dto) {
        Categoria categoria = dao.buscarCategoria(dto.getId());
        return dao.eliminar(categoria);
    }

    @Override
    public List<Producto> getProductosOrdenadosByPrecioAsc(CategoriaDto dto) {
        Categoria categoria = dao.buscarCategoria(dto.getId());
        return dao.getProductosPorPrecioAsc(categoria);
    }

    @Override
    public List<Producto> getProductosOrdenadosByPrecioDesc(CategoriaDto dto) {
        Categoria categoria = dao.buscarCategoria(dto.getId());
        return dao.getProductosPorPrecioDesc(categoria);
    }

    @Override
    public List<Producto> getProductosByMarca(CategoriaDto dto, String marca) {
        Categoria categoria = dao.buscarCategoria(dto.getId());
        return dao.getProductosByMarca(categoria, marca);
    }

    @Override
    public List<Producto> getProductosFiltradosByPrecios(CategoriaDto dto, Double precioMin, Double precioMax) {
        Categoria categoria = dao.buscarCategoria(dto.getId());
        return dao.getProductosFiltradosByPrecios(categoria, precioMin, precioMax);
    }
}
