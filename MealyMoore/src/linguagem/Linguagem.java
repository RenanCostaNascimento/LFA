/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linguagem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T
 */
public abstract class Linguagem {

    protected List<String> alfabetoEntrada;
    protected List<String> alfabetoSaida;
    protected List<String> conjuntoEstados;
    protected String estadoInicial;
    protected List<String> conjuntoEstadosFinais;
    protected List<Transicao> funcaoTransicao;
    protected List<FuncaoSaida> funcaoSaidas;

    public Linguagem() {
        this.alfabetoEntrada = new ArrayList<>();
        this.funcaoTransicao = new ArrayList();
        this.alfabetoSaida = new ArrayList<>();
        this.conjuntoEstados = new ArrayList<>();
        this.conjuntoEstadosFinais = new ArrayList<>();
        this.funcaoSaidas = new ArrayList<>();
    }

    public List<Transicao> getFuncaoTransicao() {
        return funcaoTransicao;
    }

    public void setFuncaoTransicao(List<Transicao> funcaoTransicao) {
        this.funcaoTransicao = funcaoTransicao;
    }

    public List<FuncaoSaida> getFuncaoSaidas() {
        return funcaoSaidas;
    }

    public void setFuncaoSaidas(List<FuncaoSaida> funcaoSaidas) {
        this.funcaoSaidas = funcaoSaidas;
    }
    
    public void addAlfabetoEntrada(String alfabetoEntrada) {
        this.alfabetoEntrada.add(alfabetoEntrada);
    }
    
    public void addFuncaoSaida(FuncaoSaida funcaoSaida) {
        this.funcaoSaidas.add(funcaoSaida);
    }

    public void addAlfabetoSaida(String alfabetoSaida) {
        this.alfabetoSaida.add(alfabetoSaida);
    }

    public void addConjuntoEstados(String estado) {
        this.conjuntoEstados.add(estado);
    }

    public void addConjuntoEstadosFinais(String estadoFinal) {
        this.conjuntoEstadosFinais.add(estadoFinal);
    }

    public void addFuncaoTransicao(Transicao transicao) {
        this.funcaoTransicao.add(transicao);
    }

    public List<String> getAlfabetoEntrada() {
        return alfabetoEntrada;
    }

    public void setAlfabetoEntrada(List<String> alfabetoEntrada) {
        this.alfabetoEntrada = alfabetoEntrada;
    }

    public List<String> getAlfabetoSaida() {
        return alfabetoSaida;
    }

    public void setAlfabetoSaida(List<String> alfabetoSaida) {
        this.alfabetoSaida = alfabetoSaida;
    }

    public List<String> getConjuntoEstados() {
        return conjuntoEstados;
    }

    public void setConjuntoEstados(List<String> conjuntoEstados) {
        this.conjuntoEstados = conjuntoEstados;
    }

    public String getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(String estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public List<String> getConjuntoEstadosFinais() {
        return conjuntoEstadosFinais;
    }

    public void setConjuntoEstadosFinais(List<String> conjuntoEstadosFinais) {
        this.conjuntoEstadosFinais = conjuntoEstadosFinais;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Alfabeto de entrada:\n");
        for (String entrada : alfabetoEntrada) {
            builder.append(entrada + " ");
        }
        builder.append("\nAlfabeto de saída:\n");
        for (String saida : alfabetoSaida) {
            builder.append(saida + " ");
        }
        builder.append("\nConjunto de estados:\n");
        for (String estado : conjuntoEstados) {
            builder.append(estado + " ");
        }
        builder.append("\nEstado inicial:\n" + estadoInicial);
        builder.append("\nConjunto de estados finais:\n");
        for (String estado : conjuntoEstadosFinais) {
            builder.append(estado + " ");
        }
        builder.append("\nFunção de transição:\n");
        for (Transicao transicao : funcaoTransicao) {
            builder.append(transicao.toString());
            if(transicao.getSimboloGerado() != null){
                builder.append(" e gera " + transicao.getSimboloGerado());
            }
            builder.append("\n");
        }
        
        return builder.toString();
    }

    public String[] String2VetorString(String string) {
        String[] novaString = string.substring(1, string.length() - 1).split(", ");
        return novaString;
    }
    
    public abstract Linguagem toMealy();
    
    public abstract Linguagem  toMoore();
    
    public String gerarArquivo(){
        StringBuilder builder = new StringBuilder();
        builder.append("( symbols-in ");
        for(String entrada : alfabetoEntrada){
            builder.append(entrada + " ");
        }
        builder.append(")\n( symbols-out ");
        for(String saida : alfabetoSaida){
            builder.append(saida + " ");
        }
        builder.append(")\n( states ");
        for(String estado : conjuntoEstados){
            builder.append(estado + " ");
        }
        builder.append(")\n( start " + estadoInicial + ")\n");
        builder.append("( finals ");
        for(String estado : conjuntoEstadosFinais){
            builder.append(estado + " ");
        }
        builder.append(")\n( trans\n");
        return builder.toString();
    }
}
