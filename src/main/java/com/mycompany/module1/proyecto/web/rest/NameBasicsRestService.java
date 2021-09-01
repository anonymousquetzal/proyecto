/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.rest;


import com.mycompany.module1.proyecto.web.controller.MainClazz;
import com.mycompany.module1.proyecto.web.dominio.Persona;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 *
 * @author k0co8
 */
@RequestScoped
public class NameBasicsRestService {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    MainClazz mainClazz = new MainClazz();
    
    public List<Persona> getPersonaList() {

        //CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaBuilder builder = MainClazz.entityManager.getCriteriaBuilder();

        CriteriaQuery<Persona> query = builder.createQuery(Persona.class);

        query.from(Persona.class);

        //return this.entityManager.createQuery(query).getResultList();
        return MainClazz.entityManager.createQuery(query).getResultList();

    }
    
}
