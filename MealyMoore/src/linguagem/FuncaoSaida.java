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
public class FuncaoSaida {
    
    private String estado;
    private String simboloGerado;
    
    public FuncaoSaida(String estado, String simboloGerado){
        this.estado = estado;
        this.simboloGerado = simboloGerado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSimboloGerado() {
        return simboloGerado;
    }

    public void setSimboloGerado(String simboloGerado) {
        this.simboloGerado = simboloGerado;
    }
    
    
}
