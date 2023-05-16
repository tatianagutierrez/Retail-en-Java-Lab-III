package ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao.impl;

import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Categoria;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.model.Producto;
import ar.edu.utn.frbb.tup.RetailenJavaLabIII.persistence.dao.CategoriaDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryCategoriaDao implements CategoriaDao {

    private ArrayList<Categoria> categorias = new ArrayList<>();

    private ArrayList<Producto> getProductos(Categoria categoria){
        return categoria.getListaProductos();
    }

    @Override
    public Categoria guardar(Categoria categoria) {

        categorias.add(categoria);
        System.out.println("Se guardo correctamente");
        return categoria;

    }

    @Override
    public Categoria editar(Categoria categoria) {
        if (categoria != null) {
            int index = categorias.indexOf(categoria);
            categorias.add(index, categoria);
            System.out.println("Se editó correctamente");
        }

        return categoria;
    }

    @Override
    public boolean eliminar(Categoria categoria) {

        if (categoria != null){
            categorias.remove(categoria);
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public Categoria buscarCategoria(String id) {

        Categoria categoriaEncontrada = null;

        if (!categorias.isEmpty()){
            for (Categoria categoria : categorias){
                if (categoria.getId().equals(id)){
                    categoriaEncontrada = categoria;
                    break;
                }
            }
        }
        else {
            System.out.println("La lista de categorias esta vacia");
        }

        return categoriaEncontrada;
    }

    @Override
    public List<Producto> getProductosPorPrecioAsc(Categoria c){
        return getProductos(c).stream().sorted(Comparator.comparingDouble(Producto::getPrecio))
                .collect(Collectors.toList());
    }

    @Override
    public List<Producto> getProductosPorPrecioDesc(Categoria c){
        return getProductos(c).stream().sorted(Comparator.comparingDouble(Producto::getPrecio)
                        .reversed())
                        .collect(Collectors.toList());
    }

    @Override
    public List<Producto> getProductosByMarca(Categoria c, String marca) {
        return getProductos(c).stream().filter(producto -> producto.getMarca().equalsIgnoreCase(marca))
                             .collect(Collectors.toList());
    }

    @Override
    public List<Producto> getProductosFiltradosByPrecios(Categoria c, Double precioMin, Double precioMax) {
        return getProductos(c).stream()
                             .filter(producto -> producto.getPrecio() >= precioMin && producto.getPrecio() <= precioMax)
                             .collect(Collectors.toList());
    }
}
