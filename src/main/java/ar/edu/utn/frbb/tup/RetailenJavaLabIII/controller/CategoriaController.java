package ar.edu.utn.frbb.tup.RetailenJavaLabIII.controller;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto.CategoriaDto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Categoria;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {

    @Autowired
    CategoriaBusiness categoriaBusiness;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/categoria", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Categoria crearCategoria(@RequestBody CategoriaDto dto){
        return categoriaBusiness.altaCategoria(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/categoria/{id}")
    public Categoria editarCategoria(@RequestBody CategoriaDto dto, @PathVariable String id){
        dto.setId(id);
        return categoriaBusiness.modificarCategoria(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/categoria/{id}")
    public String eliminarCategoria(@PathVariable String id){
        CategoriaDto dto = new CategoriaDto(id);
        return categoriaBusiness.bajaCategoria(dto) ? "La categoria fue eliminada con exito" : "La categoria no existe";
    }

    @GetMapping(value = "/categoria/{id}")
    public ResponseEntity<?> obtenerProductos(@PathVariable String id,
                                              @RequestParam(value = "marca", required = false) String marca,
                                              @RequestParam(value = "order_price", required = false) String orden,
                                              @RequestParam(value = "precio_min", required = false) Double min,
                                              @RequestParam(value = "precio_max", required = false) Double max){

        CategoriaDto dto = new CategoriaDto(id);
        List<Producto> productos;

        if (marca != null){
            productos = categoriaBusiness.getProductosByMarca(dto, marca);
            System.out.println(productos);
            System.out.println("entro a marca");
            ResponseEntity.ok(productos);
        }
        else if (orden != null){

            if (orden.equalsIgnoreCase("asc")) {
                productos = categoriaBusiness.getProductosOrdenadosByPrecioAsc(dto);
                return ResponseEntity.ok(productos);

            } else if (orden.equalsIgnoreCase("desc")) {
                productos = categoriaBusiness.getProductosOrdenadosByPrecioDesc(dto);
                return ResponseEntity.ok(productos);
            }

        }
        else if (min != null && max != null){
            productos = categoriaBusiness.getProductosFiltradosByPrecios(dto, min, max);
            return ResponseEntity.ok(productos);
        }

        return ResponseEntity.ok(categoriaBusiness.consultarCategoriaById(id));
    }
}


