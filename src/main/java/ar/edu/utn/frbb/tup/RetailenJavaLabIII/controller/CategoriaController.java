package ar.edu.utn.frbb.tup.RetailenJavaLabIII.controller;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto.CategoriaDto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Categoria;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/categoria/{id}?marca={marca}")
    public List<Producto> getProductosByMarca(@PathVariable String id, @PathVariable String marca){
        CategoriaDto dto = new CategoriaDto(id);
        return categoriaBusiness.getProductosByMarca(dto, marca);
    }

    @GetMapping(value = "/categoria/{id}?order_price={orden}")
    public List<Producto> getProductosOrdenadosByPrecio(@PathVariable String id, @PathVariable String orden) {
        CategoriaDto dto = new CategoriaDto(id);
        List<Producto> productos = null;

        if (orden != null) {
            if (orden.equalsIgnoreCase("asc")) {
                productos = categoriaBusiness.getProductosOrdenadosByPrecioAsc(dto);
            } else if (orden.equalsIgnoreCase("desc")) {
                productos = categoriaBusiness.getProductosOrdenadosByPrecioDesc(dto);
            }
        }

        return productos;
    }

    @GetMapping (value = "/categoria/{id}?precio_min={min}&precio_max={max}")
    public List<Producto> getProductosFiltradosByPrecios(@PathVariable String id, @PathVariable Double min, @PathVariable Double max) {
        CategoriaDto dto = new CategoriaDto(id);
        return categoriaBusiness.getProductosFiltradosByPrecios(dto, min, max);
    }

}


