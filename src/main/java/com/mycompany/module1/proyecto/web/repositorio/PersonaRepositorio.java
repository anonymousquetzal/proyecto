/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.repositorio;

//import com.mycompany.module1.project.dominio.Persona;
//import com.mycompany.module1.project.dominio.Persona_;
import com.mycompany.module1.proyecto.web.controller.MainClazz;
import com.mycompany.module1.proyecto.web.dominio.Persona;
import com.mycompany.module1.proyecto.web.dominio.Persona_;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Leticia Boch
 */
@RequestScoped
public class PersonaRepositorio {

    @PersistenceContext
    private EntityManager entityManager;
    
    MainClazz mainClazz = new MainClazz();

    

//    public List<Persona> getPersonaList() {
//
//        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
//
//        CriteriaQuery<Persona> query = builder.createQuery(Persona.class);
//
//        query.from(Persona.class);
//
//        return this.entityManager.createQuery(query).getResultList();
//
//    }
//
//    public Persona buscarPersonaPorCodigo(String codigo) {
//
//
//        var builder = this.entityManager.getCriteriaBuilder();
//
//        CriteriaQuery<Persona> personaQuery = builder.createQuery(Persona.class);
//
//        Root<Persona> root = personaQuery.from(Persona.class);
//
//        personaQuery.where(
//                builder.equal(root.get(Persona_.codigo), codigo)
//        );
//
//        try {
//
//            return this.entityManager.createQuery(personaQuery).getSingleResult();
//            
//        } catch (NoResultException ex) {
//
//        }
//        return null;
//
//    }
//
//    @Transactional
//    public void crearOActualizarPersona(Persona personaNuevo) {
//
//        Persona persona = this.buscarPersonaPorCodigo(personaNuevo.getCodigo());
//
//        if (persona == null) {
//
//            this.entityManager.persist(personaNuevo);
//
//        } else {
//
//            persona.setNombre(personaNuevo.getNombre());
//            persona.setAnyoNacimiento(personaNuevo.getAnyoNacimiento());
//            persona.setAnyoFallecimiento(personaNuevo.getAnyoFallecimiento());
//            persona.setProfesionSet(personaNuevo.getProfesionSet());
//
//            this.entityManager.merge(persona);            
//
//        }
//
//    }

    public List<Persona> getPersonaList() {

        CriteriaBuilder builder = MainClazz.entityManager.getCriteriaBuilder();

        CriteriaQuery<Persona> query = builder.createQuery(Persona.class);

        query.from(Persona.class);

        return MainClazz.entityManager.createQuery(query).getResultList();

    }

    public Persona buscarPersonaPorCodigo(String codigo) {
        System.out.println("buscando personas en codigos");


        var builder = MainClazz.entityManager.getCriteriaBuilder();

        CriteriaQuery<Persona> personaQuery = builder.createQuery(Persona.class);

        Root<Persona> root = personaQuery.from(Persona.class);

        personaQuery.where(
                builder.equal(root.get(Persona_.codigo), codigo)
        );

        try {

            return MainClazz.entityManager.createQuery(personaQuery).getSingleResult();
            
        } catch (NoResultException ex) {

        }
        return null;

    }

    @Transactional
    public void crearOActualizarPersona(Persona personaNuevo) {

        Persona persona = this.buscarPersonaPorCodigo(personaNuevo.getCodigo());

        if (persona == null) {

            MainClazz.entityManager.persist(personaNuevo);

        } else {

            persona.setNombre(personaNuevo.getNombre());
            persona.setAnyoNacimiento(personaNuevo.getAnyoNacimiento());
            persona.setAnyoFallecimiento(personaNuevo.getAnyoFallecimiento());
            persona.setProfesionSet(personaNuevo.getProfesionSet());

            MainClazz.entityManager.merge(persona);            

        }

    }

}
