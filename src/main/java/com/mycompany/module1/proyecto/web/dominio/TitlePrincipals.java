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
import jakarta.persistence.Table;
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
@Table(name = "title_principals")
@Data
@EqualsAndHashCode(of = "titlePrincipalsId", callSuper = false)
@ToString(of = "titlePrincipalsId")
@DynamicInsert
@SelectBeforeUpdate
@DynamicUpdate
public class TitlePrincipals extends Entidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "title_principals_id")
    private Long titlePrincipalsId;

    @Column(name = "titulo_principal_titulo_id")
    private String tituloId;
    
    @Column(name = "titulo_principal_persona_id")
    private String personaId;
    
    @Column(name = "linea")
    private String linea;
    
    @Column(name = "categoria")
    private String categoria;
    
    @Column(name = "profesion")
    private String profesion;
    
    @Column(name = "personaje")
    private String personaje;
    
    @Column(name = "descripcion_nombre")
    private String name;
    
    @Column(name = "descripcion_title")
    private String title;
    
    
    
}
