    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.converter;

/**
 *
 * @author Leticia Boch
 */
public interface Converter<T, D> {

    T convertir(D d);    
    
    default String convertirValor(String valor) {//java 7
        
        if (valor == null || valor.equalsIgnoreCase("N")) {
            return null;
        }

        return valor;
    }

}
