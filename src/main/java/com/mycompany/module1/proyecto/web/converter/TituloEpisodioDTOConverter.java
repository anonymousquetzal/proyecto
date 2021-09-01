/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.converter;

import com.mycompany.module1.proyecto.web.dominio.TitleEpisode;
import com.mycompany.module1.proyecto.web.dto.TitleEpisodeDTO;
import java.util.List;

/**
 *
 * @author Leticia Boch
 */
public class TituloEpisodioDTOConverter implements Converter<TitleEpisode, TitleEpisodeDTO>{

    @Override
    public TitleEpisode convertir(TitleEpisodeDTO dto) {
        
        TitleEpisode titleEpisode = new TitleEpisode();
     
        titleEpisode.setTituloId(this.convertirValor(dto.getTconst()));
        titleEpisode.setParentId(this.convertirValor(dto.getParentTconst()));
        titleEpisode.setNumeroTemporada(this.convertirValor(dto.getSeasonNumber()));
        titleEpisode.setNumeroEpisodio(this.convertirValor(dto.getEpisodeNumber()));
        
        return titleEpisode;
    }
    
}
