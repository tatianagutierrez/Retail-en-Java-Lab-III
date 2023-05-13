package ar.edu.utn.frbb.tup.RetailenJavaLabIII.controller;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.business.ProductoBusiness;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto.ProductoDto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductoController {

    @Autowired
    ProductoBusiness productoBusiness;

    @PostMapping(value = "/producto")
    public Producto crearProducto(@RequestBody ProductoDto dto){
        return productoBusiness.altaProducto(dto);
    }

    @PutMapping(value = "/producto/{id}")
    public Producto editarProducto(@RequestBody ProductoDto dto, @PathVariable String id){
        dto.setId(id);
        return productoBusiness.modificacionProducto(dto);
    }

    @DeleteMapping(value = "/producto/{id}")
    public String eliminarProducto(@PathVariable String id){
        ProductoDto dto = new ProductoDto(id);
        return productoBusiness.bajaProducto(dto) ? "El producto fue eliminada con exito" : "El producto no existe";
    }
}
