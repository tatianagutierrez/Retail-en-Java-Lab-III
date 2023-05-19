package ar.edu.utn.frbb.tup.RetailenJavaLabIII.controller;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto.CategoriaDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
//@WebMvcTest(CategoriaController.class)
@AutoConfigureMockMvc
//@TestInstance(TestInstance.Lifecycle.PER_CLASS) no se bien para que sirve
public class CategoriaControllerTest {

    private ObjectMapper mapper;

    @Autowired
    private MockMvc mockMvc;

    /*
    @MockBean
    CategoriaBusiness categoriaBusiness;
    */

    @BeforeEach
    void configurar() {
        mapper = new ObjectMapper();
    }

    @Test
    public void crearCategoriaTest() throws Exception {
        CategoriaDto dto = new CategoriaDto("Electrodomesticos", "Objetos para el hogar");

        mockMvc.perform(MockMvcRequestBuilders.post("/categoria")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto))
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.nombre").value("Electrodomesticos"))
                        .andExpect(jsonPath("$.descripcion").value("Objetos para el hogar"))
                        .andDo(MockMvcResultHandlers.print());




        //Mockito.verify(categoriaBusiness, Mockito.times(1)).altaCategoria(dto);

    }

}