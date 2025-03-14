package com.example.demo;

import java.util.List;

public interface IProductoService {

    List<Producto> getProductos();

    Producto nuevoProducto(Producto producto);

    Producto buscarProducto(Long id);

    int borrarProducto(Long id);
}
