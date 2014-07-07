MealyMoore
====================

Disciplina de LFA
---------------------

### Autores 

Renan Nascimento e Thanner Soares

### Descrição

O código foi escrito na linguagem orientada a objetos Java. Conta com 6 classes sendo que a classe Mealy permite a conversão para a linguagem Moore e a classe Moore permite a conversão para a classe Mealy. Ambas tem como superclasse a classe Linguagem, onde compartilham características comuns como o alfabeto de entrada, alfabeto de saída, conjuntos de estados, estado inicial, conjunto de estados finais, função de transição e função de saída.

### Procedimento para compilação

Apesar dos esforços realizados, não conseguimos executar o código no terminal. Afim de evitarmos a não entrega do trabalho, o projeto será enviado e poderá ser executado em um ambiente de desenvolvimento (preferencialmente Netbeans) utilizando "F6". 
O mesmo possui arquivos de entrada e saída armazenados dentro de constantes na classe principal. Para modificar a entrada basta substituir a entrada e a saída no método main. 
Também foi criado no código o que supostamente seria a execução via linha de comando. Contudo, o mesmo se encontra comentado pois não conseguimos testar o mesmo.

### Nome e modo de uso do programa desenvolvido

Nome: MealyMoore

Modo de Uso: 
O código funciona da seguinte maneira:

1 -> Realiza a leitura de um arquivo texto

2 -> Faz a verificação se o arquivo gera uma linguagem mealy ou moore

3 -> Sendo mealy, manda a linguagem para a classe Mealy e converte para a liguagem Moore

4 -> Sendo moore, manda a linguagem para a classe Moore e converte para a linguagem Mealy

5 -> Não sendo nenhum dos casos, gera uma exceção

6 -> Caso seja gerado uma linguagem baseado na conversão do arquivo de entrada, recupera essa linguagem e a insere no arquivo de saída indicado inicialmente.

### Outras informações

> O símbolo " ' " não deve ser utilizado para criação de estados pois o mesmo não permitia o reconhecimento de uma linguagem. Para, por exemplo, a geração de estados da conversão da máquina de Mealy para a Máquina de Moore geramos "q0, q0*, q0**,...".