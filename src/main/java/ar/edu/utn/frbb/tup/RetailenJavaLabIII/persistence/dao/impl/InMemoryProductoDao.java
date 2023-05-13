package ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao.impl;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao.ProductoDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public class InMemoryProductoDao implements ProductoDao {

    private ArrayList<Producto> productos = new ArrayList<>();

    @Override
    public Producto guardar(Producto producto) {
        // Genera una cadena unica de 36 caracteres
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        producto.setId(id);

        productos.add(producto);
        System.out.println("Se guardo correctamente");
        return producto;
    }

    @Override
    public Producto editar(Producto producto) {

        if (producto != null) {
            int index = productos.indexOf(producto);
            productos.add(index, producto);
            System.out.println("Se editó correctamente");
        }

        return producto;
    }

    @Override
    public boolean eliminar(Producto producto) {
        if (producto != null){
            productos.remove(producto);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Producto buscarProductoById(String id) {

        Producto productoEncontrada = null;

        if (!productos.isEmpty()){
            for (Producto producto : productos){
                if (producto.getId().equals(id)){
                    productoEncontrada = producto;
                    break;
                }
            }
        }
        else {
            System.out.println("El producto no existe");
        }

        return productoEncontrada;
    }
}
