/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.converter;

import com.mycompany.module1.proyecto.web.dominio.TituloSinonimo;
import com.mycompany.module1.proyecto.web.dto.TitleAkasDTO;
import java.util.Optional;

/**
 *
 * @author Leticia Boch
 */
public class TituloSinonimoDTOConverter implements Converter<TituloSinonimo, TitleAkasDTO>{

    @Override
    public TituloSinonimo convertir(TitleAkasDTO dto) {
        TituloSinonimo tituloSinonimo = new TituloSinonimo();
        tituloSinonimo.setTituloId(dto.getTitleId());
        tituloSinonimo.setLinea(dto.getOrdering());
        tituloSinonimo.setNombre(dto.getTitle());
        tituloSinonimo.setRegion(this.convertirValor(dto.getRegion()));
        tituloSinonimo.setLanguage(this.convertirValor(dto.getLanguage()));
        tituloSinonimo.setTipos(this.convertirValor(dto.getTypes()));
        tituloSinonimo.setAtributos(this.convertirValor(dto.getAttributes()));
        Optional.ofNullable(dto.getIsOriginalTitle())
                .map(Integer::valueOf)//Integer.valueOf
                .map(isOriginalTitle -> isOriginalTitle == 1) //if 
                .ifPresentOrElse(tituloSinonimo::setOriginal, () -> tituloSinonimo.setOriginal(false));
        return tituloSinonimo;
    }
    
}
