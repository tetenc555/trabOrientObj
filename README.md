# Trabalho Final - Orientação a Objetos
_Tema -> Sistema de Gerenciamento de Lucros de uma Empresa_

## Objetivo 
Uma empresa busca controlar seus lucros de maneira digital. Para isso, ela analisa o lucro de cada uma de suas filiais. Para se obter o lucro, basta analisar as ocorrências no histórico de cada filial, os quais podem ser vendas, compras e pagamento de funcionários. Vale ressaltar que essas empresas fazem compras e vendas com parceiros e venda aos clientes.

## Esquema de Classes
<a href="https://github.com/tetenc555/trabOrientObj/blob/main/classes.mdj"><img src="https://github.com/tetenc555/trabOrientObj/blob/main/printUML.png" width="500px" height="auto" /></a>
>_Clique para redirecionar ao UML! Construído via StarUML._

## Pontos Importantes

### Classe Clientes
* Desconto de 10% se forem Fidelidade (boolean)
* A cada 10 compras tomam 2% de desconto, sendo cumulativo (int)
* Na 52th compra, o número de compras deve se resetar (ao invés de contar 53, voltará para 1, pois esta ainda conta uma compra válida). Ou seja, apenas uma venda será efetuada com 5 vezes o desconto cumulativo. A partir disso o contador reseta.
* tornarFidelidade deve reportar se já é fidelidade, ou se tornou em fidelidade, usando set para guardar o objeto.
* Sempre que uma vendaVarejo for instanciada, deve se somar uma compra ao cliente, sendo que esta não deve ser válida para aplicação do desconto no momento desta venda.

### Classe Parceiro
* anosParceira (int) definem quantos anos há da parceria
* O desconto base entre parceiros é sempre de 10%
* Soma-se mais 2% por cada ano de parceria, limitado a 5 anos. Caso ultrapasse, o desconto será apenas de mais 10%.
* a Compra dá um prejuízo menor pois seu valor é reduzido, mas a venda também dá menos lucro

### Classe Funcionário
* Sempre declara tipo false (prejuízo)
* Recebe salarioBase - descontos + quantDepAbono
* quantDepAbono calcula o abono de dependentes. Ou seja, a quant de dependentes com idade menor a 18 * 150,00.
* Retorna este valor a folha de Pagamento, por meio de calcularSalarioIndividual()
* OBS calcularValorFinal() na folha de pagamento usa calcularSalarioIndividual()

### Classe Filial
- imprimirHistorico usa imprimirDetalhado, função do Historico que imprime as descrições da ocorrência no modelo “Prejuízo/Lucro de R$**,** - ”” Incluindo descrição e separador (hífen) apenas caso haja descrição
- imprimirApenasDiscriminativo apenas usa retornarTexto para imprimir as descrições
- obterLucroFinal deve calcular o Lucro da filial a partir de seu histórico


### Classe Empresa
- calcularLucroAtual deve calcular o lucro de todas as filiais e salvar em lucroAtual
- comparacaoDeLucros deve imprimir no modelo “Em comparação ao período anterior, foi obtido prejuízo/lucro de R$**,**” ou “Não houve mudança entre os dois períodos.”

### Classe Ocorrência e OcorrênciaProduto
* Ocorrência é pai, ou seja, todas ocorrências possuem valorFinal, descrição e tipo (true para lucro, false para prejuízo). Por isso, retorna positivo em caso de true e negativo em caso de false, pela função retornarValorFinal.
* OcorrênciaProduto define propriedades apenas utilizadas para as ocorrências envolvendo compra e venda de Produtos
* OcorrenciaProduto determina erro se o estoque é negativo, se qtdOcorrencia é menor igual a 0, ou se a ocorrência não é válida (qtdOcorrencia não pode ser maior que a quantidade disponível no estoque)
* A ocorrênciaProduto determina estoque do produto, junto da qtdOcorrencia. Já seus filhos determinam calcularDesconto para uso no calcularValorFinal. Os filhos também determinam remetente e destinatário e as funções retornarLocalEntrega e retornarLocalRemetente, abstratas de ocorrenciaProduto.

**OBS** 
* Por definição, vendaAtacado, filha de ocorrênciaProduto, só define qtdOcorrencias maiores que o valor mínimo! Se qtdOcorrencias for menor ou igual, retorna erro. 


## Consultas


1) Qual o estado em que se localiza a cidade de uma empresa?

2) Qual o país em que se localiza o estado da cidade de uma empresa?

3) Qual o lucro obtido no histórico das filiais da empresa?

4) Quantos dependentes de funcionários a folha de pagamento possui?

5) Quantos dependentes abonados de funcionários a folha de pagamento possui?

6) Qual o estado da cidade de um funcionário? 

7) Qual o país em que se localiza o estado da cidade de um funcionário?

8) Quantos dependentes possui o coordenador local de uma filial?

9) Quantos dependentes abonados possui o coordenador local de uma filial? 

10) Remova todos os funcionários da folha de pagamento.

11) Qual o estado de entrega de uma venda no atacado?

12) Qual o país de entrega de uma venda no atacado?

13) Qual a cidade de entrega de uma compra no atacado?

14) Qual o estado de entrega de uma compra no atacado?

15) Qual o país de entrega de uma compra no atacado?

16) Qual a cidade do remetente de uma compra no atacado?

17) Qual o estado do remetente de uma compra no atacado?

18) Qual o país do remetente de uma compra no atacado?

19) Qual o discriminativo do histórico de uma filial?

20) Qual o lucro obtido no histórico de uma filial? 


