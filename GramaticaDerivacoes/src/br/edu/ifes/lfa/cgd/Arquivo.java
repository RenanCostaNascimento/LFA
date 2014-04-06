/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.lfa.cgd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thanner Soares Silva <thannersoares@gmail.com>
 */
public class Arquivo {
    
    private final String nomeArquivo = "file-name.txt";
    
    public List<String> leituraArquivo() {
        List<String> linhasArquivo = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            linha = reader.readLine();
            while (linha != null) {
                linhasArquivo.add(linha);
                linha = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Erro de I/O");
            e.printStackTrace();
        }
        return linhasArquivo;
    }
}
