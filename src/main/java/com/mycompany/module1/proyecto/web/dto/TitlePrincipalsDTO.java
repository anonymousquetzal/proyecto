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

public class TitlePrincipalsDTO {
    
    @CsvBindByName
    private String tconst;

    @CsvBindByName
    private String ordering;

    @CsvBindByName
    private String nconst;
    
    @CsvBindByName
    private String category;
    
    @CsvBindByName
    private String job;
    
    @CsvBindByName
    private String characters;
}
