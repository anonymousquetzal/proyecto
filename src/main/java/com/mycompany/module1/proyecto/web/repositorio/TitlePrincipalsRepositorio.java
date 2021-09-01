/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.repositorio;
import com.mycompany.module1.proyecto.web.controller.MainClazz;
import com.mycompany.module1.proyecto.web.dominio.Profesion;
import com.mycompany.module1.proyecto.web.dominio.Profesion_;
import com.mycompany.module1.proyecto.web.dominio.TitlePrincipals;
import com.mycompany.module1.proyecto.web.dominio.TitlePrincipals_;
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
public class TitlePrincipalsRepositorio {

    @PersistenceContext
    private EntityManager entityManager;

    MainClazz mainClazz = new MainClazz();

    public List<TitlePrincipals> buscarTitlePrincipals() {
        this.entityManager = MainClazz.entityManager;

        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<TitlePrincipals> titlePrincipalsQuery = builder.createQuery(TitlePrincipals.class);

        titlePrincipalsQuery.from(TitlePrincipals.class);

        MainClazz.entityManager = this.entityManager;

        return this.entityManager.createQuery(titlePrincipalsQuery).getResultList(); //retorna nullo

    }

    private TitlePrincipals buscarTitlePrincipalsPorPersonaId(String personaId) {
        var builder = MainClazz.entityManager.getCriteriaBuilder();

        CriteriaQuery<TitlePrincipals> titlePrincipalsQuery = builder.createQuery(TitlePrincipals.class);

        Root<TitlePrincipals> root = titlePrincipalsQuery.from(TitlePrincipals.class);

        titlePrincipalsQuery.where(
                builder.equal(root.get(TitlePrincipals_.personaId), personaId)
        );

        try {
            return MainClazz.entityManager.createQuery(titlePrincipalsQuery).getSingleResult();

        } catch (NoResultException ex) {

        }
        return null;
    }

    @Transactional
    public void crearOActualizarTitlePrincipals(TitlePrincipals titlePrincipalsNuevo) {

        TitlePrincipals titlePrincipals = this.buscarTitlePrincipalsPorPersonaId(titlePrincipalsNuevo.getPersonaId());

        if (titlePrincipals == null) {

            MainClazz.entityManager.persist(titlePrincipals);

        } else {

            MainClazz.entityManager.merge(titlePrincipals);
        }
    }
    
     @Transactional
    public void crearOActualizarTitlePrincipals1(TitlePrincipals titlePrincipalsNuevo) {      
      
            MainClazz.entityManager.persist(titlePrincipalsNuevo);       

   }

}
