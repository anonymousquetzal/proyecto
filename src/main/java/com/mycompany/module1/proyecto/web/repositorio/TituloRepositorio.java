/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.repositorio;

//import com.mycompany.module1.project.dominio.Titulo;
//import com.mycompany.module1.project.dominio.Titulo_;
import com.mycompany.module1.proyecto.web.controller.MainClazz;
import com.mycompany.module1.proyecto.web.dominio.Persona;
import com.mycompany.module1.proyecto.web.dominio.Titulo;
import com.mycompany.module1.proyecto.web.dominio.Titulo_;
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
public class TituloRepositorio {

    @PersistenceContext
    private EntityManager entityManager;
    
    MainClazz mainClazz = new MainClazz();

    
//    
//    public List<Titulo> getTituloList() {
//
//        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
//
//        CriteriaQuery<Titulo> query = builder.createQuery(Titulo.class);
//
//        query.from(Titulo.class);
//
//        return this.entityManager.createQuery(query).getResultList();
//
//    }
//
//    
//    public Titulo buscarTituloPorCodigo(String codigo) {
//
//        var builder = this.entityManager.getCriteriaBuilder();
//
//        CriteriaQuery<Titulo> profesionQuery = builder.createQuery(Titulo.class);
//
//        Root<Titulo> root = profesionQuery.from(Titulo.class);
//
//        profesionQuery.where(
//                builder.equal(root.get(Titulo_.codigo), codigo)
//        );
//
//        try {
//            return this.entityManager.createQuery(profesionQuery).getSingleResult();
//        } catch (NoResultException ex) {
//
//        }
//        return null;
//    }
//
//    @Transactional
//    public void crearOrActualizarTitulo(Titulo tituloNuevo) {
//
//        Titulo titulo = this.buscarTituloPorCodigo(tituloNuevo.getCodigo());
//
//        if (titulo == null) {
//            this.entityManager.persist(tituloNuevo);
//        } else {
//            titulo.setAnyoFin(tituloNuevo.getAnyoFin());
//            titulo.setAnyoInicio(tituloNuevo.getAnyoInicio());
//            titulo.setNombre(tituloNuevo.getNombre());
//            titulo.setNombreOriginal(tituloNuevo.getNombreOriginal());
//            titulo.setParaAdultos(tituloNuevo.isParaAdultos());
//            titulo.setTiempo(tituloNuevo.getTiempo());
//            this.entityManager.merge(titulo);
//        }
//    }

    
        
    public List<Titulo> getTituloList() {

        CriteriaBuilder builder = MainClazz.entityManager.getCriteriaBuilder();

        CriteriaQuery<Titulo> query = builder.createQuery(Titulo.class);

        query.from(Titulo.class);

        return MainClazz.entityManager.createQuery(query).getResultList();

    }

    
    public Titulo buscarTituloPorCodigo(String codigo) {
        System.out.println("busacndo codigo!!!!!!");
        System.out.println("busacndo codigo!!!!!!" + codigo);

        CriteriaBuilder builder = MainClazz.entityManager.getCriteriaBuilder();

        CriteriaQuery<Titulo> profesionQuery = builder.createQuery(Titulo.class);

        Root<Titulo> root = profesionQuery.from(Titulo.class);

        profesionQuery.where(
                builder.equal(root.get(Titulo_.codigo), codigo)
        );

        try {
            System.out.println("busacndo codigo!!!!!! TRYYY");
            return MainClazz.entityManager.createQuery(profesionQuery).getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("try catch title repo");

        }
        return null;
    }

    @Transactional
    public void crearOrActualizarTitulo(Titulo tituloNuevo) {

        Titulo titulo = this.buscarTituloPorCodigo(tituloNuevo.getCodigo());

        if (titulo == null) {
            MainClazz.entityManager.persist(tituloNuevo);
        } else {
            titulo.setAnyoFin(tituloNuevo.getAnyoFin());
            titulo.setAnyoInicio(tituloNuevo.getAnyoInicio());
            titulo.setNombre(tituloNuevo.getNombre());
            titulo.setNombreOriginal(tituloNuevo.getNombreOriginal());
            titulo.setParaAdultos(tituloNuevo.isParaAdultos());
            titulo.setTiempo(tituloNuevo.getTiempo());
            MainClazz.entityManager.merge(titulo);
        }
    }

}
