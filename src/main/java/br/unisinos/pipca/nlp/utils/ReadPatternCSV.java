/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.unisinos.pipca.nlp.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Allan de Barcelos Silva
 */
public final class ReadPatternCSV {
    
    public static List<TripeCSV> read(String path) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
        List<TripeCSV> triples = new ArrayList<TripeCSV>();
        
        String line;
        while ((line = br.readLine()) != null) {
            String[] parameters = line.split(";");
            triples.add(new TripeCSV(parameters[0], parameters[1], parameters[2]));
        }
        
        br.close();
        return triples;
    }
}
