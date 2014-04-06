/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.lfa.cgd;

import br.edu.ifes.lfa.cln.cdp.Gramatica;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Thanner Soares Silva <thannersoares@gmail.com>
 */
public class ManipuladorArquivo {

    private Arquivo arquivo = new Arquivo();

    /*
     Método que informa o nome de um arquivo, recebe os dados do arquivo, transforma os dados do arquivo em uma gramática e retorna essa gramática.
     */
    public Gramatica manipulaLeituraArquivo() {
        List<String> linhasArquivo = arquivo.leituraArquivo();
        for (String linha : linhasArquivo) {
            System.out.println(linha);
        }
        return defineGramatica(linhasArquivo);
    }

    /*
     M[etodo que lë linhas de um arquivo e as transforma em palavras chaves entendidas pelo programa
     */
    private Gramatica defineGramatica(List<String> linhasArquivo) {
        Gramatica g = new Gramatica();
        for (String linha : linhasArquivo) {
            switch (linha.substring(0, 1)) {
                case "V":
                    g.setV(manipulaRegra(linha));
                    break;
                case "T":
                    g.setT(manipulaRegra(linha));
                    break;
                case "S":
                    g.setS(manipulaRegra(linha));
                    break;
                default:
                    g.setP(manipulaRegraProducao(linha));
            }
        }
        return g;
    }

    private List<String> manipulaRegra(String linha) {
        List<String> regra = new ArrayList<String>();
        char[] chars = linha.toCharArray();
        String buffer = "";
        for (int indice = 4; indice < chars.length; indice++) {
            if (chars[indice] != ' ') {
                buffer = buffer + chars[indice];
            } else {
                regra.add(buffer);
                buffer = "";
            }
        }
        if (!buffer.isEmpty()) {
            regra.add(buffer);
        }
        return regra;
    }

    private List<String> manipulaRegraProducao(String linha) {
        List<String> regra = new ArrayList<String>();
        char[] chars = linha.toCharArray();
        int indice = 0;
        String buffer = "";
        while (chars[indice] != '-' & chars[indice + 1] != '>') {
            if (chars[indice] != ' ') {
                buffer = buffer + chars[indice];
            } else {
                regra.add(buffer);
                buffer = "";
            }
            indice++;
        }
        indice = indice + 3;
        buffer = "";
        while (indice < chars.length) {
            if (chars[indice] != ' ') {
                buffer = buffer + chars[indice];
            } else {
                regra.add(buffer);
                buffer = "";
            }
            indice++;
        }
        if (!buffer.isEmpty()) {
            regra.add(buffer);
        }
        return regra;
    }
}
