/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.dominio;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

/**
 *
 * @author Leticia Boch
 */
@Entity
@Table(name = "titulo_sinonimo")
@Data
@EqualsAndHashCode(of = "tituloSinonimoId", callSuper = false)
@ToString(of = "tituloSinonimoId")
@DynamicInsert
@SelectBeforeUpdate
@DynamicUpdate
public class TituloSinonimo extends Entidad{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "titulo_sinonimo_id")
    private Long tituloSinonimoId;
    
    @Column(name = "titulo_id")
    private String tituloId;
    
    @Column(name = "linea")
    private String linea;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "region")
    private String region;
    
    @Column(name = "language")
    private String language;
    
    @Column(name = "tipos")
    private String tipos;
    
    @Column(name = "atributos")
    private String atributos;
    
    @Column(name = "original")
    private boolean original;
//    
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    @JoinColumn(name = "titulo_id", referencedColumnName = "titulo_id")
//    private Titulo titulo;

//    @JsonbTransient
//    @OneToMany(mappedBy = "titulo_sinonimo")
//    private List<TituloSinonimoYTitulo> tituloSinonimoYTituloList;
//    
}
