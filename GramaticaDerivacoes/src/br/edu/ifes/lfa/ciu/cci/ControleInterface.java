/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.lfa.ciu.cci;

import br.edu.ifes.lfa.cgd.ManipuladorArquivo;

/**
 *
 * @author Thanner Soares Silva <thannersoares@gmail.com>
 */
public class ControleInterface {

    /* Método que busca controlar uma determinada chamada
     */
    public void controlaChamada() {
        ManipuladorArquivo ma = new ManipuladorArquivo();
        ma.manipulaLeituraArquivo();
    }

}
