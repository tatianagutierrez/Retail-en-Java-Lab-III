package ar.edu.utn.frbb.tup.RetailenJavaLabIII.business.impl;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto.CategoriaDto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Categoria;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao.CategoriaDao;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoriaBusinessImplementation implements CategoriaBusiness {

    @Autowired
    CategoriaDao dao;

    @Override
    public Categoria altaCategoria(CategoriaDto dto) {
        Categoria categoria = new Categoria();
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
}
