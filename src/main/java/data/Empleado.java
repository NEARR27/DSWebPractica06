/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;


import javax.validation.constraints.NotNull;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 *
 * @author near
 */
@Entity
@Table(name="empleado")
public class Empleado implements Serializable  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empleado_id_seq")
    @SequenceGenerator(name="empleado_id_seq", sequenceName ="empleado_id_seq",
            initialValue=1,allocationSize=1)
    private Long id;
    
    @NotNull
    @Column(name= "nombre")
    private String nombre;
    
    @NotNull
    @Column(name= "direccion")
    private String direccion;
    
    @NotNull
    @Column(name= "telefono")
    private String telefono;

    public Empleado(Long id, String nombre, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    public Empleado() {
    }
    
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
