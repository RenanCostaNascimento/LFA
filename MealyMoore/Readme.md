MealyMoore
====================

Disciplina de LFA
---------------------

### Autores 

Renan Nascimento e Thanner Soares

### Descri��o

O c�digo foi escrito na linguagem orientada a objetos Java. Conta com 6 classes sendo que a classe Mealy permite a convers�o para a linguagem Moore e a classe Moore permite a convers�o para a classe Mealy. Ambas tem como superclasse a classe Linguagem, onde compartilham caracter�sticas comuns como o alfabeto de entrada, alfabeto de sa�da, conjuntos de estados, estado inicial, conjunto de estados finais, fun��o de transi��o e fun��o de sa�da.

### Procedimento para compila��o

Apesar dos esfor�os realizados, n�o conseguimos executar o c�digo no terminal. Afim de evitarmos a n�o entrega do trabalho, o projeto ser� enviado e poder� ser executado em um ambiente de desenvolvimento (preferencialmente Netbeans) utilizando "F6". 
O mesmo possui arquivos de entrada e sa�da armazenados dentro de constantes na classe principal. Para modificar a entrada basta substituir a entrada e a sa�da no m�todo main. 
Tamb�m foi criado no c�digo o que supostamente seria a execu��o via linha de comando. Contudo, o mesmo se encontra comentado pois n�o conseguimos testar o mesmo.

### Nome e modo de uso do programa desenvolvido

Nome: MealyMoore

Modo de Uso: 
O c�digo funciona da seguinte maneira:

1 -> Realiza a leitura de um arquivo texto

2 -> Faz a verifica��o se o arquivo gera uma linguagem mealy ou moore

3 -> Sendo mealy, manda a linguagem para a classe Mealy e converte para a liguagem Moore

4 -> Sendo moore, manda a linguagem para a classe Moore e converte para a linguagem Mealy

5 -> N�o sendo nenhum dos casos, gera uma exce��o

6 -> Caso seja gerado uma linguagem baseado na convers�o do arquivo de entrada, recupera essa linguagem e a insere no arquivo de sa�da indicado inicialmente.

### Outras informa��es

> O s�mbolo " ' " n�o deve ser utilizado para cria��o de estados pois o mesmo n�o permitia o reconhecimento de uma linguagem. Para, por exemplo, a gera��o de estados da convers�o da m�quina de Mealy para a M�quina de Moore geramos "q0, q0*, q0**,...".