package ar.edu.utn.frbb.tup.RetailenJavaLabIII.business.impl;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto.CategoriaDto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Categoria;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao.CategoriaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;


@Service
public class CategoriaBusinessImplementation implements CategoriaBusiness {

    @Autowired
    CategoriaDao dao;

    private Categoria categoria;

    @Override
    public Categoria altaCategoria(CategoriaDto dto) {
        categoria = new Categoria();
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
        try{
            categoria = dao.buscarCategoria(dto.getId());
            categoria.setNombre(dto.getNombre());
            categoria.setDescripcion(dto.getDescripcion());

        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return dao.editar(categoria);
    }

    @Override
    public boolean bajaCategoria(CategoriaDto dto) {
        try{
            categoria = dao.buscarCategoria(dto.getId());

        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return dao.eliminar(categoria);
    }

    @Override
    public Categoria consultarCategoriaById(String id) {
        try{
            return dao.buscarCategoria(id);

        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Producto> getProductosOrdenadosByPrecioAsc(CategoriaDto dto) {
        categoria = dao.buscarCategoria(dto.getId());
        return dao.getProductosPorPrecioAsc(categoria);
    }

    @Override
    public List<Producto> getProductosOrdenadosByPrecioDesc(CategoriaDto dto) {
        categoria = dao.buscarCategoria(dto.getId());
        return dao.getProductosPorPrecioDesc(categoria);
    }

    @Override
    public List<Producto> getProductosByMarca(CategoriaDto dto, String marca) {
        categoria = dao.buscarCategoria(dto.getId());
        return dao.getProductosByMarca(categoria, marca);
    }

    @Override
    public List<Producto> getProductosFiltradosByPrecios(CategoriaDto dto, Double precioMin, Double precioMax) {
        categoria = dao.buscarCategoria(dto.getId());
        return dao.getProductosFiltradosByPrecios(categoria, precioMin, precioMax);
    }
}
