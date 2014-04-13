/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GramaticaDerivacoes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renan
 */
public class Gramatica {
    
    private List<String> V;
    private List<String> T;
    private String S;
    private List<RegraProducao> regrasProducao;

    public Gramatica(){
        V = new ArrayList<>();
        T = new ArrayList<>();
        regrasProducao = new ArrayList<>();
    }

    public List<String> getV() {
        return V;
    }

    public void setV(List<String> V) {
        this.V = V;
    }
    
    public void addV(String v){
        this.V.add(v);
    }

    public List<String> getT() {
        return T;
    }

    public void setT(List<String> T) {
        this.T = T;
    }
    
    public void addT(String t){
        this.T.add(t);
    }

    public String getS() {
        return S;
    }

    public void setS(String S) {
        this.S = S;
    }

    public List<RegraProducao> getRegrasProducao() {
        return regrasProducao;
    }

    public void addRegraProducao(RegraProducao regraProducao){
        this.regrasProducao.add(regraProducao);
    }
}
