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
public class TitleBasicsDTO {
    
    @CsvBindByName
    private String tconst;
    
    @CsvBindByName
    private String titleType;
    
    @CsvBindByName
    private String primaryTitle;
    
    @CsvBindByName
    private String originalTitle;
    
    @CsvBindByName
    private String isAdult;
    
    @CsvBindByName
    private String startYear;
    
    @CsvBindByName
    private String endYear;
    
    @CsvBindByName
    private String runtimeMinutes;
    
    @CsvBindByName
    private String genres;
}
