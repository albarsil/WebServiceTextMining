/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.unisinos.pipca.nlp.resources.entities;

/**
 *
 * @author Allan de Barcelos Silva
 */
public class NERModelRequest {
    
    private String text;

    public NERModelRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }  
    
}