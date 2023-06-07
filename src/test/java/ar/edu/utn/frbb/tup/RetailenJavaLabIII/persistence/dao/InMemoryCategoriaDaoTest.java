package ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.BaseTest;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Categoria;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class InMemoryCategoriaDaoTest extends BaseTest {


    @Test
    public void guardarCategoria(){
        Categoria categoriaGuardada = daoCategoria.guardar(categoria1);
        System.out.println(categoriaGuardada);
        assertNotNull(categoriaGuardada);
        assertEquals(categoria1, categoriaGuardada);
    }


    @Test
    public void buscarCategoria(){
        daoCategoria.guardar(categoria1);

        Categoria categoriaEncontrada = daoCategoria.buscarCategoria(categoria1.getId());

        assertNotNull(categoriaEncontrada);
        assertEquals(categoria1, categoriaEncontrada);
    }

    @Test
    public void editarCategoria(){
        //Guardo
        System.out.println("Categoria inicial: " + categoria1);
        daoCategoria.guardar(categoria1);

        //Edito
        categoria1.setNombre("Informatica");
        categoria1.setDescripcion("Categoria de productos de informatica");
        daoCategoria.editar(categoria1);
        System.out.println("Categoria editada: " + categoria1);

        //Verifico que se edito
        Categoria categoriaEncontrada = daoCategoria.buscarCategoria(categoria1.getId());
        assertEquals("Informatica", categoriaEncontrada.getNombre());
        assertEquals("Categoria de productos de informatica", categoriaEncontrada.getDescripcion());

    }

    @Test
    public void eliminarCategoria(){
        daoCategoria.guardar(categoria1);
        daoCategoria.guardar(categoria2);

        boolean categoriaEliminada = daoCategoria.eliminar(categoria2);
        Categoria categoriaEncontrada = daoCategoria.buscarCategoria(categoria2.getId());

        assertTrue(categoriaEliminada);
        assertNull(categoriaEncontrada);
    }

    @Test
    public void getProductosPorPrecioAsc() {
        categoria1.agregarProducto(producto1);
        categoria1.agregarProducto(producto2);
        categoria1.agregarProducto(producto3);
        daoCategoria.guardar(categoria1);

        List<Producto> lista = daoCategoria.getProductosPorPrecioAsc(categoria1);

        assertNotNull(lista);
        assertFalse(lista.isEmpty());
        assertTrue(lista.size() > 1);

        Producto previo = null;
        for (Producto actual : lista) {
            if (previo != null) {
                assertTrue(actual.getPrecio() >= previo.getPrecio());
            }
            previo = actual;
        }

        System.out.println(lista);
    }

    @Test
    public void getProductosFiltradosByPrecios(){
        categoria1.agregarProducto(producto1);
        categoria1.agregarProducto(producto2);
        categoria1.agregarProducto(producto3);
        daoCategoria.guardar(categoria1);

        List<Producto> lista = daoCategoria.getProductosFiltradosByPrecios(categoria1, 50000.00, 100000.00);

        assertNotNull(lista);
        assertFalse(lista.isEmpty());
        assertTrue(lista.size() > 1);

        assertTrue(lista.stream().allMatch(p -> p.getPrecio() >= 50000.00 && p.getPrecio() <= 100000.00));

        System.out.println(lista);
    }

    @Test
    public void getProductosByMarca(){
        categoria1.agregarProducto(producto1);
        categoria1.agregarProducto(producto2);
        categoria1.agregarProducto(producto3);
        daoCategoria.guardar(categoria1);

        List<Producto> lista = daoCategoria.getProductosByMarca(categoria1, "Samsung");

        assertNotNull(lista);
        assertFalse(lista.isEmpty());
        assertTrue(lista.size() > 1);

        assertTrue(lista.stream().allMatch(p -> p.getMarca().equalsIgnoreCase("Samsung")));

        System.out.println(lista);
    }
}
