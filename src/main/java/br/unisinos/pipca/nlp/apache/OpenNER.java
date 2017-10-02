/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.unisinos.pipca.nlp.apache;

import br.unisinos.pipca.nlp.resources.entities.NEREntity;
import br.unisinos.pipca.nlp.resources.entities.interfaces.AbstractNamedEntityClassifier;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;
import org.springframework.core.io.FileSystemResource;

/**
 *
 * @author Allan de Barcelos Silva
 */
public class OpenNER extends AbstractNamedEntityClassifier<NameFinderME>{
    
    public OpenNER(String modelpath) {
        super(modelpath);
    }
    
    @Override
    public NameFinderME loadModel(String path) {
        try{
            FileSystemResource resource = new FileSystemResource(path);
            InputStream inputModelNER = resource.getInputStream();
            TokenNameFinderModel modelNER = new TokenNameFinderModel(inputModelNER);
            NameFinderME nameFinder = new NameFinderME(modelNER);
            return nameFinder;
        }catch(Exception e){
            throw new NullPointerException();
        }
    }
    
    @Override
    public List<NEREntity> findEntities(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<NEREntity> findEntities(String[] tokens) {
        Span[] nameSpans = model.find(tokens);
        model.clearAdaptiveData();
        
        List<NEREntity> entities = new ArrayList<NEREntity>();
        for(Span sp : nameSpans){
            System.out.println(sp.getType());
            entities.add(new NEREntity(tokens[sp.getStart()], sp.getProb(), sp.getType()));
        }
        
        return entities;
    }
}