package ar.edu.utn.frbb.tup.RetailenJavaLabIII.controller;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.business.ProductoBusiness;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto.ProductoDto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    ProductoBusiness productoBusiness;

    @PostMapping(value = "/producto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Producto crearProducto(@RequestBody ProductoDto dto){
        return productoBusiness.altaProducto(dto);
    }

    @GetMapping(value = "/producto/{id}")
    public Producto obtenerProductoById(@PathVariable String id){
        return productoBusiness.consultarProductoById(id);
    }

    @PutMapping(value = "/producto/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Producto editarProducto(@RequestBody ProductoDto dto, @PathVariable String id){
        dto.setId(id);
        return productoBusiness.modificacionProducto(dto);
    }

    @DeleteMapping(value = "/producto/{id}")
    public String eliminarProducto(@PathVariable String id){
        ProductoDto dto = new ProductoDto(id);
        return productoBusiness.bajaProducto(dto) ? "El producto fue eliminada con exito" : "El producto no existe";
    }

    @GetMapping(value = "/producto")
    public List<Producto> getProductosByAtributos(@RequestParam("tipo_producto") String tipo, @RequestParam("marca") String marca, @RequestParam("categoria_id") String categoriaId) {
        return productoBusiness.consultarProductosByAtributos(tipo, marca, categoriaId);
    }
}
