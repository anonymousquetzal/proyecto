/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.converter;

import com.mycompany.module1.proyecto.web.dominio.Persona;

import com.mycompany.module1.proyecto.web.dto.NameBasicsDTO;

/**
 *
 * @author Leticia Boch
 */
public class PersonaDTOConverter implements Converter<Persona, NameBasicsDTO> {

    
//    private String convertirAnyo(String year) {
//        if (year.equalsIgnoreCase("N")) {
//            return null;
//        }
//        return year;
//
//    }

    /**
     *
     * @param dto
     * @return
     */
    @Override
    public Persona convertir(NameBasicsDTO dto) {
        System.out.println("converter!!!!!!!!!");
        Persona persona = new Persona();

        persona.setCodigo(dto.getNconst());
        persona.setNombre(dto.getPrimaryName());

        persona.setAnyoNacimiento(this.convertirValor(dto.getBirthYear()));

        persona.setAnyoFallecimiento(this.convertirValor(dto.getDeathYear()));

        return persona;
    }

}
