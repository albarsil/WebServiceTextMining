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

public class TePJson {
    
    @SerializedName("obj")
    private List<TePInstance> list;

    public TePJson(List<TePInstance> list) {
        this.list = list;
    }

    public List<TePInstance> getList() {
        return list;
    }

    public void setList(List<TePInstance> list) {
        this.list = list;
    }    
}
