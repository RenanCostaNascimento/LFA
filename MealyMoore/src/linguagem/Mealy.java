/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linguagem;

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
        moore.setConjuntoEstados(conjuntoEstados);
        moore.setEstadoInicial(estadoInicial);
        moore.setConjuntoEstadosFinais(conjuntoEstadosFinais);
        for (Transicao transicao : funcaoTransicao) {
            Transicao transicaoMoore = new Transicao(transicao.getEstadoOrigem(), transicao.getSimboloTransicao(), transicao.getEstadoDestino());
            moore.addFuncaoTransicao(transicao);
            FuncaoSaida funcaoSaida = new FuncaoSaida(transicao.getEstadoOrigem(), transicao.getSimboloGerado());
            moore.addFuncaoSaida(funcaoSaida);            
        }
        
        return moore;
    }


}
