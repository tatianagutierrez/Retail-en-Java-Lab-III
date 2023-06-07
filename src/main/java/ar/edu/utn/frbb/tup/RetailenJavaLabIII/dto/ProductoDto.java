package ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto;

import java.io.Serializable;
import java.util.Map;

public class ProductoDto implements Serializable {

    private String id;
    private String nombre;
    private String descripcion;
    private String categoriaId;
    private String marca;
    private double precio;
    private String tipo;
    private Map<String, String> especificaciones;

    public ProductoDto(){}

    public ProductoDto(String id){
        this.id = id;
    }

    public ProductoDto(String nombre, String descripcion, String categoriaId, String marca, double precio, String tipo, Map<String, String> especificaciones) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoriaId = categoriaId;
        this.marca = marca;
        this.precio = precio;
        this.tipo = tipo;
        this.especificaciones = especificaciones;
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

    public String getCategoriaId() {
        return categoriaId;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }

    public Map<String, String> getEspecificaciones() {
        return especificaciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCategoriaId(String categoriaId) {
        this.categoriaId = categoriaId;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEspecificaciones(Map<String, String> especificaciones) {
        this.especificaciones = especificaciones;
    }
}
