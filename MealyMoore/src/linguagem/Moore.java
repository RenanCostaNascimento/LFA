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
    
    public String gerarArquivo(){
        StringBuilder builder = new StringBuilder();
        builder.append("( moore\n");
        builder.append(super.gerarArquivo());
        for(Transicao transicao : funcaoTransicao){
            builder.append("( " + transicao.getEstadoOrigem() + " " + transicao.getEstadoDestino() + " " + transicao.getSimboloTransicao() + " ) ");
        }
        builder.append("\n( out-fn\n");
        for(Transicao transicao : funcaoTransicao){
            if(transicao.getSimboloTransicao().equals("$")){
                builder.append("( " + transicao.getEstadoOrigem() + " ( ) )");
            }else{
                builder.append("( " + transicao.getEstadoOrigem() + " " + transicao.getSimboloGerado() + " ) ");
            }
        }
        builder.append(") )");
        return builder.toString();
    }

    @Override
    public Linguagem toMealy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Linguagem toMoore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
