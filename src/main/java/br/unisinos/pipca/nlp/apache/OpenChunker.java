/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.unisinos.pipca.nlp.apache;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.InputStream;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import org.springframework.core.io.FileSystemResource;


/**
 * @author Allan de Barcelos Silva
 */
public class OpenChunker {
    
    private static SentenceDetectorME model;
    
    public OpenChunker(String path) {
        if(model == null)
            model = loadModel(path);
        else
            throw new NullPointerException();
    }
    
    public static SentenceDetectorME loadModel(String path){
        try{
            FileSystemResource resource = new FileSystemResource(path);
            InputStream inputModelSentence = resource.getInputStream();
            SentenceModel modelSentence = new SentenceModel(inputModelSentence);
            SentenceDetectorME sentenceDetector = new SentenceDetectorME(modelSentence);
            
            return sentenceDetector;
        }catch(Exception e){
            e.printStackTrace();
            throw new NullPointerException();
        }
    }
    
    public String[] detectSentences(String text){
        return model.sentDetect(text);
    }
}
