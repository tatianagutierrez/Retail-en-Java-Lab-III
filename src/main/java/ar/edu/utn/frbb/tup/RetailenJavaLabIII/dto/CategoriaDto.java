package ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto;

import java.io.Serializable;

public class CategoriaDto implements Serializable {
    private final String id;
    private final String nombre;
    private final String descripcion;

    public CategoriaDto(String id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
