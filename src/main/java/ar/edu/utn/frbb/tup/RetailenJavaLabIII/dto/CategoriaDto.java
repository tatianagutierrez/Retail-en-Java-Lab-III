package ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto;

public class CategoriaDto {
    // Se suele usar la interfaz Serializable

    private final String nombre;
    private final String descripcion;

    public CategoriaDto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
