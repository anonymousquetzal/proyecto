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
 * tconst	parentTconst	seasonNumber	episodeNumber
 */

@Getter
@Setter
@ToString
public class TitleEpisodeDTO {
    
    @CsvBindByName
    private String tconst;

    @CsvBindByName
    private String parentTconst;

    @CsvBindByName
    private String seasonNumber;
    
    @CsvBindByName
    private String episodeNumber;
       
    
}
