## Explicação e exemplos das classes Java de estruturas de dados de:

### Vector:

Guarda dados em um array dinâmico baseado em índice  
É considerado uma implementação velha de um array dinâmico, sendo assim recomendado o uso de ArrayList em vez dessa classe  
Ex:  
Uma lista de compra pode ser programada com Vector, com cada item tendo o seu índice e novos itens podendo ser adicionados com vector.add(item)

### ArrayList:

Guarda dados em um array dinâmico baseado em índice  
É considerado uma implementação mais nova de um array dinâmico, sendo assim recomendado o uso dessa classe em vez de Vector  
Ex:  
Uma lista de itens em um inventário qualquer pode ser programada usando ArrayList, onde cada item tem seu índice e novos itens podem ser adicionados com arrayList.add(item)

### LinkedList:

Guarda objetos que contém dentro deles dados e o endereço do próximo e do último objeto  
Por causa dessa estrutura de endereços ligados, adicionar e remover dados na lista é muito rápido  
Ex:  
Uma lista de atividades diárias pode ser programada com LinkedList, com cada atividade levando a uma próxima, e com a ordêm das atividades podendo ser facilmente mudada

### HashMap:

Guarda dados ligados a uma chave hasheada  
A chave pode ser qualquer outra classe Java, que então sera transformada em um hash na hora de pegar algum dado  
Chaves não podem ser duplicadas  
Por causa dessa estrutura de chaves, o HashMap consegue selecionar dados extremamente rápidos, especialmente quando se usa chaves que são facilmente hasheadas, como Integer  
Ex:  
Uma lista de nomes ligados a endereços pode ser programada com HashMap, com os nomes (String) sendo as chaves e os endereços (String) sendo os valores, e com itens podendo ser selecionados com hashmap.get(chave)
***