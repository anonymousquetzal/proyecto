/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 
 */
@Getter
@Setter
@MappedSuperclass
public class Entidad implements Serializable {

    @Column(name = "creado_el")
    private LocalDateTime creadoEl;

    @Column(name = "modificado_el")
    private LocalDateTime modificadoEl;
    
 
    @PrePersist
    public void ejecutarAntesDePersistir(){
        this.creadoEl = LocalDateTime.now();
    }
    
    @PreUpdate
    public void ejecutarAntesDeActualizar(){
        this.modificadoEl = LocalDateTime.now();
    } 
}
