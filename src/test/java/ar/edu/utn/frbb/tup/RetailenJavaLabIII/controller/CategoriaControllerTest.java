package ar.edu.utn.frbb.tup.RetailenJavaLabIII.controller;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.BaseTest;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto.CategoriaDto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao.CategoriaDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CategoriaControllerTest extends BaseTest {

    private ObjectMapper mapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CategoriaDao categoriaDao;

    @BeforeEach
    void configurar() {
        mapper = new ObjectMapper();
    }

    @Test
    public void crearCategoria() throws Exception {
        CategoriaDto dto = new CategoriaDto("Electrodomesticos", "Objetos para el hogar");

        mockMvc.perform(MockMvcRequestBuilders.post("/categoria")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto))
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.nombre").value(dto.getNombre()))
                        .andExpect(jsonPath("$.descripcion").value(dto.getDescripcion()))
                        .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void eliminarCategoriaOk() throws Exception {
        categoriaDao.guardar(categoria1);

        mockMvc.perform(MockMvcRequestBuilders.delete("/categoria/{id}", categoria1.getId()))
                        .andExpect(status().isOk())
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(content().string("La categoría fue eliminado con éxito"));
    }

    @Test
    public void eliminarCategoriaNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/categoria/{id}", categoria1.getId()))
                .andExpect(status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
    }

}