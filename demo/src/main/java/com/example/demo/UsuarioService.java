package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.DemoApplication;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService implements IUsuarioService {

    private final DemoApplication demoApplication;

    @Autowired
    ProductoRepositorio usuarioRepositorio;

    UsuarioService(DemoApplication demoApplication) {
        this.demoApplication = demoApplication;
    }

    @Override
    public List<Producto> getUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Producto nuevoUsuario(Producto usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public Producto buscarUsuario(Long id) {
        Producto usuario = null;
        usuario = usuarioRepositorio.findById(id).orElse(null);

        if (usuario == null) {
            return null;
        }

        return usuario;
    }

    @Override
    public int borrarUsuario(Long id) {
        usuarioRepositorio.deleteById(id);
        return 1;
    }
}
