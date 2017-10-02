/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisinos.pipca.nlp.resources.entities;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 *
 * @author Allan de Barcelos Silva
 */
public class TePInstance {
    @SerializedName("word")
    private String word;
    @SerializedName("list")
    private List<String> knowSynonyms;

    public TePInstance(String word, List<String> knowSynonyms) {
        this.word = word;
        this.knowSynonyms = knowSynonyms;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<String> getKnowSynonyms() {
        return knowSynonyms;
    }

    public void setKnowSynonyms(List<String> knowSynonyms) {
        this.knowSynonyms = knowSynonyms;
    }
}
