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
public class Moore extends Linguagem {

    private String estado;
    private String simboloGerado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSimboloGerado() {
        return simboloGerado;
    }

    public void setSimboloGerado(String simboloGerado) {
        this.simboloGerado = simboloGerado;
    }

//    public String toString() {
//        return super.toString() + "\nFunção de saída:\n" + simboloGerado;
//    }
    public String gerarArquivo() {
        StringBuilder builder = new StringBuilder();
        builder.append("( moore\n");
        builder.append(super.gerarArquivo());
        for (Transicao transicao : funcaoTransicao) {
            builder.append("( " + transicao.getEstadoOrigem() + " " + transicao.getEstadoDestino() + " " + transicao.getSimboloTransicao() + " ) ");
        }
        builder.append("\n( out-fn\n");
        for (FuncaoSaida funcaoSaida : funcaoSaidas) {
            if (funcaoSaida.getSimboloGerado().equals("$")) {
                builder.append("( " + funcaoSaida.getEstado()+ " ( ) ) ");
            } else {
                builder.append("( " + funcaoSaida.getEstado() + " " + funcaoSaida.getSimboloGerado() + " ) ");
            }
        }
        builder.append(") )");
        return builder.toString();
    }
    
    @Override
    public Linguagem toMealy(){
        Mealy mealy = new Mealy();
        mealy.setAlfabetoEntrada(alfabetoEntrada);
        mealy.setAlfabetoSaida(alfabetoSaida);
        mealy.setConjuntoEstados(conjuntoEstados);
        mealy.setEstadoInicial(estadoInicial);
        mealy.setConjuntoEstadosFinais(conjuntoEstadosFinais);
        for (Transicao transicao : funcaoTransicao) {
            Transicao transicaoMealy = new Transicao(transicao.getEstadoOrigem(), transicao.getSimboloTransicao(), transicao.getEstadoDestino());
//            transicaoMealy.setSimboloGerado(getSimboloGerado(transicao.getEstadoDestino()));
            mealy.addFuncaoTransicao(transicao);
            FuncaoSaida funcaoSaida = new FuncaoSaida(transicao.getEstadoOrigem(), transicao.getSimboloGerado());
            mealy.addFuncaoSaida(funcaoSaida);            
        }
        mealy.setFuncaoSaidas(funcaoSaidas);
        
        return mealy;
    }

    @Override
    public Linguagem toMoore() {
        System.out.println("Ja sou Moore!");
        return null;
    }
}
