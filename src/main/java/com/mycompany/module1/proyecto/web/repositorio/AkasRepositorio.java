/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.repositorio;

import com.mycompany.module1.proyecto.web.controller.MainClazz;
import com.mycompany.module1.proyecto.web.dominio.Profesion;
import com.mycompany.module1.proyecto.web.dominio.Profesion_;
import com.mycompany.module1.proyecto.web.dominio.TituloSinonimo;
import com.mycompany.module1.proyecto.web.dominio.TituloSinonimo_;
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
public class AkasRepositorio {

    @PersistenceContext
    private EntityManager entityManager;

    MainClazz mainClazz = new MainClazz();

    public List<TituloSinonimo> buscarTituloSinonimo() {
        this.entityManager = MainClazz.entityManager;

        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<TituloSinonimo> tituloSinonimoQuery = builder.createQuery(TituloSinonimo.class);

        tituloSinonimoQuery.from(TituloSinonimo.class);

        MainClazz.entityManager = this.entityManager;

        return this.entityManager.createQuery(tituloSinonimoQuery).getResultList(); //retorna nullo

    }

    public TituloSinonimo buscarTituloSinonimoPorNombre(String nombre) {
        var builder = MainClazz.entityManager.getCriteriaBuilder();

        CriteriaQuery<TituloSinonimo> tituloSinonimoQuery = builder.createQuery(TituloSinonimo.class);

        Root<TituloSinonimo> root = tituloSinonimoQuery.from(TituloSinonimo.class);

        tituloSinonimoQuery.where(
                builder.equal(root.get(TituloSinonimo_.nombre), nombre)
        );

        try {
            return MainClazz.entityManager.createQuery(tituloSinonimoQuery).getSingleResult();

        } catch (NoResultException ex) {

        }
        return null;
    }

    @Transactional
    public void crearOActualizarTituloSinonimo2(TituloSinonimo tituloSinonimoNuevo) {

        TituloSinonimo tituloSinonimo = this.buscarTituloSinonimoPorNombre(tituloSinonimoNuevo.getNombre());

        if (tituloSinonimo == null) {

            MainClazz.entityManager.persist(tituloSinonimo);

        } else {

            MainClazz.entityManager.merge(tituloSinonimo);
        }
    }
    
     @Transactional
    public void crearOActualizarTituloSinonimo(TituloSinonimo tituloSinonimoNuevo) {

        

        

            MainClazz.entityManager.persist(tituloSinonimoNuevo);

        

   }

}
