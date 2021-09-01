/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.converter;

import com.mycompany.module1.proyecto.web.dominio.TitlePrincipals;
import com.mycompany.module1.proyecto.web.dto.TitlePrincipalsDTO;

/**
 *
 * @author Leticia Boch
 */
public class TitlePrincipalsDTOConverter implements Converter<TitlePrincipals, TitlePrincipalsDTO>{

    @Override
    public TitlePrincipals convertir(TitlePrincipalsDTO dto) {
        TitlePrincipals titlePrincipals = new TitlePrincipals();
        titlePrincipals.setTituloId(dto.getTconst());
        titlePrincipals.setLinea(dto.getOrdering());
        titlePrincipals.setPersonaId(dto.getNconst());
        titlePrincipals.setCategoria(dto.getCategory());
        titlePrincipals.setProfesion(this.convertirValor(dto.getJob()));
        titlePrincipals.setPersonaje(this.convertirValor(dto.getCharacters()));
        
        return titlePrincipals;
        
    }
    
}
