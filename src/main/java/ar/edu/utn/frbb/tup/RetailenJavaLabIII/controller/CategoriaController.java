package ar.edu.utn.frbb.tup.RetailenJavaLabIII.controller;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto.CategoriaDto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoriaController {

    @Autowired
    CategoriaBusiness categoriaBusiness;

    // TODO: consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE
    @PostMapping(value = "/categoria")
    public Categoria crearCategoria(@RequestBody CategoriaDto dto){
        return categoriaBusiness.altaCategoria(dto);
    }

    @PutMapping(value = "/categoria/{id}")
    public Categoria editarCategoria(@RequestBody CategoriaDto dto, @PathVariable String id){
        dto.setId(id);
        return categoriaBusiness.modificarCategoria(dto);
    }

    @DeleteMapping(value = "/categoria/{id}")
    public String eliminarCategoria(@PathVariable String id){
        CategoriaDto dto = new CategoriaDto(id);
        return categoriaBusiness.bajaCategoria(dto) ? "La categoria fue eliminada con exito" : "La categoria no existe";
    }
}
