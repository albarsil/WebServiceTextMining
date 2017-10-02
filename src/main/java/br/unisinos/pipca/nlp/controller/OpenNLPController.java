/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisinos.pipca.nlp.controller;

import br.unisinos.pipca.nlp.apache.OpenChunker;
import br.unisinos.pipca.nlp.apache.OpenNER;
import br.unisinos.pipca.nlp.apache.OpenTokenizer;
import br.unisinos.pipca.nlp.resources.entities.NEREntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;


import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.IOException; 
import java.io.InputStream;  

import opennlp.tools.chunker.ChunkerME; 
import opennlp.tools.chunker.ChunkerModel; 
import opennlp.tools.cmdline.postag.POSModelLoader; 
import opennlp.tools.postag.POSModel; 
import opennlp.tools.postag.POSTaggerME; 
import opennlp.tools.tokenize.WhitespaceTokenizer; 
import opennlp.tools.util.Span;  

@EnableAutoConfiguration
@RestController
@RequestMapping("/nlp/apache")
public class OpenNLPController {
    private OpenNER ner = new OpenNER("WEB-INF/OpenNLP/iterations/pt-ner-cat-iterations_170.bin");
    private OpenTokenizer tokenizer = new OpenTokenizer("WEB-INF/OpenNLP/pt-token.bin");
    private OpenChunker chunker = new OpenChunker("WEB-INF/OpenNLP/pt-sent.bin");
    
    @RequestMapping(value = "/ner", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public String processNamedEntity(@RequestBody String json) {
        String request = new Gson().fromJson(json, String.class);       
        String[] sentences = chunker.detectSentences(request);
        ArrayList<NEREntity> entities = new ArrayList<NEREntity>();
        
        for(String s : sentences){
            entities.addAll(ner.findEntities(tokenizer.tokenize(s)));
        }
        
        return new Gson().toJson(entities);
    }
    
    @RequestMapping(value = "/Hello", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public String greeting(@RequestBody String json) throws FileNotFoundException, IOException {
      //Load the parts of speech model 
      File file = new File("WEB-INF/OpenNLP/pt-pos-maxent.bin");     
      POSModel model = new POSModelLoader().load(file); 
       
      //Constructing the tagger 
      POSTaggerME tagger = new POSTaggerME(model); 
  
      //Tokenizing the sentence        
      String sentence = new Gson().fromJson(json, String.class);
      WhitespaceTokenizer whitespaceTokenizer= WhitespaceTokenizer.INSTANCE; 
      String[] tokens = whitespaceTokenizer.tokenize(sentence); 
       
      //Generating tags from the tokens 
      String[] tags = tagger.tag(tokens);       
   
      //Loading the chunker model 
      InputStream inputStream = new FileInputStream("WEB-INF/OpenNLP/chunker/en-chunker.bin"); 
      ChunkerModel chunkerModel = new ChunkerModel(inputStream);
      ChunkerME chunkerME = new ChunkerME(chunkerModel);       
           
      //Generating the tagged chunk spans 
      Span[] span = chunkerME.chunkAsSpans(tokens, tags); 
       
      for (Span s : span) 
         System.out.println(s.toString());  
       
      return new Gson().toJson(tags);
    }
}
