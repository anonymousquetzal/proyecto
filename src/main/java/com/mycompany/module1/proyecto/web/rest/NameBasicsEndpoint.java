/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.rest;


import com.mycompany.module1.proyecto.web.dominio.Persona;
import com.mycompany.module1.proyecto.web.repositorio.PersonaRepositorio;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;


/**
 *
 * @author k0co8
 */
@Path("/name-basics")
public class NameBasicsEndpoint {
    @Inject
    private PersonaRepositorio personaRepositorio;
   
   // private List<Clientes> clientesList;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //public Response findUsuarios() {
    public List<Persona> findPersonaList() {
        //var usuarioList = this.usuarioService.findUsuarios();
        //return Response.ok(usuarioList).build();
        //var clientesList = this.personaRepositorio.getPersonaList();
        //return Response.ok(clientesList).build();
        return this.personaRepositorio.getPersonaList();
        
    }
    
}
