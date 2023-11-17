/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

/**
 *
 * @author near
 */
public class VentaDTO {
    
      @Size(min = 1, message = "Debe haber al menos un detalle en la venta")
    private List<DetalleVentaDTO> detalleVenta;

    public List<DetalleVentaDTO> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(List<DetalleVentaDTO> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }
      
      

   
}

class DetalleVentaDTO {

    @NotEmpty(message = "El nombre del producto no puede estar vacío")
    private String nombre;

    @Positive(message = "El precio debe ser positivo")
    private double precio;

    @Positive(message = "La cantidad debe ser positiva")
    private int cantidad;

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

    
    
}
