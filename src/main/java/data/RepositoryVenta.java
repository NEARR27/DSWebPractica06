/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package data;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author near
 */
public interface RepositoryVenta extends JpaRepository<Venta, Long> {
    
}
