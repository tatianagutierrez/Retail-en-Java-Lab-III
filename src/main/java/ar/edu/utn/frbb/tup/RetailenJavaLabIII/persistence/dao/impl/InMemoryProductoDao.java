package ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao.impl;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Categoria;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao.CategoriaDao;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao.ProductoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Repository
public class InMemoryProductoDao implements ProductoDao {

    // Aca se encuentran todos los productos sin importar su categoria.
    private final ArrayList<Producto> todosLosProductos = new ArrayList<>();

    private ArrayList<Producto> getProductosDeCategoria(Categoria categoria){
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

        try{
            Categoria categoria = categoriaDao.buscarCategoria(producto.getCategoriaId());

            categoria.agregarProducto(producto);
            todosLosProductos.add(producto);
            System.out.println("Se guardo el producto correctamente");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return producto;

    }

    @Override
    public Producto editar(Producto producto) {
        try {
            Categoria categoria = categoriaDao.buscarCategoria(producto.getCategoriaId());

            int index = getProductosDeCategoria(categoria).indexOf(producto);
            getProductosDeCategoria(categoria).add(index, producto);

            int index2 = todosLosProductos.indexOf(producto);
            todosLosProductos.add(index2, producto);

            System.out.println("Se editó correctamente");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return producto;
    }

    @Override
    public boolean eliminar(Producto producto) {

        try {
            Categoria categoria = categoriaDao.buscarCategoria(producto.getCategoriaId());
            getProductosDeCategoria(categoria).remove(producto);
            todosLosProductos.remove(producto);
            return true;
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public Producto buscarProductoById(String id) throws NoSuchElementException{

        Producto productoEncontrada = null;

        if (!todosLosProductos.isEmpty()){
            for (Producto producto : todosLosProductos){
                if (producto.getId().equals(id)){
                    productoEncontrada = producto;
                    break;
                }
            }
        }


        if (productoEncontrada == null) {
            throw new NoSuchElementException("El producto no existe");
        }

        return productoEncontrada;
    }

    @Override
    public List<Producto> buscarProductosByAtributos(String tipo, String marca, String categoriaId) {
        return getListaDeProductos().stream()
                .filter(producto -> producto.getTipo().equalsIgnoreCase(tipo))
                .filter(producto -> producto.getMarca().equalsIgnoreCase(marca))
                .filter(producto -> producto.getCategoriaId().equals(categoriaId))
                .collect(Collectors.toList());
    }
}
