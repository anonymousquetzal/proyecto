/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.controller;


import com.mycompany.module1.proyecto.web.dominio.Persona;
import com.mycompany.module1.proyecto.web.controller.MainClazz;
import com.mycompany.module1.proyecto.web.dominio.TitleEpisode;
import com.mycompany.module1.proyecto.web.dominio.TitlePrincipals;
import com.mycompany.module1.proyecto.web.dominio.Titulo;
import com.mycompany.module1.proyecto.web.dominio.TituloSinonimo;
import com.mycompany.module1.proyecto.web.repositorio.AkasRepositorio;
import com.mycompany.module1.proyecto.web.repositorio.PersonaRepositorio;
import com.mycompany.module1.proyecto.web.repositorio.ProfesionRepositorio;
import com.mycompany.module1.proyecto.web.repositorio.TitlePrincipalsRepositorio;
import com.mycompany.module1.proyecto.web.repositorio.TituloEpisodioRepositorio;
import com.mycompany.module1.proyecto.web.repositorio.TituloRepositorio;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.extern.java.Log;




@Named
@ViewScoped //controller
@Log
public class ManageBean implements Serializable{
    
    @Inject
    private PersonaRepositorio personaRepositorio;
    
    @Inject
    private ProfesionRepositorio profesionRepositorio;
    
    @Inject
    private TituloRepositorio tituloRepositorio;
    
    @Inject
    private AkasRepositorio akasRepositorio;
    
    @Inject
    private TitlePrincipalsRepositorio tituloPrincipalsRepositorio;
    
    @Inject
    private TituloEpisodioRepositorio tituloEpisodioRepositorio;
    
    @Inject
    private MainClazz mainClazz;

    @Getter
    private List<Persona> personaList;
    
    @Getter
    private List<Titulo> tituloList;
    
    @Getter
    private List<TituloSinonimo> tituloSinonimoList;
    
    @Getter
    private List<TitlePrincipals> tituloPrincipalsList;
    
    @Getter
    private List<TitleEpisode> tituloEpisodioList;

    @Getter
    private Persona persona;
    
    @Getter
    private Titulo titulo;
    
    @Getter
    private TituloSinonimo tituloSinonimo;
    
    @Getter
    private TitlePrincipals tituloPrincipals;
    
    @Getter
    private TitleEpisode tituloEpisode;

    @PostConstruct
    public void init() {
        
        //this.loadArchivo();
        
        this.mainClazz.createNameBasicsTable3();
        this.mainClazz.createTitleBasicTable4();
        //this.mainClazz.createTitleAkasTable();
        this.mainClazz.createTitlePrincipalsTable();
        this.mainClazz.createTituloEpisodioTable();
        //this.mainClazz.archivoPersona();

        //this.personaList = this.mainClazz.findPersona();
        this.personaList = this.personaRepositorio.getPersonaList();
        this.tituloList = this.tituloRepositorio.getTituloList();
        this.tituloPrincipalsList = this.tituloPrincipalsRepositorio.buscarTitlePrincipals();
        this.tituloEpisodioList = this.tituloEpisodioRepositorio.buscarTitleEpisode();
        //this.tituloSinonimoList = this.akasRepositorio.buscarTituloSinonimo();
        //this.personaList = this.personaRepositorio.findPersona(mainClazz.getEntityManager());

        this.persona = new Persona();
        this.titulo = new Titulo();

    }
    
    public void loadArchivo(){
        //this.mainClazz.createTable3(entityManager);
    
    }

//    public void crearUsuario() {
//        try {
//
//            this.usuarioService.crearUsuario(this.usuario);
//
//            this.init();
//
//            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Usuario creado satisfactoriamente.");
//            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
//        } catch (Exception ex) {
//
//            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage());
//            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
//                        
//            log.log(Level.SEVERE, "Error", ex);
//
//        }
//    }
    
}
