package ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Categoria;

import java.util.Map;

public class ProductoDto {

    private String id;
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    private String marca;
    private double precioLista;
    private String tipo;
    private Map<String, String> especificaciones;

    public ProductoDto(String id){
        this.id = id;
    }

    public ProductoDto(String id, String nombre, String descripcion, Categoria categoria, String marca, double precioLista, String tipo, Map<String, String> especificaciones) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.marca = marca;
        this.precioLista = precioLista;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecioLista() {
        return precioLista;
    }

    public String getTipo() {
        return tipo;
    }

    public Map<String, String> getEspecificaciones() {
        return especificaciones;
    }
}
