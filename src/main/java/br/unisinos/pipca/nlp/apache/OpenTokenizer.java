/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.unisinos.pipca.nlp.apache;

import java.io.InputStream;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 *
 * @author Allan de Barcelos Silva
 */
public class OpenTokenizer {
    private static TokenizerME model;
    
    public OpenTokenizer(String path) {
        if(model == null)
            model = loadModel(path);
        else
            throw new NullPointerException();
    }
    
    public static TokenizerME loadModel(String path){
        try{
            FileSystemResource resource = new FileSystemResource(path);
            InputStream inputModelTokenizer = resource.getInputStream();
            TokenizerModel modelTokenizer = new TokenizerModel(inputModelTokenizer);
            TokenizerME tokenizer = new TokenizerME(modelTokenizer);
            return tokenizer;
        }catch(Exception e){
            e.printStackTrace();
            throw new NullPointerException();
        }
    }
    
    public String[] tokenize(String sentence){
        return model.tokenize(sentence);
    }
}
