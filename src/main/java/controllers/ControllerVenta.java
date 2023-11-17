/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package controllers;

import DTO.VentaDTO;
import data.DetalleVenta;
import data.RepositoryVenta;
import data.Venta;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.Date;
/**
 *
 * @author near
 */
@RestController
@RequestMapping("/api/venta")
public class ControllerVenta {

    @Autowired
    private RepositoryVenta repositoryVenta;

    @PostMapping
    public ResponseEntity<Venta> post(@RequestBody VentaDTO ventaDTO) {
        Venta venta = convertToEntity(ventaDTO);
        venta.setFecha(new Date());

        BigDecimal total = BigDecimal.ZERO;
        for (DetalleVenta detalle : venta.getDetalleVenta()) {
            BigDecimal precio = BigDecimal.valueOf(detalle.getPrecio());
            int cantidad = detalle.getCantidad();
            total = total.add(precio.multiply(BigDecimal.valueOf(cantidad)));
        }

        venta.setTotal(total);

        
        Venta savedVenta = repositoryVenta.save(venta);
        return ResponseEntity.ok(savedVenta);
    }

    @GetMapping()
    public List<VentaDTO> list() {
        return repositoryVenta.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaDTO> get(@PathVariable Long id) {
        return repositoryVenta.findById(id)
                .map(this::convertToDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> put(@PathVariable Long id, @RequestBody VentaDTO ventaDTO) {
        if (!repositoryVenta.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Venta venta = convertToEntity(ventaDTO);
        venta.setIdVenta(id); // Asegurarse de que se actualiza la venta correcta
        // Aquí se puede recalcular el total si es necesario
        Venta updatedVenta = repositoryVenta.save(venta);
        return ResponseEntity.ok(updatedVenta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!repositoryVenta.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repositoryVenta.deleteById(id);
        return ResponseEntity.ok().build();
    }

    
    private Venta convertToEntity(VentaDTO ventaDTO) {
        
        return new Venta(); 
    }

    private VentaDTO convertToDTO(Venta venta) {
        
        return new VentaDTO(); 
    }

}
