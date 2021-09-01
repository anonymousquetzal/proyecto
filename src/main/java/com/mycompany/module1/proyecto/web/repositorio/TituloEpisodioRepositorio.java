/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.repositorio;

import com.mycompany.module1.proyecto.web.controller.MainClazz;
import com.mycompany.module1.proyecto.web.dominio.TitleEpisode;
import com.mycompany.module1.proyecto.web.dominio.TitleEpisode_;
import com.mycompany.module1.proyecto.web.dominio.TitlePrincipals;
import com.mycompany.module1.proyecto.web.dominio.TitlePrincipals_;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import java.util.List;


/**
 *
 * @author Leticia Boch
 */
@RequestScoped
public class TituloEpisodioRepositorio {

    @PersistenceContext
    private EntityManager entityManager;

    MainClazz mainClazz = new MainClazz();

    public List<TitleEpisode> buscarTitleEpisode() {
        this.entityManager = MainClazz.entityManager;

        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<TitleEpisode> titleEpisodeQuery = builder.createQuery(TitleEpisode.class);

        titleEpisodeQuery.from(TitleEpisode.class);

        MainClazz.entityManager = this.entityManager;

        return this.entityManager.createQuery(titleEpisodeQuery).getResultList(); //retorna nullo

    }

    private TitleEpisode buscarTitleEpisodePorTituloId(String tituloId) {
        var builder = MainClazz.entityManager.getCriteriaBuilder();

        CriteriaQuery<TitleEpisode> titleEpisodeQuery = builder.createQuery(TitleEpisode.class);

        Root<TitleEpisode> root = titleEpisodeQuery.from(TitleEpisode.class);

        titleEpisodeQuery.where(
                builder.equal(root.get(TitleEpisode_.tituloId), tituloId)
        );

        try {
            return MainClazz.entityManager.createQuery(titleEpisodeQuery).getSingleResult();

        } catch (NoResultException ex) {

        }
        return null;
    }

    @Transactional
    public void crearOActualizarTitleEpisode(TitleEpisode titleEpisodeNuevo) {

        TitleEpisode titleEpisode = this.buscarTitleEpisodePorTituloId(titleEpisodeNuevo.getTituloId());

        if (titleEpisode == null) {

            MainClazz.entityManager.persist(titleEpisode);

        } else {

            MainClazz.entityManager.merge(titleEpisode);
        }
    }
    
     @Transactional
    public void crearOActualizarTitleEpisode1(TitlePrincipals titleEpisodeNuevo) {      
      
            MainClazz.entityManager.persist(titleEpisodeNuevo);       

   }

}
