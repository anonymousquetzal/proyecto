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
 * @
 */
@Entity
@Table(name = "titulo_episodio")
@Data
@EqualsAndHashCode(of = "tituloEpisodioId", callSuper = false)
@ToString(of = "tituloEpisodioId")
@DynamicInsert
@SelectBeforeUpdate
@DynamicUpdate
public class TitleEpisode extends Entidad{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "title_episodio_id")
    private Long tituloEpisodioId;

    @Column(name = "titulo_episodio_titulo_id")
    private String tituloId;
    
    @Column(name = "parent_id")
    private String parentId;
    
    @Column(name = "numero_temporada")
    private String numeroTemporada;
    
    @Column(name = "numero_episodio")
    private String numeroEpisodio;
    
    @Column(name = "profesion")
    private String profesion;
    
    @Column(name = "descripcion_parent")
    private String temporadaPadre;
    
    @Column(name = "descripcion_temporada")
    private String nombreTemporada;
    
    @Column(name = "descripcion_episodio")
    private String nombreEpisodio;
            
}
