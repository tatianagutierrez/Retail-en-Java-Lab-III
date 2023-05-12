package ar.edu.utn.frbb.tup.RetailenJavaLabIII.model;

import java.util.Map;

public class Producto {
    private String id;
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    private String marca;
    private double precioLista;
    private String tipo; //no se a que se refiere, es lo mismo que categoria ?
    private Map<String, String> especificaciones;

    public Producto(String id, String nombre, String descripcion, Categoria categoria, String marca, double precioLista, String tipo, Map<String, String> especificaciones) {
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecioLista() {
        return precioLista;
    }

    public void setPrecioLista(double precioLista) {
        this.precioLista = precioLista;
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
}
