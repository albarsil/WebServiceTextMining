/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.unisinos.pipca.nlp.resources;

import br.unisinos.pipca.nlp.resources.entities.Triple;
import br.unisinos.pipca.nlp.resources.entities.SimilaritySemJson;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * 
 */
public class LexicalSemanticData{
    private List<Triple> triples;
    
    public LexicalSemanticData(String triplespath) {
        this.triples = load(triplespath);
        
        if(triples == null)
            throw new NullPointerException();
    }
    
    private List<Triple> load(String path){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
            List<Triple> triples = new ArrayList<>();
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] triple = line.split(",");
                triples.add(new Triple(triple[0], triple[1], triple[2]));
            }
            br.close();
            return triples;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String[] getTargets(String word, String relation){
        return triples.stream().
                filter(t -> t.getFrom().equals(word)).
                filter(t -> t.getRelation().equals(relation)).
                map(t -> t.getTarget()).
                toArray(String[]::new);
        
    }
    
    public List<Triple> getRelationsAndTargets(String word){
        return triples.stream().
                filter(t -> t.getFrom().equals(word)).
                collect(Collectors.toList());
    }
    
}
