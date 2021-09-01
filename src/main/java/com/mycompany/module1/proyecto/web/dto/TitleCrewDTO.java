/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 *
 * @author Leticia Boch
 */
@Getter
@Setter
@ToString
public class TitleCrewDTO {
    
    @CsvBindByName
    private String tconst;

    @CsvBindByName
    private String directors;

    @CsvBindByName
    private String writers;

    private String[] toArray(String valor) {
        if (valor.equalsIgnoreCase("N")) {
            return null;
        }

        return valor.split(",");
    }

    public String[] directorsToArray() {
        return this.toArray(this.directors);
    }

    public String[] writersToArray() {
        return this.toArray(this.writers);
    }


}
