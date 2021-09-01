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
 * titleId	ordering	title	region	language	types	attributes	isOriginalTitle
 */
@Getter
@Setter
@ToString
public class TitleAkasDTO {
    
    @CsvBindByName
    private String titleId;

    @CsvBindByName
    private String ordering;

    @CsvBindByName
    private String title;
    
    @CsvBindByName
    private String region;
    
    @CsvBindByName
    private String language;
    
    @CsvBindByName
    private String types;
    
    @CsvBindByName
    private String attributes;
    
    @CsvBindByName
    private String isOriginalTitle;
    
    
}
