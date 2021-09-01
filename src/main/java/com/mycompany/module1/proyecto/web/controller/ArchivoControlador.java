/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Leticia Boch
 */
public class ArchivoControlador {
    
private static final int MAX = 10;

        private int intLine = 0;

        private final StringBuilder stringBuilder;

        public ArchivoControlador() {
            this.stringBuilder = new StringBuilder();
        }

        public boolean esLineaValidaDeLectura() {
            return intLine <= MAX;
        }

        private void sumarLinea() {
            this.intLine++;
        }

        private void agregarLinea(String linea) {
            this.stringBuilder.append(linea).append("\n");
            this.sumarLinea();
        }

        public void exportarDatos(File path) throws IOException {

            try ( FileOutputStream outputStream = new FileOutputStream(path)) {
                outputStream.write(this.stringBuilder.toString().getBytes());
            }
        }

        // lee el archivo
        public void realizarLectura(File input) throws IOException {
            try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {

                bufferedReader
                        .lines()
                        .takeWhile(p -> this.esLineaValidaDeLectura())//jave 11
                        .forEach(this::agregarLinea); //line++

            }
            //System.out.println(this.stringBuilder.toString());
        }
    }

