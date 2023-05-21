package ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.BaseTest;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class InMemoryProductoDaoTest extends BaseTest {

    @Autowired
    ProductoDao dao;

    @Test
    public void guardarProducto(){
        dao.guardar(producto1);

        Assertions.assertNotNull(dao.buscarProductoById(producto1.getId()));
        Assertions.assertFalse(categoria1.getListaProductos().isEmpty());
        Assertions.assertTrue(categoria1.getListaProductos().contains(producto1));

        Assertions.assertFalse(dao.getListaDeProductos().isEmpty());
        Assertions.assertTrue(dao.getListaDeProductos().contains(producto1));
    }

    @Test
    public void buscarProductoById(){
        dao.guardar(producto1);
        Producto productoEncontrado = dao.buscarProductoById(producto1.getId());

        Assertions.assertNotNull(productoEncontrado);
        Assertions.assertEquals(producto1, productoEncontrado);
    }

    @Test
    public void buscarProductosByAtributos() {
        dao.guardar(producto1);
        String tipo = producto1.getTipo();
        String marca = producto1.getMarca();
        String categoriaNombre = producto1.getCategoria().getNombre();

        List<Producto> productosEncontrados = dao.buscarProductosByAtributos(tipo, marca, categoriaNombre);
        System.out.println(productosEncontrados);

        Assertions.assertFalse(productosEncontrados.isEmpty());
        Assertions.assertEquals(productosEncontrados.get(0).getMarca(), producto1.getMarca());
    }

    @Test
    public void editarProducto(){
        dao.guardar(producto1);

        System.out.println("Producto incial: " + producto1);

        producto1.setNombre("Smart Tv LG");
        producto1.setMarca("LG");
        producto1.setPrecio(100000);

        dao.editar(producto1);
        System.out.println("Producto editado: " + producto1);

        Assertions.assertTrue(categoria1.getListaProductos().contains(producto1));
        Assertions.assertTrue(dao.getListaDeProductos().contains(producto1));

    }

    @Test
    public void eliminarProducto() {
        dao.guardar(producto1);

        boolean productoEliminado = dao.eliminar(producto1);
        Producto productoEncontrado = dao.buscarProductoById(producto1.getId());

        Assertions.assertTrue(productoEliminado);
        Assertions.assertNull(productoEncontrado);
    }

}
