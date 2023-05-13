package ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto;

import java.io.Serializable;

public class CategoriaDto implements Serializable {
    private String id;
    private String nombre;
    private String descripcion;

    public CategoriaDto(String id){
        this.id = id;
    }

    public CategoriaDto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
