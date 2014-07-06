/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mealymoore;

import edu.ifes.sexpr.Lexer;
import edu.ifes.sexpr.Parser;
import edu.ifes.sexpr.Symbol;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import linguagem.FuncaoSaida;
import linguagem.Linguagem;
import linguagem.Mealy;
import linguagem.Moore;
import linguagem.Transicao;

/**
 *
 * @author Renan
 */
public class MealyMoore {
    
    // Possiveis arquivos de entrada.
    private static final String MOORE_ENTRADA_1 = "moore-entrada-1.txt";
    private static final String MOORE_ENTRADA_2 = "moore-entrada-2.txt";
    private static final String MOORE_ENTRADA_3 = "moore-entrada-3.txt";
    private static final String MEALY_ENTRADA_1 = "mealy-entrada-1.txt";
    private static final String MEALY_ENTRADA_2 = "mealy-entrada-2.txt";
    private static final String MEALY_ENTRADA_3 = "mealy-entrada-3.txt";
    
    // Possiveis arquivos de saida.
    private static final String MOORE_SAIDA_1 = "moore-saida-1.txt";
    private static final String MOORE_SAIDA_2 = "moore-saida-2.txt";
    private static final String MOORE_SAIDA_3 = "moore-saida-3.txt";
    private static final String MEALY_SAIDA_1 = "mealy-saida-1.txt";
    private static final String MEALY_SAIDA_2 = "mealy-saida-2.txt";
    private static final String MEALY_SAIDA_3 = "mealy-saida-3.txt";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        assert (args.length == 1);
        FileReader rd = new FileReader(MEALY_ENTRADA_1);

        Lexer lex = new Lexer(rd);
        Parser parser = new Parser(lex);

        // Read de file's contents and asserts it is a list.
        Object x = parser.expr();
        assert (x instanceof List);
        List maq = (List) x;

        x = maq.get(0);
        assert (x instanceof Symbol);
        Linguagem linguagem;
        Symbol idMaq = (Symbol) x;
        if (idMaq.name.equals("mealy")) {
            System.out.println("Reconheceu Mealy");
            linguagem = new Mealy();
        } else if (idMaq.name.equals("moore")) {
            System.out.println("Reconheceu Moore");
            linguagem = new Moore();
        } else {
            throw new IllegalArgumentException("Não sei que máquina é essa.");
        }

        for (int i = 1; i < maq.size(); i += 1) {
            x = maq.get(i);
            if (!(x instanceof List)) {
                String err = String.format("Elemento não é uma lista: %s", x);
                throw new IllegalArgumentException(err);
            } else {
                List l = (List) x;
                x = l.get(0);
                Symbol id = (Symbol) x;
                if (id.name.equals("symbols-in")) {
                    for (int j = 1; j < l.size(); j++) {
                        linguagem.addAlfabetoEntrada(l.get(j).toString());
                    }
                } else if (id.name.equals("symbols-out")) {
                    for (int j = 1; j < l.size(); j++) {
                        linguagem.addAlfabetoSaida(l.get(j).toString());
                    }
                } else if (id.name.equals("states")) {
                    for (int j = 1; j < l.size(); j++) {
                        linguagem.addConjuntoEstados(l.get(j).toString());
                    }
                } else if (id.name.equals("start")) {
                    linguagem.setEstadoInicial(l.get(1).toString());
                } else if (id.name.equals("finals")) {
                    for (int j = 1; j < l.size(); j++) {
                        linguagem.addConjuntoEstadosFinais(l.get(j).toString());
                    }
                } else if (id.name.equals("trans")) {
                    for (int j = 1; j < l.size(); j += 1) {
                        x = l.get(j);
                        ArrayList<String> array = object2array(x);
                        String funcaoTransicao = array.get(0);
                        String estadoOrigem = funcaoTransicao.substring(1, 3);
                        String estadoDestino = funcaoTransicao.substring(5, 7);
                        String simboloTransicao = funcaoTransicao.substring(9, 10);
                        Transicao transicao = new Transicao(estadoOrigem, simboloTransicao, estadoDestino);
                        if (idMaq.name.equals("mealy")) {
                            String simboloGerado = funcaoTransicao.substring(12, 13);
                            transicao.setSimboloGerado(simboloGerado);
                        }
                        linguagem.addFuncaoTransicao(transicao);

                    }
                } else if (id.name.equals("out-fn")) {
                    for (int j = 1; j < l.size(); j += 1) {
                        x = l.get(j);
                        ArrayList<String> array = object2array(x);
                        String funcaoSaidaStr = array.get(0);
                        String estado = funcaoSaidaStr.substring(1, 3);
                        String simboloGerado = funcaoSaidaStr.substring(5, 6);
                        FuncaoSaida funcaoSaida;
                        if (simboloGerado.equals("[")) {
                            funcaoSaida = new FuncaoSaida(estado, "$");
                        } else {
                            funcaoSaida = new FuncaoSaida(estado, simboloGerado);
                        }
                        linguagem.addFuncaoSaida(funcaoSaida);
                    }
                } else {
                    String err = String.format("Isso não deveria estar aqui: %s", id);
                    throw new IllegalArgumentException(err);
                }
            }
        }
        

        // Escolho a máquina, realizo a conversão
        Linguagem linguagemConvertida = null;
        if (idMaq.name.equals("mealy")) {
            Mealy linguagemAtual = (Mealy) linguagem;
            linguagemConvertida = linguagemAtual.toMoore();
        } else if (idMaq.name.equals("moore")) {
            Moore linguagemAtual = (Moore) linguagem;
            linguagemConvertida = linguagemAtual.toMealy();
        }
        
        //System.out.println(linguagemConvertida.toString());

        BufferedWriter out = new BufferedWriter(new FileWriter(MEALY_SAIDA_1));
        out.write(linguagemConvertida.gerarArquivo());
        out.close();
    }

    private static ArrayList<String> object2array(Object x) {
        String texto = x.toString();
        String[] vetor = texto.split(" ,");
        ArrayList<String> array = new ArrayList<>();
        for (int posicao = 0; posicao < vetor.length; posicao++) {
            array.add(vetor[posicao]);
        }
        return array;
    }

}
