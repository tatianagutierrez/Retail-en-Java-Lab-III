package ar.edu.utn.frbb.tup.RetailenJavaLabIII.controller;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.BaseTest;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto.ProductoDto;
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
public class ProductoControllerTest extends BaseTest {

    private ObjectMapper mapper;
    ProductoDto dto;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CategoriaDao categoriaDao;

    @BeforeEach
    void configurar() {
        mapper = new ObjectMapper();
        dto = new ProductoDto("Camiseta Argentina", "Camiseta Argentina 2022 original", categoria1.getId(), "Adidas", 25000, "Camisetas", especificaciones);
    }

    @Test
    public void crearProductoOk() throws Exception {
        categoriaDao.guardar(categoria1);

        mockMvc.perform(MockMvcRequestBuilders.post("/producto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(dto))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value(dto.getNombre()))
                .andExpect(jsonPath("$.descripcion").value(dto.getDescripcion()))
                .andExpect(jsonPath("$.categoriaId").value(dto.getCategoriaId()))
                .andExpect(jsonPath("$.marca").value(dto.getMarca()))
                .andExpect(jsonPath("$.precio").value(dto.getPrecio()))
                .andExpect(jsonPath("$.tipo").value(dto.getTipo()))
                .andExpect(jsonPath("$.tipo").isNotEmpty())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void crearProductoNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/producto")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto))
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isNotFound());
    }
}