/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GramaticaDerivacoes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renan
 */
public class Derivacoes {
    
    private Gramatica gramatica = new Gramatica();
    BufferedReader in;

    public Gramatica getGramatica() {
        return gramatica;
    }

    public void setGramatica(Gramatica gramatica) {
        this.gramatica = gramatica;
    }

    public BufferedReader getIn() {
        return in;
    }

    public void setIn(BufferedReader in) {
        this.in = in;
    }

    
    public void carregarGramatica(String nomeArquivo){
        try {
            in = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            
            linha = in.readLine();
            while(linha != null){
                switch(linha.charAt(0)){
                    case 'V':
                        gramatica.setV(linha);
                        break;
                    case 'T':
                        gramatica.setT(linha);
                        break;    
                    case 'S':
                        gramatica.setS(linha);
                        break;
                    default:
                        HashMap<String, String> regra = new HashMap<>();
                        regra.put(linha.substring(0, 1), linha.substring(5, linha.length()));
                        gramatica.addRegraProducao(regra);
                        break;
                }
                linha = in.readLine();
            }  
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Derivacoes.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Arquivo não encontrado.");
        } catch (IOException ex) {
            Logger.getLogger(Derivacoes.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro de I/O.");
        }
    }
    
    public void escreverGramatica(){
        System.out.println(gramatica.getV());
        System.out.println(gramatica.getT());
        System.out.println(gramatica.getS());
        System.out.println(gramatica.getRegrasProducao());
    } 
}
