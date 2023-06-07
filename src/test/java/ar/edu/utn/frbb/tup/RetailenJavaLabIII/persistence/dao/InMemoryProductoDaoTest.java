package ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.BaseTest;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class InMemoryProductoDaoTest extends BaseTest {

    @Autowired
    ProductoDao daoProducto;

    @Autowired
    CategoriaDao daoCategoria;

    @Test
    public void guardarProducto(){
        daoCategoria.guardar(categoria1);
        daoProducto.guardar(producto1);

        assertNotNull(daoProducto.buscarProductoById(producto1.getId()));
        assertFalse(categoria1.getListaProductos().isEmpty());
        assertTrue(categoria1.getListaProductos().contains(producto1));

        assertFalse(daoProducto.getListaDeProductos().isEmpty());
        assertTrue(daoProducto.getListaDeProductos().contains(producto1));
    }

    @Test
    public void buscarProductoById(){
        daoCategoria.guardar(categoria1);
        daoProducto.guardar(producto1);
        Producto productoEncontrado = daoProducto.buscarProductoById(producto1.getId());

        assertNotNull(productoEncontrado);
        assertThat(producto1).isEqualTo(productoEncontrado);
    }

    @Test
    public void buscarProductosByAtributos() {
        daoCategoria.guardar(categoria1);
        daoProducto.guardar(producto1);

        String tipo = producto1.getTipo();
        String marca = producto1.getMarca();
        String categoriaId = producto1.getCategoriaId();

        List<Producto> productosEncontrados = daoProducto.buscarProductosByAtributos(tipo, marca, categoriaId);

        assertFalse(productosEncontrados.isEmpty());
        assertEquals(productosEncontrados.get(0).getTipo(), producto1.getTipo());
        assertEquals(productosEncontrados.get(0).getMarca(), producto1.getMarca());
        assertEquals(productosEncontrados.get(0).getCategoriaId(), producto1.getCategoriaId());

    }

    @Test
    public void editarProducto(){
        daoCategoria.guardar(categoria1);
        daoProducto.guardar(producto1);

        System.out.println("Producto incial: " + producto1);

        producto1.setNombre("Smart Tv LG");
        producto1.setMarca("LG");
        producto1.setPrecio(100000);

        daoProducto.editar(producto1);
        System.out.println("Producto editado: " + producto1);

        assertTrue(categoria1.getListaProductos().contains(producto1));
        assertTrue(daoProducto.getListaDeProductos().contains(producto1));

    }

    @Test
    public void eliminarProducto() {
        daoCategoria.guardar(categoria1);
        daoProducto.guardar(producto1);

        boolean productoEliminado = daoProducto.eliminar(producto1);

        assertTrue(productoEliminado);

    }

}
