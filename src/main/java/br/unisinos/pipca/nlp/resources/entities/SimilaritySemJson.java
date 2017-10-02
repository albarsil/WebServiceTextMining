/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisinos.pipca.nlp.resources.entities;

/**
 *
 * @author bruno_000
 */
public class SimilaritySemJson {
    private String  fromPeriod;
    private String  toPeriod;
    private int     result;
    
    public SimilaritySemJson (String fromPeriod, String toPeriod)
    {
        this.fromPeriod = fromPeriod;
        this.toPeriod = toPeriod;
    }
    
    public String getFromPeriod()
    {
        return this.fromPeriod;
    }
    
    public void setFromPeriod(String period)
    {
        this.fromPeriod = period;
    }
    
    public String getToPeriod()
    {
        return this.toPeriod;
    }
    
    public void setToPeriod(String period)
    {
        this.toPeriod = period;
    }
    
    public int getResult()
    {
        return this.result;
    }
    
    public void setResult(int result)
    {
        this.result = result;
    }
}
