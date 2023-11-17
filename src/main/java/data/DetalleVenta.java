/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author near
 */

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta implements Serializable {
    
     @Id
    @GeneratedValue(generator = "venta_detalle_iddetalleventa_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "venta_detalle_iddetalleventa_seq", sequenceName = "venta_detalle_iddetalleventa_seq",
            initialValue = 1, allocationSize = 1)
    @Column(name = "iddetalleventa")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private double precio;

    @Column(name = "cantidad")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;

    // Constructor vacío requerido por JPA
    public DetalleVenta() {
    }

    // Constructor completo
    public DetalleVenta(String nombre, double precio, int cantidad, Venta venta) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.venta = venta;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    
    
}
