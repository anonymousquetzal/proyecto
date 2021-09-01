/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.module1.proyecto.web.controller;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;

/**
 *
 * @author Leticia Boch
 */
public class DTOParser {
    
    private InputStream getInputStream(InputStream in) throws IOException {

            PushbackInputStream testin = new PushbackInputStream(in);
            int ch = testin.read();
            if (ch != 0xEF) {
                testin.unread(ch);
            } else if ((ch = testin.read()) != 0xBB) {
                testin.unread(ch);
                testin.unread(0xef);
            } else if (testin.read() != 0xBF) {
                throw new IOException("Bad UTF-8 format file");
            } else {
            }
            return testin;
        }

        public <T> List<T> parse(Class<T> clazz, File input) throws IOException {

            try ( FileInputStream bais = new FileInputStream(input)) {
                try ( Reader reader = new InputStreamReader(this.getInputStream(bais), Charset.forName("UTF-8"))) {
                    return new CsvToBeanBuilder<T>(reader)
                            .withType(clazz)
                            .withIgnoreLeadingWhiteSpace(true)
                            .withSeparator('\t')
                            .build()
                            .parse();
                }
            }

        }
    
}
