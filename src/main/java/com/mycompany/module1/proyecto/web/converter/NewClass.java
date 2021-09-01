/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.converter;

/**
 *
 * @author Leticia Boch
 */
public class NewClass {
        /*
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

package com.mycompany.module1.proyecto.web.controller;

import com.mycompany.module1.proyecto.web.converter.PersonaDTOConverter;
import com.mycompany.module1.proyecto.web.converter.ProfesionDTOConverter;
import com.mycompany.module1.proyecto.web.converter.TituloDTOConverter;
import com.mycompany.module1.proyecto.web.dominio.Persona;
import com.mycompany.module1.proyecto.web.dominio.PersonaTitulo;
import com.mycompany.module1.proyecto.web.dominio.PersonaTitulo_;
import com.mycompany.module1.proyecto.web.dominio.Persona_;
import com.mycompany.module1.proyecto.web.dominio.Profesion;
import com.mycompany.module1.proyecto.web.dominio.Profesion_;
import com.mycompany.module1.proyecto.web.dominio.Titulo;
import com.mycompany.module1.proyecto.web.dominio.Titulo_;
import com.mycompany.module1.proyecto.web.dto.NameBasicsDTO;
import com.mycompany.module1.proyecto.web.dto.TitleBasicsDTO;
import com.mycompany.module1.proyecto.web.dto.TitleCrewDTO;
import com.mycompany.module1.proyecto.web.repositorio.PersonaRepositorio;
import com.mycompany.module1.proyecto.web.repositorio.PersonaTituloRepositorio;
import com.mycompany.module1.proyecto.web.repositorio.ProfesionRepositorio;
import com.mycompany.module1.proyecto.web.repositorio.TituloRepositorio;
import com.opencsv.bean.CsvToBeanBuilder;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Leticia Boch
 
@RequestScoped
public class MainClazz {

    @PersistenceContext
//    @Getter
    private EntityManager entityManager;

    @Transactional
    public void createTable3() {

        try {
            File nameBasicsInput = new File("F:\\name.basics.tsv\\data.tsv");
            File nameBasicsOutput = new File("F:\\name.basics.tsv\\name.basics.output.tsv");
            ArchivoControlador nameBasicArchivoControlador = new ArchivoControlador();

            nameBasicArchivoControlador.realizarLectura(nameBasicsInput);
            nameBasicArchivoControlador.exportarDatos(nameBasicsOutput);

            DTOParser dtoParser = new DTOParser();

            List<NameBasicsDTO> nameBasicDTOList1 = dtoParser.parse(NameBasicsDTO.class, nameBasicsOutput);
            System.out.println("dto print line");
            nameBasicDTOList1.stream().findFirst().ifPresent(System.out::println);

            PersonaRepositorio personaRepositorio = new PersonaRepositorio();
            PersonaDTOConverter personaDTOConverter = new PersonaDTOConverter();

            ProfesionRepositorio profesionRepositorio = new ProfesionRepositorio();
            ProfesionDTOConverter profesionDTOConverter = new ProfesionDTOConverter();
            List<Profesion> profesionList = this.buscarProfesiones();
            //List<Profesion> profesionList = profesionRepositorio.buscarProfesiones();

            nameBasicDTOList1.stream().forEach(dto -> {
                System.out.println("in profesionlist for each");
                List<Profesion> profesionDTOList = profesionDTOConverter.convertir(dto);//aqui estamos creando personas                
                Set<Profesion> personaProfesisonSet = new HashSet<>();

                profesionDTOList.stream().forEach(profesionNuevo -> {
                    profesionList.stream()
                            .filter(prof -> prof.getNombre()
                            .equalsIgnoreCase(profesionNuevo.getNombre()))
                            .findFirst()//could retun null
                            .ifPresentOrElse(prof -> {
                                personaProfesisonSet.add(prof);
                            }, () -> {
                                //profesionRepositorio.crearOActualizarProfesion(profesionNuevo);
                                this.crearOActualizarProfesion(profesionNuevo);
                                //profesionRepositorio.crearOActualizarProfesion(this.entityManager, profesionNuevo);
                                profesionList.add(profesionNuevo);
                                personaProfesisonSet.add(profesionNuevo);
                                System.out.println("ending profesion list");
                                System.out.println(profesionNuevo);
                            });

                });
                Persona persona = personaDTOConverter.convertir(dto);//aqui estamos creando personas
                persona.setProfesionSet(personaProfesisonSet);
                this.crearOActualizarPersona(persona);
                //personaRepositorio.crearOActualizarPersona(persona);
            });

        } catch (IOException e) {
            System.out.println("CATCH!!!!!!!!!!!!!");
            System.out.println(e.getMessage());

        } 
    }

    @Transactional
    public void createTable4() {
        System.out.println("create table 4");

        try {
            File titleBasicsInput = new File("F:\\title.basics.tsv\\data.tsv");
            File titleBasicsOutput = new File("F:\\title.basics.tsv\\title.basics.output.tsv");

            File titleCrewInput = new File("F:\\title.crew.tsv\\data.tsv");
            File titleCrewOutput = new File("F:\\title.crew.tsv\\title.crew.output.tsv");
            File titleCrewOutput1 = new File("F:\\title.crew.tsv\\title.crew.output1.tsv");

            ArchivoControlador titleBasicsArichvoControlador = new ArchivoControlador();
            titleBasicsArichvoControlador.realizarLectura(titleBasicsInput);
            titleBasicsArichvoControlador.exportarDatos(titleBasicsOutput);

            ArchivoControlador titleCrewArchivoControlador = new ArchivoControlador();
            titleCrewArchivoControlador.realizarLectura(titleCrewInput);
            titleCrewArchivoControlador.exportarDatos(titleCrewOutput);

            DTOParser dtoParser = new DTOParser();
            TituloDTOConverter tituloDTOConverter = new TituloDTOConverter();
            //TituloRepositorio tituloRepositorio = new TituloRepositorio(entityManager);
            TituloRepositorio tituloRepositorio = new TituloRepositorio();

            //PersonaRepositorio personaRepositorio = new PersonaRepositorio(entityManager);
            PersonaRepositorio personaRepositorio = new PersonaRepositorio();

            //PersonaTituloRepositorio personaTituloRepositorio = new PersonaTituloRepositorio(personaRepositorio);
            PersonaTituloRepositorio personaTituloRepositorio = new PersonaTituloRepositorio();

            //  entityManager.getTransaction().begin();
            List<TitleBasicsDTO> titleBasicsDTOList1 = dtoParser.parse(TitleBasicsDTO.class, titleBasicsOutput);
            titleBasicsDTOList1.stream().findFirst().ifPresent(System.out::println);
            System.out.println("End title basics DTO");
            
            titleBasicsDTOList1.stream().forEach(dto -> {
                Titulo titulo = tituloDTOConverter.convertir(dto);
                //tituloRepositorio.crearOrActualizarTitulo(titulo);
                this.crearOrActualizarTitulo(titulo);
            });

            List<TitleCrewDTO> titleCrewDTOList1 = dtoParser.parse(TitleCrewDTO.class, titleCrewOutput);
            List<TitleCrewDTO> titleCrewDTOList2 = dtoParser.parse(TitleCrewDTO.class, titleCrewOutput1);
            try ( Reader reader = new FileReader(titleCrewOutput)) {
                List<TitleCrewDTO> titleCrewDTOList = new CsvToBeanBuilder<TitleCrewDTO>(reader)
                        .withType(TitleCrewDTO.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .withSeparator('\t')
                        .build()
                        .parse();
                //nameBasicDTOList.stream().forEach(System.out::println);
                titleCrewDTOList.stream().findFirst().ifPresent(System.out::println);
                titleCrewDTOList1.stream().findFirst().ifPresent(System.out::println);
                titleCrewDTOList2.stream().findFirst().ifPresent(System.out::println);
            }
            titleCrewDTOList2.stream().forEach(dto -> {
                //Titulo titulo = tituloRepositorio.buscarTituloPorCodigo(dto.getTconst());
                Titulo titulo = this.buscarTituloPorCodigo(dto.getTconst());

                if (titulo != null) {

                    //personaTituloRepositorio.actualizarDirectores1(titulo, dto.directorsToArray());
                    personaTituloRepositorio.actualizarDirectores(titulo, dto.directorsToArray());
                    personaTituloRepositorio.actualizarEscritores(titulo, dto.directorsToArray());
                }
            });
//            titleCrewDTOList2.stream().forEach(dto -> {
//                //titleCrewDTOList1.stream().forEach(dto -> {
//                Titulo titulo = tituloRepositorio.buscarTituloPorCodigo(dto.getTconst());
//
//                if (titulo != null) {
//                    String[] directores = dto.directorsToArray();
//                    if (directores != null) {
//                        //Stream.of(directores).map(director -> personaRepositorio.buscarPersonaPorCodigo(director));
//                        List<Persona> directoresPersonaList = Stream.of(directores)
//                                .map(personaRepositorio::buscarPersonaPorCodigo)//could return null
//                                .filter(p -> p != null)
//                                .collect(Collectors.toList());
//                        directoresPersonaList.stream().forEach(director -> {
//
//                            boolean anyMatch = director.getPersonaTituloList()
//                                    .stream()
//                                    .anyMatch(pt -> pt.getTitulo().equals(titulo) && pt.getTipoRelacion() == PersonaTitulo.DIRECTORES);
//                            if (!anyMatch) {
//                                PersonaTitulo personaTitulo = new PersonaTitulo();
//                                personaTitulo.setPersonaId(director.getPersonaId());
//                                personaTitulo.setTituloId(titulo.getTituloId());
//                                personaTitulo.setTipoRelacion(PersonaTitulo.DIRECTORES);
//
//                                entityManager.persist(personaTitulo);
//
//                            }
//
//                        });
//                    }
//
//                    //personaTituloRepositorio.actualizarDirectores(titulo, dto.directorsToArray());                    
//                    //personaTituloRepositorio.actualizarEscritores(titulo, dto.writersToArray());
//                }
//            });
            //entityManager.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger("Main").log(Level.SEVERE, "Error", e);
            System.out.println(e.getMessage());
            System.out.println("catch 4");
            //entityManager.getTransaction().rollback();

        } 

    }

    @Transactional
    public void archivoPersona() {
        try {
            ArchivoControlador nameBasicArchivoControlador = new ArchivoControlador();
            //1
            File nameBasicsInput = new File("F:\\name.basics.tsv\\data.tsv");
            File nameBasicsOutput = new File("F:\\name.basics.tsv\\name.basics.output.tsv");

            nameBasicArchivoControlador.realizarLectura(nameBasicsInput);
            nameBasicArchivoControlador.exportarDatos(nameBasicsOutput);

            DTOParser dtoParser = new DTOParser();
            List<NameBasicsDTO> nameBasicDTOList1 = dtoParser.parse(NameBasicsDTO.class, nameBasicsOutput);

            nameBasicDTOList1.stream().findFirst().ifPresent(System.out::println);

            PersonaRepositorio personaRepositorio = new PersonaRepositorio();
            PersonaDTOConverter personaDTOConverter = new PersonaDTOConverter();

            nameBasicDTOList1.stream().forEach(dto -> {
                Persona persona = personaDTOConverter.convertir(dto);//aqui estamos creando personas
                personaRepositorio.crearOActualizarPersona(persona);
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Transactional
    public void createTable5(){


           try{
            File titleCrewOutput1 = new File("F:\\title.crew.tsv\\title.crew.output1.tsv");

           
            DTOParser dtoParser = new DTOParser();

            
            List<TitleCrewDTO> titleCrewDTOList = dtoParser.parse(TitleCrewDTO.class, titleCrewOutput1);

            //entityManager.getTransaction().begin();

            //----------------------
            PersonaRepositorio personaRepositorio = new PersonaRepositorio();

            
            //----------------------
            TituloRepositorio tituloRepositorio = new TituloRepositorio();
            
            PersonaTituloRepositorio personaTituloRepositorio = new PersonaTituloRepositorio();
            
            titleCrewDTOList.stream().forEach(dto -> {
                //Titulo titulo = tituloRepositorio.buscarTituloPorCodigo(dto.getTconst());
                Titulo titulo = this.buscarTituloPorCodigo(dto.getTconst());

                if (titulo != null) {
                    
                    //personaTituloRepositorio.actualizarDirectores(titulo, dto.directorsToArray());                    
                    this.actualizarDirectores1(titulo, dto.directorsToArray());                    
                    //personaTituloRepositorio.actualizarEscritores(titulo, dto.writersToArray());
                    this.actualizarEscritores(titulo, dto.writersToArray());

                }
            });

           }catch (IOException e){
           
           }


    
    }
    
    public List<Profesion> buscarProfesiones() {
        System.out.println("buscar profesiones");

        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        //var builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Profesion> profesionQuery = builder.createQuery(Profesion.class);

        profesionQuery.from(Profesion.class);
        System.out.println("ending method");

        return entityManager.createQuery(profesionQuery).getResultList(); //retorna nullo
        //return this.entityManager.createQuery(profesionQuery).getResultList(); //retorna nullo
    }

    
    public Profesion buscarProfesionPorNombre(String nombre) {
        var builder = this.entityManager.getCriteriaBuilder();
//        var builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Profesion> profesionQuery = builder.createQuery(Profesion.class);

        Root<Profesion> root = profesionQuery.from(Profesion.class);

        profesionQuery.where(
                builder.equal(root.get(Profesion_.nombre), nombre)
        );

        try {
            return this.entityManager.createQuery(profesionQuery).getSingleResult();
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
            this.entityManager.persist(profesionNuevo);
        } else {
            profesion.setDescripcion(profesionNuevo.getDescripcion());
            //profesion.setModificadoEl(LocalDateTime.now());
            this.entityManager.merge(profesion);
            //entityManager.merge(profesion);
        }
    }
    
    //////////////////////
    
        public List<Persona> getPersonaList() {

        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Persona> query = builder.createQuery(Persona.class);

        query.from(Persona.class);

        return this.entityManager.createQuery(query).getResultList();

    }

    public Persona buscarPersonaPorCodigo(String codigo) {


        var builder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Persona> personaQuery = builder.createQuery(Persona.class);

        Root<Persona> root = personaQuery.from(Persona.class);

        personaQuery.where(
                builder.equal(root.get(Persona_.codigo), codigo)
        );

        try {

            return this.entityManager.createQuery(personaQuery).getSingleResult();
            
        } catch (NoResultException ex) {

        }
        return null;

    }

    @Transactional
    public void crearOActualizarPersona(Persona personaNuevo) {

        Persona persona = this.buscarPersonaPorCodigo(personaNuevo.getCodigo());

        if (persona == null) {

            this.entityManager.persist(personaNuevo);

        } else {

            persona.setNombre(personaNuevo.getNombre());
            persona.setAnyoNacimiento(personaNuevo.getAnyoNacimiento());
            persona.setAnyoFallecimiento(personaNuevo.getAnyoFallecimiento());
            persona.setProfesionSet(personaNuevo.getProfesionSet());

            this.entityManager.merge(persona);            

        }

    }
    
    
        @Transactional
    private void actualizar(Titulo titulo, String[] codigos, int tipoRelacion) {
        //aquí tendríamos que eliminar todos los registros de persona_titulo donde el titulo sea igual al que estamos procesando
        var builder = this.entityManager.getCriteriaBuilder();

        CriteriaDelete<PersonaTitulo> query = builder.createCriteriaDelete(PersonaTitulo.class);

        Root<PersonaTitulo> root = query.from(PersonaTitulo.class);

        query.where(
                builder.equal(root.get(PersonaTitulo_.titulo), titulo),
                builder.equal(root.get(PersonaTitulo_.tipoRelacion), tipoRelacion)
        );

        this.entityManager.createQuery(query).executeUpdate();

        if (codigos != null) {

            List<Persona> directoresPersonaList = Stream.of(codigos)
                    //.map(personaRepositorio::buscarPersonaPorCodigo)
                    .map(this::buscarPersonaPorCodigo)
                    .filter(p -> p != null)
                    .collect(Collectors.toList());

            directoresPersonaList.stream().forEach(director -> {

                PersonaTitulo personaTitulo = new PersonaTitulo();
                personaTitulo.setPersonaId(director.getPersonaId());
                personaTitulo.setTituloId(titulo.getTituloId());
                personaTitulo.setTipoRelacion(tipoRelacion);

                entityManager.persist(personaTitulo);
            });

        }

    }
    
        public void actualizarDirectores(Titulo titulo, String[] codigos) {
        this.actualizar(titulo, codigos, PersonaTitulo.DIRECTORES);
    }

    public void actualizarEscritores(Titulo titulo, String[] codigos) {
        this.actualizar(titulo, codigos, PersonaTitulo.ESCRITORES);
    }
    @Transactional
    public void actualizarDirectores1(Titulo titulo, String[] codigos) {
        //aquí tendríamos que eliminar todos los registros de persona_titulo donde el titulo sea igual al que estamos procesando
        var builder = this.entityManager.getCriteriaBuilder();

        CriteriaDelete<PersonaTitulo> query = builder.createCriteriaDelete(PersonaTitulo.class);

        Root<PersonaTitulo> root = query.from(PersonaTitulo.class);

        query.where(
                builder.equal(root.get(PersonaTitulo_.titulo), titulo),
                builder.equal(root.get(PersonaTitulo_.tipoRelacion), PersonaTitulo.DIRECTORES)
        );

        this.entityManager.createQuery(query).executeUpdate();

        if (codigos != null) {

            List<Persona> directoresPersonaList = Stream.of(codigos)
                    //.map(personaRepositorio::buscarPersonaPorCodigo)
                    .map(this::buscarPersonaPorCodigo)
                    .filter(p -> p != null)
                    .collect(Collectors.toList());

            directoresPersonaList.stream().forEach(director -> {

                PersonaTitulo personaTitulo = new PersonaTitulo();
                personaTitulo.setPersonaId(director.getPersonaId());
                personaTitulo.setTituloId(titulo.getTituloId());
                personaTitulo.setTipoRelacion(PersonaTitulo.DIRECTORES);

                entityManager.persist(personaTitulo);
            });

        }
    }
    
    //////////////////////////////
    
    public List<Titulo> getTituloList() {

        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Titulo> query = builder.createQuery(Titulo.class);

        query.from(Titulo.class);

        return this.entityManager.createQuery(query).getResultList();

    }

    
    public Titulo buscarTituloPorCodigo(String codigo) {

        var builder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Titulo> profesionQuery = builder.createQuery(Titulo.class);

        Root<Titulo> root = profesionQuery.from(Titulo.class);

        profesionQuery.where(
                builder.equal(root.get(Titulo_.codigo), codigo)
        );

        try {
            return this.entityManager.createQuery(profesionQuery).getSingleResult();
        } catch (NoResultException ex) {

        }
        return null;
    }

    @Transactional
    public void crearOrActualizarTitulo(Titulo tituloNuevo) {

        System.out.println("CREATE NEW TITLE" );
        Titulo titulo = this.buscarTituloPorCodigo(tituloNuevo.getCodigo());

        if (titulo == null) {
            System.out.println("ABOUT TO PERSIST" );
            this.entityManager.persist(tituloNuevo);
            System.out.println("!!!!!!1" + tituloNuevo);
        } else {
            System.out.println("ABOUT TO MERGE" );
            titulo.setAnyoFin(tituloNuevo.getAnyoFin());
            titulo.setAnyoInicio(tituloNuevo.getAnyoInicio());
            titulo.setNombre(tituloNuevo.getNombre());
            titulo.setNombreOriginal(tituloNuevo.getNombreOriginal());
            titulo.setParaAdultos(tituloNuevo.isParaAdultos());
            titulo.setTiempo(tituloNuevo.getTiempo());
            this.entityManager.merge(titulo);
        }
    }


}

        */
        
    
}
