package ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao.impl;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Categoria;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao.CategoriaDao;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao.ProductoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryProductoDao implements ProductoDao {

    // Aca se encuentran todos los productos sin importar su categoria.
    private final ArrayList<Producto> todosLosProductos = new ArrayList<>();

    public ArrayList<Producto> productosDeCategoria(Categoria categoria){
        return categoria.getListaProductos();
    }

    @Autowired
    CategoriaDao categoriaDao;

    @Override
    public ArrayList<Producto> getListaDeProductos() {
        return todosLosProductos;
    }

    @Override
    public Producto guardar(Producto producto) {

        Categoria catIngresada = producto.getCategoria();
        Categoria catEncontrada = categoriaDao.buscarCategoria(catIngresada.getId());

        //Si no existe la categoria, la creo y despues le agrego el producto
        if (catEncontrada == null){
            categoriaDao.guardar(catIngresada);
            catIngresada.agregarProducto(producto);
        }
        else{
            catIngresada.agregarProducto(producto);
        }

        todosLosProductos.add(producto);

        System.out.println("Se guardo el producto correctamente");
        return producto;
    }

    @Override
    public Producto editar(Producto producto) {

        if (producto != null) {
            Categoria cat = producto.getCategoria();

            if (cat != null){
                int index = productosDeCategoria(cat).indexOf(producto);
                productosDeCategoria(cat).add(index, producto);

                int index2 = todosLosProductos.indexOf(producto);
                todosLosProductos.add(index2, producto);
                System.out.println("Se editó correctamente");
            }
        }
        return producto;
    }

    @Override
    public boolean eliminar(Producto producto) {
        if (producto != null){
            productosDeCategoria(producto.getCategoria()).remove(producto);
            todosLosProductos.remove(producto);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Producto buscarProductoById(String id) {

        Producto productoEncontrada = null;

        if (!todosLosProductos.isEmpty()){
            for (Producto producto : todosLosProductos){
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

    @Override
    public List<Producto> buscarProductosByAtributos(String tipo, String marca, String categoria) {
        return getListaDeProductos().stream()
                .filter(producto -> producto.getTipo().equalsIgnoreCase(tipo))
                .filter(producto -> producto.getMarca().equalsIgnoreCase(marca))
                .filter(producto -> producto.getCategoria().getNombre().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }
}
