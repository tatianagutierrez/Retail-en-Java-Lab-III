package ar.edu.utn.frbb.tup.RetailenJavaLabIII.business;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.business.impl.CategoriaBusinessImplementation;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto.CategoriaDto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Categoria;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao.CategoriaDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoriaBusinessTest {

    @Mock
    private CategoriaDao dao;

    @InjectMocks
    private CategoriaBusinessImplementation impl;

    @Test
    public void altaCategoria() {
        CategoriaDto dto = new CategoriaDto("Tv y Audio", "Aca hay productos como televisores, auriculares y parlantes");

        Categoria categoria = impl.altaCategoria(dto);
        System.out.println(categoria);

        Mockito.when(dao.buscarCategoria(categoria.getId())).thenReturn(categoria);

        Categoria categoriaEncontrada = dao.buscarCategoria(categoria.getId());

        Assertions.assertNotNull(categoriaEncontrada);
        Assertions.assertEquals(categoria, categoriaEncontrada);
    }
}
