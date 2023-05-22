package ar.edu.utn.frbb.tup.RetailenJavaLabIII;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Categoria;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao.CategoriaDao;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao.impl.InMemoryCategoriaDao;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseTest {

    protected CategoriaDao daoCategoria;
    protected Categoria categoria1;
    protected Categoria categoria2;
    protected Producto producto1;
    protected Producto producto2;
    protected Producto producto3;
    protected Map<String, String> especificaciones;

    @BeforeEach
    public void inicializar() {
        daoCategoria = new InMemoryCategoriaDao();

        categoria1 = new Categoria("Alfa123", "Audio y television", "Equipos de audio y television para el hogar");
        categoria2 = new Categoria("Beta123", "Salud y Aire libre ", "Categoría de productos deportivos");

        especificaciones = new HashMap<>();
        especificaciones.put("Pulgadas", "52");
        especificaciones.put("Alto", "62.78");
        especificaciones.put("Ancho", "96.39");
        especificaciones.put("Peso", "8.3");

        producto1 = new Producto("A-123", "Smart TV Samsung", "Televisor inteligente de 34 pulgadas", categoria1, "Samsung", 80000, "Tv", especificaciones);

        producto2 = new Producto("B-123", "Auriculares 3.5 mm", "Auriculares manos libres", categoria1, "Noblex", 4500, "Auriculares", especificaciones);

        producto3 = new Producto("B-123", "Smart TV Enova", "Televisor inteligente de 32 pulgadas", categoria1, "Enova", 60500, "Tv", especificaciones);

    }
}
