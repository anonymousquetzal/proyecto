/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *

 */
@Entity
@Table(name = "persona_titulo")
@Data
@EqualsAndHashCode(of = "tituloId", callSuper = false)
@ToString(of = "tituloId")
public class PersonaTitulo implements Serializable {

    public static final int ACTORES_ACTRICES = 1;
    public static final int DIRECTORES = 2;
    public static final int ESCRITORES = 3;    
    
    @Id
    @Column(name = "persona_id")
    private Long personaId;

    @Id
    @Column(name = "titulo_id")
    private Long tituloId;

    @Id
    @Column(name = "tipo_relacion")
    private Integer tipoRelacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id", referencedColumnName = "persona_id", insertable = false, updatable = false)
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "titulo_id", referencedColumnName = "titulo_id", insertable = false, updatable = false)
    private Titulo titulo;
    
}
