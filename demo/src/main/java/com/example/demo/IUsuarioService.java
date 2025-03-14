package com.example;

import java.util.List;

public interface IUsuarioService {

    List<Producto> getUsuarios();

    Producto nuevoUsuario(Producto usuario);

    Producto buscarUsuario(Long id);

    int borrarUsuario(Long id);
}
