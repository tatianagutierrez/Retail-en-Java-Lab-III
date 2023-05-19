package ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Categoria;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao.impl.InMemoryCategoriaDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InMemoryCategoriaDaoTest {

    CategoriaDao dao;

    @BeforeEach
    public void configuracion(){
        dao = new InMemoryCategoriaDao();
    }

    @Test
    public void guardarCategoria(){

        Categoria categoria = new Categoria("A-123", "Audio y television", "Equipos de audio y television para el hogar");

        Categoria categoriaGuardada = dao.guardar(categoria);
        System.out.println(categoriaGuardada);
        Assertions.assertNotNull(categoriaGuardada);
        Assertions.assertEquals(categoria, categoriaGuardada);
    }


    @Test
    public void buscarCategoria(){
        CategoriaDao dao = new InMemoryCategoriaDao();

        Categoria categoria = new Categoria("B-123", "Electrónica", "Categoría de productos electrónicos");
        dao.guardar(categoria);

        Categoria categoriaEncontrada = dao.buscarCategoria(categoria.getId());

        Assertions.assertNotNull(categoriaEncontrada);
        Assertions.assertEquals(categoria, categoriaEncontrada);
    }

    @Test
    public void editarCategoriaTest(){
        //Guardo
        Categoria categoria = new Categoria("C-123", "Hogar y muebles", "Categoría de productos del hogar");
        System.out.println("Categoria inicial: " + categoria);
        dao.guardar(categoria);

        //Edito
        categoria.setNombre("Informatica");
        categoria.setDescripcion("Categoria de productos de informatica");
        dao.editar(categoria);
        System.out.println("Categoria editada: " + categoria);

        //Verifico que se edito
        Categoria categoriaEncontrada = dao.buscarCategoria(categoria.getId());
        Assertions.assertEquals("Informatica", categoriaEncontrada.getNombre());
        Assertions.assertEquals("Categoria de productos de informatica", categoriaEncontrada.getDescripcion());

    }

    @Test
    public void eliminarCategoria(){
        Categoria categoria1 = new Categoria("A-123", "Audio y television", "Equipos de audio y television para el hogar");
        Categoria categoria2 = new Categoria("D-123", "Salud y Aire libre ", "Categoría de productos deportivos");

        dao.guardar(categoria1);
        dao.guardar(categoria2);

        System.out.println(dao.eliminar(categoria2));

        Categoria categoriaEncontrada = dao.buscarCategoria(categoria2.getId());

        Assertions.assertNull(categoriaEncontrada);
    }
}
