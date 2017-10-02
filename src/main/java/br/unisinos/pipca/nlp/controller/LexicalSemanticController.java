package br.unisinos.pipca.nlp.controller;

import br.unisinos.pipca.nlp.main.Greeting;
import br.unisinos.pipca.nlp.main.Greeting;
import br.unisinos.pipca.nlp.main.Hello;
import br.unisinos.pipca.nlp.resources.LexicalSemanticData;
import br.unisinos.pipca.nlp.resources.entities.Triple;
import br.unisinos.pipca.nlp.resources.entities.SimilaritySemJson;
import com.github.rcaller.rstuff.RCaller;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.rcaller.rstuff.RCaller;
import com.github.rcaller.rstuff.RCode;
import com.google.gson.JsonElement;


//@EnableAutoConfiguration
@RestController
@RequestMapping("/nlp/wordnet/pt")
public class LexicalSemanticController {

    private final LexicalSemanticData pt_wordnet = new LexicalSemanticData("WEB-INF/Database/tep_pulo.csv");
    private final Gson gson = new Gson();
    
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @RequestMapping("/Hello")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
        
    }
    
    @RequestMapping(value = "/GetLexicalSimilarity", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public String GetLexicalSimilarity(@RequestBody String json) {
        
        SimilaritySemJson jsonSearch = gson.fromJson(json, SimilaritySemJson.class);
        
        RCaller caller = RCaller.create();
        RCode code = RCode.create();
        
        code.addRCode("source('D:/Bruno/2017/Java/r/script.R', encoding = 'UTF-8')");
        //code.addRCode("install.packages(\"stringdist\")");
        code.addRCode("library(stringdist)");
        code.addRCode("ols <- MeasureTestSimilarity(\"" + jsonSearch.getFromPeriod() + "\", \"" + jsonSearch.getToPeriod() + "\")");
        
        caller.setRCode(code);
        caller.runAndReturnResult("ols");
        
        int[] result = caller.getParser().getAsIntArray("ols");
        
        jsonSearch.setResult(result[0]);
        
        return gson.toJson(jsonSearch);
    }
    
    @RequestMapping(value = "/GetTargets", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public String getTargets(@RequestBody String json) {   
        
        Triple obj = gson.fromJson(json, Triple.class);
        return gson.toJson(pt_wordnet.getTargets(obj.getFrom(), obj.getRelation()));
        
    }
    
    @RequestMapping(value = "/GetRelationAndTargets", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public String getRelationAndTargets(@RequestBody String json) {
        Triple obj = gson.fromJson(json, Triple.class);
        return gson.toJson(pt_wordnet.getRelationsAndTargets(obj.getFrom()));
    }

}
