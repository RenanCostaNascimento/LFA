/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GramaticaDerivacoes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Renan
 */
public class Gramatica {
    
    private String V;
    private String T;
    private String S;
    private List<HashMap<String, String>> regrasProducao;

    public Gramatica(){
        regrasProducao = new ArrayList<HashMap<String, String>>();
    }
    
    public String getV() {
        return V;
    }

    public void setV(String V) {
        this.V = V;
    }

    public String getT() {
        return T;
    }

    public void setT(String T) {
        this.T = T;
    }

    public String getS() {
        return S;
    }

    public void setS(String S) {
        this.S = S;
    }

    public List<HashMap<String, String>> getRegrasProducao() {
        return regrasProducao;
    }

    public void setRegrasProducao(List<HashMap<String, String>> regrasProducao) {
        this.regrasProducao = regrasProducao;
    }

    public void addRegraProducao(HashMap<String, String> regra){
        regrasProducao.add(regra);
    }
}
