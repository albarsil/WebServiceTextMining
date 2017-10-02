/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisinos.pipca.nlp.resources.entities;

import java.util.List;

/**
 *
 * @author Allan de Barcelos Silva
 */
public class NERResponse {
    private List<List<String>> entities;

    public NERResponse() {
    }

    public List<List<String>> getEntities() {
        return entities;
    }

    public void setEntities(List<List<String>> entities) {
        this.entities = entities;
    }
    
}
