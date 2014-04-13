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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renan
 */
public class Derivacoes {
    
    private Gramatica gramatica = new Gramatica();
    private Set<String> cadeiasGeradas = new HashSet<String>();
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

    public Set<String> getCadeiasGeradas() {
        return cadeiasGeradas;
    }

    public void setCadeiasGeradas(Set<String> cadeiasGeradas) {
        this.cadeiasGeradas = cadeiasGeradas;
    }

    public void addCadeiaGerada(String cadeia){
        
        this.cadeiasGeradas.add(cadeia);
    }
    
    /**
     *
     * @param nomeArquivo nome do arquivo onde se encontra a definicao da gramatica
     * Cria uma gramatica baseaso no conteudo de um arquivo de texto.
     */
    public void carregarGramatica(String nomeArquivo){
        try {
            in = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            
            linha = in.readLine();
            while(linha != null){
                switch(linha.charAt(0)){
                    case 'V':
                        for(int i = 4; i < linha.length(); i=i+2){
                            gramatica.addV(String.valueOf(linha.charAt(i)));
                        }
                        break;
                    case 'T':
                        for(int i = 4; i < linha.length(); i=i+2){
                            gramatica.addT(String.valueOf(linha.charAt(i)));
                        }
                        break;    
                    case 'S':
                        gramatica.setS(String.valueOf(linha.charAt(4)));
                        break;
                    default:
                        int tamanhoChave = linha.indexOf("-");
                        RegraProducao regraProducao = new RegraProducao(linha.substring(0, tamanhoChave - 1), linha.substring(tamanhoChave + 3, linha.length()));
                        gramatica.addRegraProducao(regraProducao);
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
    
    /**
     * Escreve a gramatica na tela.
     */
    public void escreverGramatica(){
        System.out.println(gramatica.getV());
        System.out.println(gramatica.getT());
        System.out.println(gramatica.getS());
        
        for (RegraProducao regra : gramatica.getRegrasProducao()) {
            System.out.println(regra.getChave() + " => " + regra.getValor());
        }
    }
    
    /**
     *
     * @param cadeia cadeia inicial
     * @param n tamanho maxima da palavra
     * 
     * Dada uma cadeia, o método tenta aplicar todas as regras de producao que a cadeia aceita.
     */
    public void gerarPalavras(String cadeia, int n){
        for(RegraProducao regraProducao : gramatica.getRegrasProducao()){
            if(regraValida(cadeia, regraProducao)){
//                System.out.print(cadeia + "  aplicando   " + regraProducao.getChave() + "=>" + regraProducao.getValor() + "   gera: ");
                String novaCadeia = aplicarRegraProducao(cadeia, regraProducao);
//                System.out.println(novaCadeia);
                if (validarCadeia(novaCadeia, n)) {
                     addCadeiaGerada(novaCadeia);
                     break;
                }else{
                    if(novaCadeia.length() <= n){
                        gerarPalavras(novaCadeia, n*2);
                    }
                }
            }
        }
    }

    /**
     * Verifica se uma regra de producao pode ser aplicada para uma cadeia
     * 
     * @param cadeia cadeia em que se quer validar a regra de producao
     * @param regraProducao regra de producao em se quer validar a cadeia
     * @return true se a regra de producao for aplicada
     */ 
    private boolean regraValida(String cadeia, RegraProducao regraProducao) {
        for(int i = 0; i < cadeia.length(); i++){
            if(cadeia.contains(regraProducao.getChave())){
                return true;  
            }
        }
        return false;
    }

    /**
     * Aplica uma regra de producao em uma cadeia
     * 
     * @param cadeia cadeia em que se quer aplicar a regra de producao
     * @param regraProducao regra de producao que ser quer aplicar na cadeia
     * @return uma nova cadeia com a regra apliacada
     */
    private String aplicarRegraProducao(String cadeia, RegraProducao regraProducao) {
        String novaCadeia;
        
        if(regraProducao.getValor().equals("$")){
            novaCadeia = cadeia.replaceFirst(regraProducao.getChave(), "");
        }else{
            novaCadeia = cadeia.replaceFirst(regraProducao.getChave(), regraProducao.getValor());
        }
        return novaCadeia;
    }

    /**
     * Valida se uma cadeia pode ser processada pela gramatica, cujo tamanho seja n
     * 
     * @param novaCadeia cadeia que ser quer verificar
     * @param n tamanho da cadeia
     * @return true se a cadeia foi aceita
     */
    private boolean validarCadeia(String novaCadeia, int n) {
//        System.out.println("validando " + novaCadeia+"\n");
        if(novaCadeia.length() != n){
            return false;
        }
        for(String v : gramatica.getV()){
            if(novaCadeia.contains(v)){
                return false;
            }
        }
//        System.out.println("PALAVRA ACEITA: "+novaCadeia+"\n");
        return true;
    }
}
