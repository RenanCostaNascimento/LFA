/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GramaticaDerivacoes;

import java.util.Scanner;

/**
 *
 */
public class GramaticaDerivacoes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Derivacoes derivacoes = new Derivacoes();
        Scanner scanner = new Scanner(System.in);
        int tamanhoPalavra;

        derivacoes.carregarGramatica("file-name.txt");
        System.out.println("Qual tamanho da palavra?");
        tamanhoPalavra = scanner.nextInt();

        derivacoes.gerarPalavras(derivacoes.getGramatica().getS(), tamanhoPalavra);

        if (derivacoes.getCadeiasGeradas().isEmpty()) {
            System.out.println("Nenhuma palavra de tamanho " + tamanhoPalavra + " foi aceita.");
        } else {
            System.out.println("Palavras encontradas: ");
            for (String palavra : derivacoes.getCadeiasGeradas()) {
                System.out.println(palavra);
            }
        }

    }

}
