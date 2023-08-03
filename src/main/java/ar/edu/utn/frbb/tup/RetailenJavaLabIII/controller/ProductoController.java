package ar.edu.utn.frbb.tup.RetailenJavaLabIII.controller;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.business.ProductoBusiness;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto.ProductoDto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductoController {

    @Autowired
    ProductoBusiness productoBusiness;

    @Operation(summary = "Crear producto")
    @PostMapping(value = "/producto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> crearProducto(@RequestBody ProductoDto dto){
        return Optional.ofNullable(productoBusiness.altaProducto(dto))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Obtener producto by id")
    @GetMapping(value = "/producto/{id}")
    public ResponseEntity<Producto> obtenerProductoById(@PathVariable String id){
        return Optional.ofNullable(productoBusiness.consultarProductoById(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Editar producto")
    @PutMapping(value = "/producto/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> editarProducto(@RequestBody ProductoDto dto, @PathVariable String id){
        dto.setId(id);

        return Optional.ofNullable(productoBusiness.modificacionProducto(dto))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @Operation(summary = "Eliminar producto")
    @DeleteMapping(value = "/producto/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable String id){
        ProductoDto dto = new ProductoDto(id);
        boolean seElimino = productoBusiness.bajaProducto(dto);

        return seElimino ? ResponseEntity.ok("El producto fue eliminado con éxito") : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Obtener productos by tipo, marca y categoría")
    @GetMapping(value = "/producto")
    public ResponseEntity<?> getProductosByAtributos(@RequestParam("tipo_producto") String tipo, @RequestParam("marca") String marca, @RequestParam("categoria_id") String categoriaId) {
        List<Producto> productos = productoBusiness.consultarProductosByAtributos(tipo, marca, categoriaId);

        return productos.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(productos);
    }
}
