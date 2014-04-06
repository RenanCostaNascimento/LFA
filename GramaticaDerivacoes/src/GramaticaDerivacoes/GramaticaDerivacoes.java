/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GramaticaDerivacoes;

/**
 *
 */
public class GramaticaDerivacoes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Derivacoes derivacoes = new Derivacoes();
        derivacoes.carregarGramatica("file-name.txt");
        derivacoes.escreverGramatica();
        
    }

}
