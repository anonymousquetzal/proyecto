/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.repositorio;

//import com.mycompany.module1.project.dominio.Persona;
import com.mycompany.module1.proyecto.web.controller.MainClazz;
import com.mycompany.module1.proyecto.web.dominio.Persona;
import com.mycompany.module1.proyecto.web.dominio.PersonaTitulo;
import com.mycompany.module1.proyecto.web.dominio.PersonaTitulo_;
import com.mycompany.module1.proyecto.web.dominio.Titulo;
import jakarta.enterprise.context.RequestScoped;
//import com.mycompany.module1.project.dominio.PersonaTitulo;
//import com.mycompany.module1.project.dominio.PersonaTitulo_;
//import com.mycompany.module1.project.dominio.Titulo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Mario Batres
 */
@RequestScoped
public class PersonaTituloRepositorio {

    /**
     * @param personaRepositorio the personaRepositorio to set
     */
    public void setPersonaRepositorio(PersonaRepositorio personaRepositorio) {
        this.personaRepositorio = personaRepositorio;
    }

    //private final PersonaRepositorio personaRepositorio;
    private PersonaRepositorio personaRepositorio = new PersonaRepositorio();

    @PersistenceContext
    private EntityManager entityManager;
    //private final EntityManager entityManager;

    MainClazz mainClazz = new MainClazz();

    //public PersonaTituloRepositorio(EntityManager entityManager, PersonaRepositorio personaRepositorio) {
//    public PersonaTituloRepositorio(PersonaRepositorio personaRepositorio) {
//        //this.entityManager = entityManager;
//        this.personaRepositorio = personaRepositorio;
//    }
//    @Transactional
//    private void actualizar(Titulo titulo, String[] codigos, int tipoRelacion) {
//        //aquí tendríamos que eliminar todos los registros de persona_titulo donde el titulo sea igual al que estamos procesando
//        var builder = this.entityManager.getCriteriaBuilder();
//
//        CriteriaDelete<PersonaTitulo> query = builder.createCriteriaDelete(PersonaTitulo.class);
//
//        Root<PersonaTitulo> root = query.from(PersonaTitulo.class);
//
//        query.where(
//                builder.equal(root.get(PersonaTitulo_.titulo), titulo),
//                builder.equal(root.get(PersonaTitulo_.tipoRelacion), tipoRelacion)
//        );
//
//        this.entityManager.createQuery(query).executeUpdate();
//
//        if (codigos != null) {
//
//            List<Persona> directoresPersonaList = Stream.of(codigos)
//                    .map(personaRepositorio::buscarPersonaPorCodigo)
//                    .filter(p -> p != null)
//                    .collect(Collectors.toList());
//
//            directoresPersonaList.stream().forEach(director -> {
//
//                PersonaTitulo personaTitulo = new PersonaTitulo();
//                personaTitulo.setPersonaId(director.getPersonaId());
//                personaTitulo.setTituloId(titulo.getTituloId());
//                personaTitulo.setTipoRelacion(tipoRelacion);
//
//                this.entityManager.persist(personaTitulo);
//            });
//
//        }
//    }
//
//    public void actualizarDirectores(Titulo titulo, String[] codigos) {
//        this.actualizar(titulo, codigos, PersonaTitulo.DIRECTORES);
//    }
//
//    public void actualizarEscritores(Titulo titulo, String[] codigos) {
//        this.actualizar(titulo, codigos, PersonaTitulo.ESCRITORES);
//    }
//    @Transactional
//    public void actualizarDirectores1(Titulo titulo, String[] codigos) {
//        //aquí tendríamos que eliminar todos los registros de persona_titulo donde el titulo sea igual al que estamos procesando
//        var builder = this.entityManager.getCriteriaBuilder();
//
//        CriteriaDelete<PersonaTitulo> query = builder.createCriteriaDelete(PersonaTitulo.class);
//
//        Root<PersonaTitulo> root = query.from(PersonaTitulo.class);
//
//        query.where(
//                builder.equal(root.get(PersonaTitulo_.titulo), titulo),
//                builder.equal(root.get(PersonaTitulo_.tipoRelacion), PersonaTitulo.DIRECTORES)
//        );
//
//        this.entityManager.createQuery(query).executeUpdate();
//
//        if (codigos != null) {
//
//            List<Persona> directoresPersonaList = Stream.of(codigos)
//                    .map(personaRepositorio::buscarPersonaPorCodigo)
//                    .filter(p -> p != null)
//                    .collect(Collectors.toList());
//
//            directoresPersonaList.stream().forEach(director -> {
//
//                PersonaTitulo personaTitulo = new PersonaTitulo();
//                personaTitulo.setPersonaId(director.getPersonaId());
//                personaTitulo.setTituloId(titulo.getTituloId());
//                personaTitulo.setTipoRelacion(PersonaTitulo.DIRECTORES);
//
//                this.entityManager.persist(personaTitulo);
//            });
//
//        }
//    }
    
