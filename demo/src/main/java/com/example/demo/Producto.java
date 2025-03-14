package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = Producto.TABLE_NAME)
public class Producto {

    public static final String TABLE_NAME = "producto";

    /*
     * @id para identificar la llave primaria
     * 
     * @@GeneratedValue (strategy GenerationType. IDENTITY)
     * se define el autoincremental
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*
     * @ManyToOne hace referencia la relacion muchos
     * a uno en este caso muchos usuario tienen un
     * tipo de documento
     * 
     * @JoinColumn el campo que hace de referecia a la llave foranea
     * 
     */
    @ManyToOne
    @JoinColumn(name = "idProveedor")
    private Proveedor idProveedor;

    /*
     * @Column nombre de la columna si el
     * nombre en la base de datos del campo es
     * igual a el de la variable no es necesario
     * poner la anotacion
     */

    @Column(name = "numeroDocumento")
    private String numeroDocumento;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "password")
    private String password;

    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    @Column(name = "email")
    private String email;

    // Constructor vacío
    public Producto() {
    }

    // Constructor no vacío
    public Producto(Long id,
            Proveedor idTipoDocumento,
            String numeroDocumento,
            String nombre,
            String password,
            String nombreUsuario,
            String email) {

        this.id = id;
        this.idTipoDocumento = idTipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.password = password;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Proveedor getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Proveedor idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
