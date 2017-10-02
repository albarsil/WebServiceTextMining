/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisinos.pipca.nlp.utils;

/**
 *
 * @author Allan de Barcelos Silva
 */
public class TripeCSV {
    
    private String from;
    private String relation;
    private String target;

    public TripeCSV(String from, String relation, String target) {
        this.from = from;
        this.relation = relation;
        this.target = target;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
