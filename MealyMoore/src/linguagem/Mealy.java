/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linguagem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author T
 */
public class Mealy extends Linguagem {

    @Override
    public Linguagem toMealy() {
        System.out.println("Já sou Mealy!");
        return null;
    }

    @Override
    public Linguagem toMoore() {
        Moore moore = new Moore();

        moore.setAlfabetoEntrada(alfabetoEntrada);
        moore.setAlfabetoSaida(alfabetoSaida);
        moore.setFuncaoSaidas(funcaoSaidas);
        gerarNovosEstados(moore);
        gerarEstadoInicial(moore);
        gerarEstadosFinais(moore);
        gerarTransicoes(moore);

        return moore;
    }

    private void gerarNovosEstados(Moore moore) {
        Map<String, String> estadoSimbolo = new HashMap<>();
        for (Transicao transicao : funcaoTransicao) {
            String novoEstado = transicao.getEstadoDestino();
            //se o novo estado não estiver mapeado
            if (!estadoSimbolo.containsKey(novoEstado)) {
                //mapear estado-simbolo
                estadoSimbolo.put(novoEstado, transicao.getSimboloGerado());
            } else {
                //se o estado existir
                while (estadoSimbolo.get(novoEstado) != null) {
                    //verificar se o simbolo que eu quero inserir já existe para o estado
                    if (!estadoSimbolo.get(novoEstado).equals(transicao.getSimboloGerado())) {
                        //gerar variação do novo estado
                        novoEstado += "*";
                    } else {
                        break;
                    }
                }
                estadoSimbolo.put(novoEstado, transicao.getSimboloGerado());
            }
        }
        for (Map.Entry<String, String> entry : estadoSimbolo.entrySet()) {
            moore.addConjuntoEstados(entry.getKey());
            FuncaoSaida funcaoSaida = new FuncaoSaida(entry.getKey(), entry.getValue());
            moore.addFuncaoSaida(funcaoSaida);
        }
        //adicionando o estado q0 ao conjunto, caso ele não tenha sido adicionado.
//        List<String> listaQ0 = getVariacoesDeUmEstado("q0");
//        for(String estadoQ0 : listaQ0){
            moore.addConjuntoEstados("q0");
//        }
    }

    private void gerarEstadoInicial(Moore moore) {
        if (moore.getConjuntoEstados().contains("q0*")) {
            moore.setEstadoInicial("qi");
            moore.addConjuntoEstados("qi");
            //não há transições para q0, portanto é preciso adicionar um qo/$
            FuncaoSaida funcaoSaida = new FuncaoSaida("qi", "$");
            moore.addFuncaoSaida(funcaoSaida);
        } else {
            moore.setEstadoInicial("q0");
            //não há transições para q0, portanto é preciso adicionar um qo/$
//            FuncaoSaida funcaoSaida = new FuncaoSaida("q0", "$");
//            moore.addFuncaoSaida(funcaoSaida);
        }

    }

    private void gerarTransicoes(Moore moore) {
        for (Transicao transicao : funcaoTransicao) {
            List<String> estadosOrigemPossiveis = moore.getVariacoesDeUmEstado(transicao.getEstadoOrigem());
            List<String> estadosDestinoPossiveis = getVariacoesEstadoSimbolo(transicao.getEstadoDestino(), transicao.getSimboloGerado());
            for (String estadoOrigem : estadosOrigemPossiveis) {
                for (String estadoDestino : estadosDestinoPossiveis) {
                    Transicao novaTransicao = new Transicao(estadoOrigem, transicao.getSimboloTransicao(), estadoDestino);
                    moore.addFuncaoTransicao(novaTransicao);
                }
            }
        }
    }

    private String estadoOriginal(String estado) {
        return estado.substring(0, 2);
    }

    private void gerarEstadosFinais(Moore moore) {
        for (String estadoFinal : conjuntoEstadosFinais) {

            while (moore.getConjuntoEstados().contains(estadoFinal)) {
                moore.addConjuntoEstadosFinais(estadoFinal);
                estadoFinal += "*";
            }
        }
    }

    public String gerarArquivo() {
        StringBuilder builder = new StringBuilder();
        builder.append("( mealy\n");
        builder.append(super.gerarArquivo());
        for (Transicao transicao : funcaoTransicao) {
            if (getSimboloGerado(transicao.getEstadoDestino()).equals("$")) {
                builder.append("( " + transicao.getEstadoOrigem() + " " + transicao.getEstadoDestino() + " " + transicao.getSimboloTransicao() + " ( ) ) ");
            } else {
                builder.append("( " + transicao.getEstadoOrigem() + " " + transicao.getEstadoDestino() + " " + transicao.getSimboloTransicao() + " " + getSimboloGerado(transicao.getEstadoDestino()) + " ) ");
            }

        }
        builder.append(") )");
        return builder.toString();
    }

}
