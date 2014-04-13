/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GramaticaDerivacoes;

/**
 *
 * @author Renan
 * 
 * Classe que representa uma regra de producao.
 */
public class RegraProducao {
    private String chave;
    private String valor;

    public RegraProducao(String chave, String valor){
        this.chave = chave;
        this.valor = valor;
    }
    
    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }  
}