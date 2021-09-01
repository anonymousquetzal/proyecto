/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.converter;


import com.mycompany.module1.proyecto.web.dominio.Profesion;
import com.mycompany.module1.proyecto.web.dto.NameBasicsDTO;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Leticia Boch
 */
public class ProfesionDTOConverter implements Converter<List<Profesion>, NameBasicsDTO>{



    @Override
    public List<Profesion> convertir(NameBasicsDTO dto) {

        List<Profesion> profesionList = Stream.of(dto.getPrimaryProfession().split(","))
                .map(name -> {
                    Profesion profesion = new Profesion();
                    profesion.setNombre(name);

                    return profesion;
                    }).collect(Collectors.toList());
        System.out.println("profesion List");
        System.out.println(profesionList);

        return profesionList;
    }

    public Profesion convertir2(NameBasicsDTO dto) {
        Profesion profesion = new Profesion();

        profesion.setNombre(dto.getPrimaryProfession());

        return profesion;
    }
}
