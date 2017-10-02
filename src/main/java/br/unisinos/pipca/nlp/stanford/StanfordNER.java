/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.unisinos.pipca.nlp.stanford;

import br.unisinos.pipca.nlp.resources.entities.NEREntity;
import br.unisinos.pipca.nlp.resources.entities.interfaces.AbstractNamedEntityClassifier;
import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreAnnotations.AnswerAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Allan de Barcelos Silva
 */
public class StanfordNER extends AbstractNamedEntityClassifier<AbstractSequenceClassifier<CoreLabel>>{

    public StanfordNER(String modelpath) {
        super(modelpath);
    }

    @Override
    public AbstractSequenceClassifier<CoreLabel> loadModel(String path) {
        return CRFClassifier.getClassifierNoExceptions(path);
    }

    @Override
    public List<NEREntity> findEntities(String text){
        List<List<CoreLabel>> out = model.classify(text);
        List<NEREntity> entities = new ArrayList<>();
        for (List<CoreLabel> sentence : out) {
          for (CoreLabel word : sentence) {
              entities.add(new NEREntity(word.word(), -1, word.get(AnswerAnnotation.class)));
          }
          System.out.println();
        }
        
        return entities;
    }

    @Override
    public List<NEREntity> findEntities(String[] tokens) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
