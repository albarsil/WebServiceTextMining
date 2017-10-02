/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisinos.pipca.nlp.resources.entities;

import br.unisinos.pipca.nlp.utils.TripeCSV;

/**
 *
 * @author Allan de Barcelos Silva
 */
public class TePEntry extends TripeCSV{   
    
    public TePEntry(String from, String relation, String target) {
        super(from, relation, target);
    }
    
}