    @Transactional
    private void actualizar(Titulo titulo, String[] codigos, int tipoRelacion) {
        System.out.println("MAde it to actualizar");
        //aquí tendríamos que eliminar todos los registros de persona_titulo donde el titulo sea igual al que estamos procesando
        CriteriaBuilder builder = MainClazz.entityManager.getCriteriaBuilder();

        CriteriaDelete<PersonaTitulo> query = builder.createCriteriaDelete(PersonaTitulo.class);

        Root<PersonaTitulo> root = query.from(PersonaTitulo.class);

        query.where(
                builder.equal(root.get(PersonaTitulo_.titulo), titulo),
                builder.equal(root.get(PersonaTitulo_.tipoRelacion), tipoRelacion)
        );

        System.out.println("MAde it to exexute update");
        MainClazz.entityManager.createQuery(query).executeUpdate();

        if (codigos != null) {

            System.out.println("codigos no null in actualizar");
            System.out.println(codigos);
            //List<Persona> directoresPersonaList = new ArrayList<Persona>();
            List<Persona> directoresPersonaList = Stream.of(codigos)
            //directoresPersonaList = Stream.of(codigos)                    
                    .map(personaRepositorio::buscarPersonaPorCodigo)
                    .filter(p -> p != null)
                    .collect(Collectors.toList());

            System.out.println("actualizar for eact director");
            directoresPersonaList.stream().forEach(director -> {

                PersonaTitulo personaTitulo = new PersonaTitulo();
                personaTitulo.setPersonaId(director.getPersonaId());
                personaTitulo.setTituloId(titulo.getTituloId());
                personaTitulo.setTipoRelacion(tipoRelacion);

                System.out.println("ABOUT TO PERSISTS PERSONA TITULO");

                MainClazz.entityManager.persist(personaTitulo);
            });

        }
    }

    @Transactional
    public void actualizarDirectores(Titulo titulo, String[] codigos) {
        //System.out.println(titulo.getCodigo()+codigos.length + "plus11");
        this.actualizar(titulo, codigos, PersonaTitulo.DIRECTORES);
    }

    @Transactional
    public void actualizarEscritores(Titulo titulo, String[] codigos) {
        //System.out.println(titulo.getCodigo()+codigos.length + "plus");
        this.actualizar(titulo, codigos, PersonaTitulo.ESCRITORES);
    }

    @Transactional
    public void actualizarDirectores1(Titulo titulo, String[] codigos) {
        //aquí tendríamos que eliminar todos los registros de persona_titulo donde el titulo sea igual al que estamos procesando
        var builder = MainClazz.entityManager.getCriteriaBuilder();

        CriteriaDelete<PersonaTitulo> query = builder.createCriteriaDelete(PersonaTitulo.class);

        Root<PersonaTitulo> root = query.from(PersonaTitulo.class);

        query.where(
                builder.equal(root.get(PersonaTitulo_.titulo), titulo),
                builder.equal(root.get(PersonaTitulo_.tipoRelacion), PersonaTitulo.DIRECTORES)
        );

        MainClazz.entityManager.createQuery(query).executeUpdate();

        if (codigos != null) {

            List<Persona> directoresPersonaList = Stream.of(codigos)
                    .map(personaRepositorio::buscarPersonaPorCodigo)
                    .filter(p -> p != null)
                    .collect(Collectors.toList());

            directoresPersonaList.stream().forEach(director -> {

                PersonaTitulo personaTitulo = new PersonaTitulo();
                personaTitulo.setPersonaId(director.getPersonaId());
                personaTitulo.setTituloId(titulo.getTituloId());
                personaTitulo.setTipoRelacion(PersonaTitulo.DIRECTORES);

                MainClazz.entityManager.persist(personaTitulo);
            });

        }
    }
}
