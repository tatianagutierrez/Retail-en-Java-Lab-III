package ar.edu.utn.frbb.tup.RetailenJavaLabIII.model;

import java.util.ArrayList;

public class Categoria {
    private String id;
    private String nombre;
    private String descripcion;
    private ArrayList<Producto> listaProductos;

    public Categoria(String id, String nombre, String descripcion, ArrayList<Producto> listaProductos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listaProductos = listaProductos;
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

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
