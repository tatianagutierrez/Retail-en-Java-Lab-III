package ar.edu.utn.frbb.tup.RetailenJavaLabIII.dto;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Categoria;

import java.util.Map;

public class ProductoDto {

    private final String id;
    private final String nombre;
    private final String descripcion;
    private final Categoria categoria;
    private final String marca;
    private final double precioLista;
    private final String tipo;
    private final Map<String, String> especificaciones;

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
