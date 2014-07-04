/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package linguagem;

/**
 *
 * @author Renan
 */
public class Transicao {
    
    private String estadoOrigem;
    private String simboloTransicao;
    private String estadoDestino;
    private String simboloGerado;
    
    public Transicao(String estadoOrigem, String simboloTransicao, String estadoDestino){
        this.estadoOrigem = estadoOrigem;
        this.simboloTransicao = simboloTransicao;
        this.estadoDestino = estadoDestino;
    }

    public String getEstadoOrigem() {
        return estadoOrigem;
    }

    public void setEstadoOrigem(String estadoOrigem) {
        this.estadoOrigem = estadoOrigem;
    }

    public String getSimboloTransicao() {
        return simboloTransicao;
    }

    public void setSimboloTransicao(String simboloTransicao) {
        this.simboloTransicao = simboloTransicao;
    }

    public String getEstadoDestino() {
        return estadoDestino;
    }

    public void setEstadoDestino(String estadoDestino) {
        this.estadoDestino = estadoDestino;
    }

    public String getSimboloGerado() {
        return simboloGerado;
    }

    public void setSimboloGerado(String simboloGerado) {
        this.simboloGerado = simboloGerado;
    }
        
    @Override
    public String toString(){
        return estadoOrigem + " -> " + simboloTransicao + " = " + estadoDestino;
    }
}
