package ar.edu.utn.frbb.tup.RetailenJavaLabIII.model;

import java.util.Map;

public class Producto {
    private String id;
    private String nombre;
    private String descripcion;
    private String categoriaId;
    private String marca;
    private double precio;
    private String tipo;
    private Map<String, String> especificaciones;

    public Producto(){}

    public Producto(String id, String nombre, String descripcion, String categoriaId, String marca, double precio, String tipo, Map<String, String> especificaciones) {
        this.id = id;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(String categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Map<String, String> getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(Map<String, String> especificaciones) {
        this.especificaciones = especificaciones;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", categoria=" + categoriaId +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                ", tipo='" + tipo + '\'' +
                ", especificaciones=" + especificaciones +
                '}';
    }
}
