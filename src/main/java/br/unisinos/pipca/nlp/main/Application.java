package br.unisinos.pipca.nlp.main;

import br.unisinos.pipca.nlp.controller.OpenNLPController;
import br.unisinos.pipca.nlp.controller.GreetingController;
import br.unisinos.pipca.nlp.controller.LexicalSemanticController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
//import br.unisinos.pipca.nlp.controller.GreetingController;

@SpringBootApplication
@ComponentScan(basePackageClasses = GreetingController.class)
@ComponentScan(basePackageClasses = OpenNLPController.class)
@ComponentScan(basePackageClasses = LexicalSemanticController.class)
//@ComponentScan(basePackageClasses = StanfordCoreNerController.class)
        
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
