package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private ProductoService usuarioService;

    @GetMapping("/list")
    public List<Producto> cargarUsuarios() {
        return usuarioService.getUsuarios();
    }

    @GetMapping("/list/{id}")
    public Producto buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarUsuario(id);
    }

    @PostMapping("/")
    public ResponseEntity<Producto> agregar(@RequestBody Producto usuario) {
        Producto obj = usuarioService.nuevoUsuario(usuario);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Producto> editar(@RequestBody Producto usuario) {
        Producto obj = usuarioService.buscarUsuario(usuario.getId());
        if (obj != null) {
            obj.setEmail(usuario.getEmail());
            obj.setIdTipoDocumento(usuario.getIdTipoDocumento());
            obj.setNombre(usuario.getNombre());
            obj.setNombreUsuario(usuario.getNombreUsuario());
            obj.setNumeroDocumento(usuario.getNumeroDocumento());
            obj.setPassword(usuario.getPassword());
            usuarioService.nuevoUsuario(obj);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> eliminar(@PathVariable Long id) {
        Producto obj = usuarioService.buscarUsuario(id);
        if (obj != null) {
            usuarioService.borrarUsuario(id);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
