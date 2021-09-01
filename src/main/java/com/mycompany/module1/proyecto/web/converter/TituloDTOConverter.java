/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.converter;

import com.mycompany.module1.proyecto.web.dominio.Titulo;
import com.mycompany.module1.proyecto.web.dto.TitleBasicsDTO;
import java.util.Optional;

/**
 *
 * @author Leticia Boch
 */
public class TituloDTOConverter implements Converter<Titulo, TitleBasicsDTO> {

    @Override
    public Titulo convertir(TitleBasicsDTO dto) {
        System.out.println("in convertir title");
               
        
        Titulo titulo = new Titulo();
        titulo.setCodigo(dto.getTconst());
        titulo.setNombre(dto.getPrimaryTitle());
        titulo.setNombreOriginal(dto.getOriginalTitle());
        
        /*
        if (dto.getIsAdult() != null) {
            
            int isAdult = Integer.valueOf(dto.getIsAdult());
            
            boolean paraAdultos = isAdult == 1;
                        
            titulo.setParaAdultos(paraAdultos);
            
        } else {
            
            titulo.setParaAdultos(false);
        } */
             
        
        Optional.ofNullable(dto.getIsAdult())
                .map(Integer::valueOf)//Integer.valueOf
                .map(paraAdultos -> paraAdultos == 1) //if 
                .ifPresentOrElse(titulo::setParaAdultos, () -> titulo.setParaAdultos(false));//java 9
        
        Optional.ofNullable(this.convertirValor(dto.getRuntimeMinutes()))
                .map(Integer::valueOf)
                .ifPresent(titulo::setTiempo);
        
        
        titulo.setAnyoFin(this.convertirValor(dto.getEndYear()));
        
        titulo.setAnyoInicio(this.convertirValor(dto.getStartYear()));
        System.out.println("returning titulo");
        System.out.println(titulo.getNombre());
        
        return titulo;
    }
    
}
