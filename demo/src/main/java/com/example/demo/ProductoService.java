package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.DemoApplication;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductoService implements IProductoService {

    private final DemoApplication demoApplication;

    @Autowired
    ProductoRepositorio productoRepositorio;

    ProductoService(DemoApplication demoApplication) {
        this.demoApplication = demoApplication;
    }

    @Override
    public List<Producto> getProductos() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto nuevoProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public Producto buscarProducto(Long id) {
        Producto producto = null;
        producto = productoRepositorio.findById(id).orElse(null);

        if (producto == null) {
            return null;
        }

        return producto;
    }

    @Override
    public int borrarProducto(Long id) {
        productoRepositorio.deleteById(id);
        return 1;
    }
}
