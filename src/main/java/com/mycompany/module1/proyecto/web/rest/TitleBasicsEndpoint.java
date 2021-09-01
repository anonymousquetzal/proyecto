/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.rest;

import com.mycompany.module1.proyecto.web.dominio.Titulo;
import com.mycompany.module1.proyecto.web.repositorio.TituloRepositorio;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 */
@Path("/title-basics")
public class TitleBasicsEndpoint {

    @Inject
    private TituloRepositorio titleRepositorio;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Titulo> findTituloListEndpoint() {

        return this.titleRepositorio.getTituloList();

    }

}
