/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linguagem;

/**
 *
 * @author T
 */
public class Moore extends Linguagem {

    private String estado;
    private String simboloGerado;

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

//    public String toString() {
//        return super.toString() + "\nFunção de saída:\n" + simboloGerado;
//    }

    public Mealy converteMealy() {
        System.out.println("Ainda não implementado");
        return null;
    }

}
