package ar.edu.utn.frbb.tup.RetailenJavaLabIII.business;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.business.impl.ProductoBusinessImplementation;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto.CategoriaDto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto.ProductoDto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Categoria;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao.ProductoDao;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class ProductoBusinessTest {

    @Mock
    private ProductoDao dao;

    @InjectMocks
    private ProductoBusinessImplementation impl;

    @Test
    public void altaProducto(){
        CategoriaDto catDto = new CategoriaDto("ATV", "Aca van los televisores y audios");
        Categoria cat = new Categoria("1234", catDto.getNombre(), catDto.getDescripcion());

        Map<String, String> especificaciones = new HashMap<>();
        especificaciones.put("Pulgadas", "52");
        especificaciones.put("Alto", "62.78");
        especificaciones.put("Ancho", "96.39");
        especificaciones.put("Peso", "8.3");


        ProductoDto dto = new ProductoDto("Tv samsung", "Una descripcion..", cat.getId(), "samsung", 1800, "televisor", especificaciones);

        Mockito.when(dao.guardar(Mockito.any())).thenReturn(new Producto());
        Mockito.when(dao.buscarProductoById(dto.getId())).thenReturn(new Producto());

        Producto producto = impl.altaProducto(dto);

        System.out.println(producto);
    }
}
