/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import org.hibernate.mapping.Set;
import java.util.List;
/**
 *
 * @author near
 */
@Entity
@Table(name = "venta")
public class Venta implements Serializable {
    
    @Id
    @GeneratedValue(generator = "venta_idventa_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "venta_idventa_seq",sequenceName = "venta_idventa_seq",
            initialValue = 1, allocationSize = 1)
    @Column(name = "idventa")
    private Long idVenta;
    
    @Column(name = "fecha")
    private Date fecha;
    
    @Column(name = "total")
    private BigDecimal total;
    
     @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVenta> detalleVenta;

    public Venta() {
    }

   

    public Venta(Long idVenta, Date fecha, BigDecimal total) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.total = total;
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    public List<DetalleVenta> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(List<DetalleVenta> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }
    
    
}
