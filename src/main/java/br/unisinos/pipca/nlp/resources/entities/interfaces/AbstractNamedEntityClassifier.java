/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.unisinos.pipca.nlp.resources.entities.interfaces;

import br.unisinos.pipca.nlp.resources.entities.NEREntity;
import java.util.List;

/**
 *
 * @author Allan de Barcelos Silva
 */
public abstract class AbstractNamedEntityClassifier<T> {
    protected T model;
    
    public AbstractNamedEntityClassifier(String modelpath) {
        model = loadModel(modelpath);
    }
    
    public abstract T loadModel(String path);
    
    public abstract List<NEREntity> findEntities(String text);
    
    public abstract List<NEREntity> findEntities(String[] tokens);
}
