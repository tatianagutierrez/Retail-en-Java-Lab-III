package ar.edu.utn.frbb.tup.RetailenJavaLabIII.controller;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto.CategoriaDto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Categoria;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoriaController {

    @Autowired
    CategoriaBusiness categoriaBusiness;

    @Operation(summary = "Crear categoría")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/categoria", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Categoria crearCategoria(@RequestBody CategoriaDto dto){
        return categoriaBusiness.altaCategoria(dto);
    }

    @Operation(summary = "Editar categoría")
    @PutMapping(value = "/categoria/{id}")
    public ResponseEntity<Categoria> editarCategoria(@RequestBody CategoriaDto dto, @PathVariable String id){
        dto.setId(id);

        return Optional.ofNullable(categoriaBusiness.modificarCategoria(dto))
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Eliminar categoría")
    @DeleteMapping(value = "/categoria/{id}")
    public ResponseEntity<?> eliminarCategoria(@PathVariable String id){
        CategoriaDto dto = new CategoriaDto(id);
        boolean seElimino = categoriaBusiness.bajaCategoria(dto);

        return seElimino ? ResponseEntity.ok("La categoría fue eliminado con éxito") : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Obtener categoría by id", description = "En caso de ingresar los parámetros opcionales se retornaran solo los productos de la categoría indicada.")
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
            return !productos.isEmpty() ? ResponseEntity.ok(productos) : ResponseEntity.notFound().build();
        }
        else if (orden != null){

            if (orden.equalsIgnoreCase("asc")) {
                productos = categoriaBusiness.getProductosOrdenadosByPrecioAsc(dto);
                return !productos.isEmpty() ? ResponseEntity.ok(productos) : ResponseEntity.notFound().build();

            } else if (orden.equalsIgnoreCase("desc")) {
                productos = categoriaBusiness.getProductosOrdenadosByPrecioDesc(dto);
                return !productos.isEmpty() ? ResponseEntity.ok(productos) : ResponseEntity.notFound().build();
            }
            else{
                return ResponseEntity.notFound().build();
            }

        }
        else if (min != null && max != null){
            productos = categoriaBusiness.getProductosFiltradosByPrecios(dto, min, max);
            return !productos.isEmpty() ? ResponseEntity.ok(productos) : ResponseEntity.notFound().build();
        }

        return Optional.ofNullable(categoriaBusiness.consultarCategoriaById(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}


