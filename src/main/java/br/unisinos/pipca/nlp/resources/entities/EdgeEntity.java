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
public class EdgeEntity {
    private String label;
    private int type;
    private double weight;
    private boolean directed;

    public EdgeEntity(String label, int type, double weight, boolean directed) {
        this.label = label;
        this.type = type;
        this.weight = weight;
        this.directed = directed;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }
    
    
}
