/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;


/**
 *
 *
 */
@Entity
@Table(name = "profesion")
@Data
@EqualsAndHashCode(of = "profesionId", callSuper = false)
@ToString(of = "profesionId")
@DynamicInsert
@SelectBeforeUpdate
@DynamicUpdate//does not do all insert//not needed for payara or eclipse link
public class Profesion extends Entidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profesion_id")
    private Long profesionId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;
    
    @ManyToMany(mappedBy = "profesionSet")
    private Set<Persona> personaSet;

}
