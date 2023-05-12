package ar.edu.utn.frbb.tup.RetailenJavaLabIII.business;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto.CategoriaDto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Categoria;

public interface CategoriaBusiness {

    Categoria altaCategoria(CategoriaDto dto);

    Categoria modificacionCategoria(CategoriaDto dto);

    boolean bajaCategoria(CategoriaDto dto);
}
