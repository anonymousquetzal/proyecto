/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.repositorio;

//import com.mycompany.module1.project.dominio.Profesion;
import com.mycompany.module1.proyecto.web.controller.MainClazz;
import com.mycompany.module1.proyecto.web.dominio.Profesion;
import com.mycompany.module1.proyecto.web.dominio.Profesion_;
import jakarta.enterprise.context.RequestScoped;
//import com.mycompany.module1.project.dominio.Profesion_;
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
 * @se usa para crear o cambiar nombre
 *
 */
@RequestScoped
public class ProfesionRepositorio {

    @PersistenceContext
    private EntityManager entityManager;
    
    MainClazz mainClazz = new MainClazz();
//
//    public ProfesionRepositorio(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//    

//    public List<Profesion> buscarProfesiones() {
//        System.out.println("buscar profesiones");
//
//        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
//        //var builder = entityManager.getCriteriaBuilder();
//
//        CriteriaQuery<Profesion> profesionQuery = builder.createQuery(Profesion.class);
//
//        profesionQuery.from(Profesion.class);
//        System.out.println("ending method");
//
//        return entityManager.createQuery(profesionQuery).getResultList(); //retorna nullo
//        //return this.entityManager.createQuery(profesionQuery).getResultList(); //retorna nullo
//    }
//
//    
//    public Profesion buscarProfesionPorNombre(String nombre) {
//        var builder = this.entityManager.getCriteriaBuilder();
////        var builder = entityManager.getCriteriaBuilder();
//
//        CriteriaQuery<Profesion> profesionQuery = builder.createQuery(Profesion.class);
//
//        Root<Profesion> root = profesionQuery.from(Profesion.class);
//
//        profesionQuery.where(
//                builder.equal(root.get(Profesion_.nombre), nombre)
//        );
//
//        try {
//            return this.entityManager.createQuery(profesionQuery).getSingleResult();
//            //return entityManager.createQuery(profesionQuery).getSingleResult();
//        } catch (NoResultException ex) {
//
//        }
//        return null;
//    }
//    @Transactional
//    public void crearOActualizarProfesion(Profesion profesionNuevo) {
//        
//        System.out.println("PROFESION !!!!!!!");
//
//        Profesion profesion = this.buscarProfesionPorNombre(profesionNuevo.getNombre());
//        //Profesion profesion = this.buscarProfesionPorNombre(entityManager, profesionNuevo.getNombre());
//
//        if (profesion == null) {
//            //profesionNuevo.setCreadoEl(LocalDateTime.now());
//            //entityManager.persist(profesionNuevo);
//            this.entityManager.persist(profesionNuevo);
//        } else {
//            profesion.setDescripcion(profesionNuevo.getDescripcion());
//            //profesion.setModificadoEl(LocalDateTime.now());
//            this.entityManager.merge(profesion);
//            //entityManager.merge(profesion);
//        }
//    }

    
        public List<Profesion> buscarProfesiones() {
            this.entityManager = MainClazz.entityManager;
        System.out.println("buscar profesiones");

        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        //var builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Profesion> profesionQuery = builder.createQuery(Profesion.class);

        profesionQuery.from(Profesion.class);
        System.out.println("ending method");
        MainClazz.entityManager = this.entityManager;

        return entityManager.createQuery(profesionQuery).getResultList(); //retorna nullo
        //return this.entityManager.createQuery(profesionQuery).getResultList(); //retorna nullo
    }

    
    public Profesion buscarProfesionPorNombre(String nombre) {
        var builder = MainClazz.entityManager.getCriteriaBuilder();
//        var builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Profesion> profesionQuery = builder.createQuery(Profesion.class);

        Root<Profesion> root = profesionQuery.from(Profesion.class);

        profesionQuery.where(
                builder.equal(root.get(Profesion_.nombre), nombre)
        );

        try {
            return MainClazz.entityManager.createQuery(profesionQuery).getSingleResult();
            //return entityManager.createQuery(profesionQuery).getSingleResult();
        } catch (NoResultException ex) {

        }
        return null;
    }
    @Transactional
    public void crearOActualizarProfesion(Profesion profesionNuevo) {
        
        System.out.println("PROFESION !!!!!!!");

        Profesion profesion = this.buscarProfesionPorNombre(profesionNuevo.getNombre());
        //Profesion profesion = this.buscarProfesionPorNombre(entityManager, profesionNuevo.getNombre());

        if (profesion == null) {
            //profesionNuevo.setCreadoEl(LocalDateTime.now());
            //entityManager.persist(profesionNuevo);
            MainClazz.entityManager.persist(profesionNuevo);
        } else {
            profesion.setDescripcion(profesionNuevo.getDescripcion());
            //profesion.setModificadoEl(LocalDateTime.now());
            MainClazz.entityManager.merge(profesion);
            //entityManager.merge(profesion);
        }
    }

}
