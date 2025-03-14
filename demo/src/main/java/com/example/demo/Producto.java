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
    private Proveedor proveedor;

    /*
     * @Column nombre de la columna si el
     * nombre en la base de datos del campo es
     * igual a el de la variable no es necesario
     * poner la anotacion
     */

    @Column(name = "ivaCompra")
    private double ivaCompra;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precioCompra")
    private double precioCompra;

    @Column(name = "precioVenta")
    private double precioVenta;

    // Constructor vacío
    public Producto() {
    }

    // Constructor con parámetros
    public Producto(
            Long id,
            Proveedor proveedor,
            double ivaCompra,
            String nombre,
            double precioCompra,
            double precioVenta) {
        this.id = id;
        this.proveedor = proveedor;
        this.ivaCompra = ivaCompra;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public double getIvaCompra() {
        return ivaCompra;
    }

    public void setIvaCompra(double ivaCompra) {
        this.ivaCompra = ivaCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

}
